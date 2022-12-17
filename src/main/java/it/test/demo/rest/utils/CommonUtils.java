package it.test.demo.rest.utils;

import org.springframework.http.HttpHeaders;

public final class CommonUtils {
	public static final HttpHeaders httpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("X-Time-Zone", "Europe/Rome");
		return responseHeaders;
	}
}
