package io.fluent.qboxserver.api;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "apitest_cases")
@Erupt(
        name = "接口列表"
)
public class ApiTestCase extends HyperModel {
    @EruptField(
            views = @View(title = "测试用例名称"),
            edit = @Edit(title = "测试用例名称", notNull = true, search = @Search)
    )
    private String name;

    private String moduleName;
    @EruptField(
            views = @View(title = "服务"),
            edit = @Edit(title = "服务", notNull = true, search = @Search)
    )
    private String service;
    @EruptField(
            views = @View(title = "地址"),
            edit = @Edit(title = "地址", notNull = true, search = @Search)
    )
    private String uri;
    @EruptField(
            views = @View(title = "方法"),
            edit = @Edit(title = "方法", notNull = true, search = @Search)
    )
    private String method;
    @EruptField(
            views = @View(title = "报文"),
            edit = @Edit(title = "报文")
    )
    private String body;

    @EruptField(
            views = @View(title = "期望结果"),
            edit = @Edit(title = "期望结果")
    )
    private String expectedResult;

    @EruptField(
            views = @View(title = "优先级"),
            edit = @Edit(title = "优先级")
    )
    private String priority;
}
