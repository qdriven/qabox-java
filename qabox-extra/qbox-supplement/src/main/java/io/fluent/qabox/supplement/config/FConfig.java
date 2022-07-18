package io.fluent.qabox.supplement.config;


import cn.hutool.setting.Setting;

public class FConfig {
  Setting setting;
  private static String DEFAULT_SETTING = "config/fluent.setting";

  private FConfig() {
  }

  public static FConfig create() {
    return create(DEFAULT_SETTING);
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
