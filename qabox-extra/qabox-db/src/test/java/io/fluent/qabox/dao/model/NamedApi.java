package io.fluent.qabox.dao.model;

import lombok.Data;

@Data
public class NamedApi {
  private String name;
  private String productName;
  private String moduleName;
  private String service;
}
