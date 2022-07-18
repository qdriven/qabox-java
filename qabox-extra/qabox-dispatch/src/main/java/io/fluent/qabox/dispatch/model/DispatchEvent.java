package io.fluent.qabox.dispatch.model;

import lombok.Data;

import java.util.Map;

@Data
public class DispatchEvent {

  private String service;
  private String method;
  private Map<String, Object> args;
  private Map<String, Object> contextData;
}
