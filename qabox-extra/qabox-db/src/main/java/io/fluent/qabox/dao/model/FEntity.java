package io.fluent.qabox.dao.model;

import cn.hutool.db.Entity;

public class FEntity extends Entity {
  public static <T> Entity create(String tableName, T bean) {
    return Entity.create(tableName).parseBean(bean, true, true);
  }
}
