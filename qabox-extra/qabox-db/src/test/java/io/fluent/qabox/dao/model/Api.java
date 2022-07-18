package io.fluent.qabox.dao.model;

import lombok.Data;

@Data
public class Api {
  private String productName;
  private String moduleName;
  private String service;
  private String uri;
  private String method;
  private String body;
  private String type;
}
