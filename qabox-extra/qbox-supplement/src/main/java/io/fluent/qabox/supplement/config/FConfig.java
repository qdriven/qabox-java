package io.fluent.qabox.supplement.config;


import cn.hutool.setting.Setting;

public class FConfig {
  Setting setting;

  private FConfig() {
  }

  private final static String DEFAULT_SETTING_PATH = "config/app.setting";

  public static FConfig create() {
    return create(DEFAULT_SETTING_PATH);
  }

  public static FConfig create(String settingPath) {
    FConfig config = new FConfig();
    config.setting = new Setting(settingPath);
    config.setting.autoLoad(true);
    return config;
  }

  public Setting getSetting() {
    return setting;
  }

  public Setting getConfigSet(String groupName) {
    return this.setting.getSetting(groupName);
  }
}
