package io.fluent.qabox.dao.model;

import lombok.Data;

@Data
public class ApiTestCase {
  private String moduleName;
  private String name;
  private String service;
  private String uri;
  private String method;
  private String body;
  private String expectedResult;
  private String priority;
}
