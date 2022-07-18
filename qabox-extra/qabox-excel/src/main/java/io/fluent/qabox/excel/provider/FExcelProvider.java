package io.fluent.qabox.excel.provider;

import io.fluent.qabox.excel.FExcelOption;
import io.fluent.qabox.excel.exception.ExcelException;
import io.fluent.qabox.excel.handler.FExcelHandler;

import java.util.List;
import java.util.Map;

public interface FExcelProvider {
  <T> List<T> read(String path, Class<T> beanType, FExcelOption excelOption);

  List<Map<String, Object>> readForMap(String path, FExcelOption excelOption);

  <T> void  write(String path, Class<T> beanType, List<T> data, FExcelOption excelOption);

  default <T> List<T> readWithHandlers(String path, Class<T> beanType, FExcelOption excelOption, FExcelHandler... handers) {
    throw new ExcelException("Not Implemented Yet");
  }

  default <T> void writeWithHandlers(String path, Class<T> beanType, FExcelOption excelOption, FExcelHandler... handers) {
    throw new ExcelException("Not Implemented Yet");
  }

}
