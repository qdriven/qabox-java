package io.fluent.qabox.excel.provider;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import io.fluent.qabox.excel.FExcelOption;
import io.fluent.qabox.excel.exception.ExcelException;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PoijiExcelProvider implements FExcelProvider {

  PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
    .setLocale(Locale.getDefault())
    .build();

  @Override
  public <T> List<T> read(String filePath, Class<T> beanType, FExcelOption excelOption) {
    return Poiji.fromExcel(new File(filePath), beanType, this.options);
  }

  @Override
  public List<Map<String, Object>> readForMap(String path, FExcelOption excelOption) {
    throw new ExcelException("readForMap is not implemented in PoijiExcelProvider yet");
  }

  @Override
  public <T> void write(String path, Class<T> beanType, List<T> data, FExcelOption excelOption) {
    throw new ExcelException("Not Implemented Yet for Write Function");
  }
}
