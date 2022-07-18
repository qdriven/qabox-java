package io.fluent.qabox.excel.model;

import com.poiji.annotation.ExcelCellName;
import lombok.Data;

@Data
public class ApiTestCase {
    @ExcelCellName("module_name")
    private String moduleName;
    @ExcelCellName("name")
    private String name;
    @ExcelCellName("service_name")
    private String service;
    @ExcelCellName(value = "uri",mandatory = false)
    private String uri;
    @ExcelCellName("suite_name")
    private String method;
    @ExcelCellName("input")
    private String body;
    @ExcelCellName("expected")
    private String expectedResult;
    @ExcelCellName("priority")
    private String priority;
}
