package io.fluent.qabox.dao.model;

import lombok.Data;

@Data
public class ApiDefinition extends NamedApi {

  private String uri;
  private String method;
  private String body;
  private String type;
}
