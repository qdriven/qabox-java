package io.fluent.qboxserver.demo.model;


import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.ViewType;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Erupt(name = "表格示例")
@Table(name = "demo_table")
@Entity
public class TableDemo extends BaseModel {

    @EruptField(
            views = {
                    @View(title = "二维码", type = ViewType.QR_CODE),
                    @View(title = "链接", type = ViewType.LINK),
                    @View(title = "链接（对话框）", type = ViewType.LINK_DIALOG)
            },
            edit = @Edit(title = "链接",
            search = @Search)
    )
    private String link;

    @org.hibernate.annotations.Type(type = "org.hibernate.type.TextType")
    @Lob
    @EruptField(
            views = {
                    @View(title = "HTML", type = ViewType.HTML),
                    @View(title = "HTML（手机端）", type = ViewType.MOBILE_HTML)
            },
            edit = @Edit(title = "HTML", type = EditType.HTML_EDITOR)
    )
    private String html;


    @EruptField(
            views = {
                    @View(title = "打开附件", type = ViewType.ATTACHMENT),
                    @View(title = "附件（对话框）", type = ViewType.ATTACHMENT_DIALOG),
                    @View(title = "附件下载", type = ViewType.DOWNLOAD),
            },
            edit = @Edit(title = "上传附件", type = EditType.ATTACHMENT)
    )
    private String attachment;


    @EruptField(
            views = @View(title = "代码", type = ViewType.CODE),
            edit = @Edit(title = "代码(Java)", type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "java"))
    )
    private String code;

}