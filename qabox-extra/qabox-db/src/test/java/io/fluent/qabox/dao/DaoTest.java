package io.fluent.qabox.dao;

import cn.hutool.db.ActiveEntity;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.setting.Setting;
import io.fluent.qabox.dao.model.ApiDefinition;
import io.fluent.qabox.dao.model.FActiveEntity;
import io.fluent.qabox.dao.model.FEntity;
import io.fluent.qabox.supplement.config.FConfig;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static io.fluent.qabox.dao.constants.DefaultConstants.POSTGRESQL;


/**
 * 1. 数据库连接管理
 * 2. SQL 操作
 * 3. 单表操作/实体操作
 * 4. ActiveEntity操作
 * 5. Database 操作 Accessor
 */
public class DaoTest {

  @Test
  public void setupDataSource() throws SQLException {
    Setting ds = Setting.create();
    ds.set(
        "url", "jdbc:postgresql://127.0.0.1:7432/test_hub"
      ).set("user", "postgres").set("pass", "changeit")
      .set("driver", "org.postgresql.Driver");

    List result = Db.use(DSFactory.create(ds).getDataSource())
      .findAll("api");
    System.out.println(result);
  }

  @Test
  public void testUseSetting() throws SQLException {
    Setting config = FConfig.create().getConfigSet("postgresql");
    List result = Db.use(DSFactory.create(config).getDataSource())
      .findAll("api");
    System.out.println(result);
  }

  /**
   * TODO:
   * Demos for
   * - Insert
   * - Update
   * - Delete
   * - Complex SQL for Query/Update
   * - SQL with parameters
   * - Page Query
   * - For Transaction
   */

  @Test
  public void test_FDao() throws SQLException {
    FDao dao = new FDao(new FDaoConfig());
    dao.setDb(POSTGRESQL);
    System.out.println(dao);
    ApiDefinition api = new ApiDefinition();
    api.setModuleName("test");
    api.setService("test");
    dao.db.insert(
      Entity.parseWithUnderlineCase(api).setTableName("api"));

    int result = dao.addOrUpdate( //bug here
     "api",api
    );
    System.out.println(result);
    FDaoAccessor accessor =FDaoAccessor.create(new FDaoConfig());
    accessor.getDao().addOrUpdate("api",api);
  }


}