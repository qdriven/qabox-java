package io.fluent.qabox.dao.model;

import lombok.Data;

@Data
public class ApiTestCase extends NamedApi {
  private String uri;
  private String method;
  private String body;
  private String expectedResult;
  private String priority;
}
