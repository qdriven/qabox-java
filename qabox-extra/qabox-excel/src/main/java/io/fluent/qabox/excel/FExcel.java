package io.fluent.qabox.excel;

import io.fluent.qabox.excel.provider.FExcelProvider;
import io.fluent.qabox.excel.provider.JavaxcelProvider;
import lombok.Data;

@Data
public class FExcel {
  FExcelProvider provider;
  FExcelOption option;

  public FExcel(FExcelProvider provider, FExcelOption option) {
    this.provider = provider;
    this.option = option;
  }

  public static FExcel create() {
    return new FExcel(new JavaxcelProvider(), new FExcelOption());
  }
}
