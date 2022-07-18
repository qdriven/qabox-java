package io.fluent.qabox.dao;


import cn.hutool.db.ds.DSFactory;
import cn.hutool.setting.Setting;
import io.fluent.qabox.supplement.config.FConfig;

import javax.sql.DataSource;

public class FDaoConfig {

  FConfig config;
  private static String DB_GROUP = "DB";

  public FDaoConfig() {
    this.config = FConfig.create();
  }

  public FDaoConfig(String configPath) {
    this.config = FConfig.create(configPath);
  }

  public DataSource getDataSource(String settingName) {
    Setting config = FConfig.create().getConfigSet(settingName);
    return DSFactory.create(config).getDataSource();
  }

  public DataSource getDataSource() {
    return getDataSource(DB_GROUP);
  }
}
