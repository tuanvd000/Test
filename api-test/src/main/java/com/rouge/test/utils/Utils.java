package com.rouge.test.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utils {

	public static ResponseEntity<?> generateSuccessResponse(Object responseData) {
		ResponseStatus status = new ResponseStatus(200, "Successful");
		ResponseBody body = new ResponseBody(status, responseData);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
	public static ResponseEntity<?> generateFailedResponse(Object responseData) {
		ResponseStatus status = new ResponseStatus(500, "Server Error");
		ResponseBody body = new ResponseBody(status, responseData);
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
