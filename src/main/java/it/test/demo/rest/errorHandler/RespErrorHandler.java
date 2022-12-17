package it.test.demo.rest.errorHandler;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RespErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError());
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
	}
}