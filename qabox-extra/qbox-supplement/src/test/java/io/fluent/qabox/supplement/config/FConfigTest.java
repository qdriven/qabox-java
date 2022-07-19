package io.fluent.qabox.supplement.config;

import cn.hutool.setting.Setting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FConfigTest {

  @Test
  void create() {
    FConfig config = FConfig.create();
    Map result = config.getSetting().getGroupedMap();
    System.out.println(result);
  }

  @Test
  void testCreate() {
    FConfig config = FConfig.create();
    Setting setting = config.getConfigSet("postgresql");
    assertEquals(setting.get("user"), "postgres");
    assertEquals(setting.get("pass"), "changeit");

  }
}