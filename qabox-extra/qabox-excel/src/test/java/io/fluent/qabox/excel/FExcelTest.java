package io.fluent.qabox.excel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FExcelTest {
  @Test
  public void test_create(){
      FExcel excel = FExcel.create();
    Assertions.assertNotNull(excel.getProvider());
  }
}