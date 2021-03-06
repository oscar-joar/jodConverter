package com.myTest.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myTest.demo.service.OfficeService;

@RestController
@RequestMapping(value = "/api/jod")
public class JodController {

	private final OfficeService officeService;

	public JodController(OfficeService officeService) {
		this.officeService = officeService;
	}

	@GetMapping(value = "/convert", produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public ResponseEntity<Void> view(HttpServletResponse response) throws Exception {
		officeService.convertToPdf(response);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
