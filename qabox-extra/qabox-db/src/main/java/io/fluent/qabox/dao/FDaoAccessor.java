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

import static io.fluent.qabox.dao.constants.DefaultConstants.POSTGRESQL;

/**
 * All Db Dao Accessor:
 * - Hold all the DaoTemplates
 * - Hold all the datasource
 * - Hold all the DbConfiguration
 * - Hold all the ActiveEntity
 */
public class FDaoAccessor {
  FDaoConfig config;
  Map<String, FDao> daoMap = new ConcurrentHashMap<>();

  public FDaoAccessor(FDaoConfig config) {
    this.config = config;
  }

  public static FDaoAccessor create(FDaoConfig config) {
    return new FDaoAccessor(config);
  }

  public FDao getDao(String dbName) {
    if (daoMap.get(dbName) == null) {
      FDao dao = FDao.create(this.config, dbName);
      daoMap.put(dbName, dao);
      return dao;
    }
    return daoMap.get(dbName);
  }

  public FDao getDao() {
    if (daoMap.get(POSTGRESQL) == null) {
      FDao dao = FDao.create(this.config, POSTGRESQL);
      daoMap.put(POSTGRESQL, dao);
      return dao;
    }
    return daoMap.get(POSTGRESQL);
  }
}