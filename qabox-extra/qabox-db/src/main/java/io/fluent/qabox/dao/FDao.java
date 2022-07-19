package io.fluent.qabox.dao;

import cn.hutool.db.DaoTemplate;
import cn.hutool.db.Db;
import io.fluent.qabox.dao.model.FEntity;
import io.fluent.qabox.supplement.annotation.WithBug;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FDao {
  FDaoConfig config;
  Db db;
  DataSource ds;
  Map<String, DaoTemplate> tableDaoTemplates = new ConcurrentHashMap<>();

  public FDao(FDaoConfig config) {
    this.config = config;
  }

  public FDao(FDaoConfig config, String dbName) {
    this.config = config;
    this.setDb(dbName);
  }

  public static FDao create(FDaoConfig config, String dbName) {
    return new FDao(config, dbName);
  }

  public Db getDb() {
    return db;
  }

  public void setDb(String dbName) {
    this.ds = this.config.getDataSource(dbName);
    this.db = Db.use(ds);
  }

  public <T> int addOrUpdate(String tableName, T bean) throws SQLException {
    return this.getTableDao(tableName).addOrUpdate(FEntity.create(tableName, bean));
  }

  @WithBug(desc = "if table name is not same as class name, sql failed")
  public DaoTemplate getTableDao(String table) {
    if (this.tableDaoTemplates.get(table) == null) {
      this.tableDaoTemplates.put(table,
        new DaoTemplate(table, this.ds));
    }
    return this.tableDaoTemplates.get(table);
  }
}
