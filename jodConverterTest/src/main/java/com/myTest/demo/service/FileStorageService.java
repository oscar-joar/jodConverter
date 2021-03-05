package com.myTest.demo.service;

import org.apache.tomcat.util.http.fileupload.FileItemStream;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * Service to access resources.
 */
public interface FileStorageService {

  /**
   * Add a new file into folder. It has to be used after method init.
   *
   * @param file     to add.
   * @param folder   to pass in.
   * @param filename to pass in.
   * @throws Exception IOException.
   */
  public void add(FileItemStream file, Path folder, String filename) throws Exception;

  /**
   * Deletes a file.
   *
   * @param container file's folder.
   * @param filename  UUI file's name.
   */
  public void delete(Path container, String filename) throws IOException;

  /**
   * Returns an input stream of a resource.
   *
   * @param path resource's path.
   * @return input stream of bytes.
   * @throws IOException in case of an I/O error.
   */
  public InputStream content(Path path) throws IOException;

}
