package io.fluent.qabox.dao;


import cn.hutool.db.DaoTemplate;
import cn.hutool.db.Db;
import io.fluent.qabox.dao.model.FActiveEntity;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * All Db Dao Accessor:
 * - Hold all the DaoTemplates
 * - Hold all the datasource
 * - Hold all the DbConfiguration
 * - Hold all the ActiveEntity
 */
public class FDaoAccessor {
  FDaoConfig config;
  Db db;
  DataSource ds;
  Map<String, DaoTemplate> tableDaoTemplates = new ConcurrentHashMap<>();
  Map<String, FActiveEntity> fActiveEntityMap = new ConcurrentHashMap<>();

  public FDaoAccessor(FDaoConfig config, String dbName) {

    this.config = config;
    this.ds = this.config.getDataSource(dbName);
    this.db = Db.use(this.ds);
  }

  public static FDaoAccessor create(FDaoConfig config, String dbConfigGroup) {
    return new FDaoAccessor(config, dbConfigGroup);
  }

  public static FDaoAccessor create(FDaoConfig config) {
    return new FDaoAccessor(config, "postgresql");
  }

  public static FDaoAccessor create() {
    return new FDaoAccessor(new FDaoConfig(), "postgresql");
  }

  public List findAll(String tableName) {
    try {
      return this.db.findAll(tableName);
    } catch (SQLException e) {
      return Collections.emptyList();
    }
  }

  public List query(String query, Map<String, Object> paramMap) {
    try {
      return this.db.query(query, paramMap);
    } catch (SQLException e) {
      return Collections.emptyList();
    }
  }

  public Db getDb() {
    return db;
  }

  public DaoTemplate getTableDao(String table) {
    if (this.tableDaoTemplates.get(table) == null) {
      this.tableDaoTemplates.put(table,
        new DaoTemplate(table, this.ds));
    }
    return this.tableDaoTemplates.get(table);
  }

}
