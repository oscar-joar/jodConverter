
package com.myTest.demo.service;

import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Service to access resources.
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {

  @Override
  public void add(FileItemStream file, Path path, String filename) throws Exception {
    if (Files.notExists(path)) {
      Files.createDirectories(path);
    }

    InputStream stream = file.openStream();
    if (file.isFormField()) {
      throw new Exception("File is a form field!");
    }
    // Process the input stream
    Files.copy(stream, path.resolve(filename));
    stream.close();
  }

  @Override
  public void delete(Path container, String filename) throws IOException {
    Files.deleteIfExists(Paths.get(container.toString(), filename));
  }

  @Override
  public InputStream content(Path path) throws IOException {
    return new FileInputStream(path.toFile());
  }
}
