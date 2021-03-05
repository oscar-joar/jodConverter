
package com.myTest.demo.configuration;

import org.jodconverter.core.DocumentConverter;
import org.jodconverter.core.document.DocumentFormatRegistry;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.local.LocalConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure the media converter.
 */
@Configuration
public class JodConfiguration {

  @Bean
  DocumentConverter localDocumentConverter(OfficeManager localOfficeManager,
      DocumentFormatRegistry documentFormatRegistry) {

    return LocalConverter
        .builder()
        .filterChain(new JodFilter(true))
        .officeManager(localOfficeManager)
        .formatRegistry(documentFormatRegistry)
        .build();
  }

}
