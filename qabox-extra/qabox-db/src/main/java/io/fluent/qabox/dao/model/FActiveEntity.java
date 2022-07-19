package io.fluent.qabox.dao.model;

import cn.hutool.db.ActiveEntity;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;

public class FActiveEntity extends ActiveEntity {

  public FActiveEntity(Db db, String tableName) {
    super(db, tableName);
  }

  public FActiveEntity(Db db, Entity entity) {
    super(db, entity);
  }
}
