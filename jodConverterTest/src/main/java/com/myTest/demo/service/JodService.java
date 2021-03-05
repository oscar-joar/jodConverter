package com.myTest.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public interface JodService {

  /**
   * Create a new stream in the target media type.
   *
   * @param inputStream     stream to convert.
   * @param targetExtension target media type.
   * @return a converted stream.
   * @throws Exception IOException when file errors.
   */
  public ByteArrayOutputStream convert(InputStream inputStream, String targetExtension)
      throws Exception;

}
