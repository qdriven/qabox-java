package io.fluent.qabox.excel.model;

import com.poiji.annotation.ExcelCellName;
import io.fluent.qabox.excel.struct.WithUnknownCell;
import lombok.Data;

@Data
public class ApiDefinition extends WithUnknownCell {
    @ExcelCellName("productName")
    private String productName;
    @ExcelCellName("moduleName")
    private String moduleName;
    @ExcelCellName("service")
    private String service;
    @ExcelCellName("uri")
    private String uri;
    @ExcelCellName("method")
    private String method;
    @ExcelCellName("body")
    private String body;
    @ExcelCellName("type")
    private String type;
}
