package com.vmware.math.operation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.math.operation.model.MathVariable;
import com.vmware.math.operation.service.MathOperationService;

@RestController
@RequestMapping(path = "/api")
@Validated
public class MathOperationController {

	@Autowired(required = true)
	public MathOperationService mathOperationService;

	@GetMapping(path = "/get")
	public String getHello() {
		return "hello";
	}

	@PostMapping(path = "/add", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@Valid @RequestBody MathVariable mathVariable) {
		String result = mathOperationService.add(mathVariable.getX(), mathVariable.getY());
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@PostMapping(path = "/diff", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> diff(@Valid @RequestBody MathVariable mathVariable) {
		String result = mathOperationService.diff(mathVariable.getX(), mathVariable.getY());
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
