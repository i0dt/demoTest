package it.test.demo.rest.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import it.test.demo.rest.errorHandler.RespErrorHandler;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "external-config")
public class ExternalConfig {
	private String baseUrl;
	private String authSchema;
	private String apiKey;
	private String idChiave;
	private String accountId;
	private ExternalServiceUrl externalServiceUrl;
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new RespErrorHandler());
		return restTemplate;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl the baseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * @return the authSchema
	 */
	public String getAuthSchema() {
		return authSchema;
	}

	/**
	 * @param authSchema the authSchema to set
	 */
	public void setAuthSchema(String authSchema) {
		this.authSchema = authSchema;
	}

	/**
	 * @return the apiKey
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey the apiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 * @return the idChiave
	 */
	public String getIdChiave() {
		return idChiave;
	}

	/**
	 * @param idChiave the idChiave to set
	 */
	public void setIdChiave(String idChiave) {
		this.idChiave = idChiave;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the externalServiceUrl
	 */
	public ExternalServiceUrl getExternalServiceUrl() {
		return externalServiceUrl;
	}

	/**
	 * @param externalServiceUrl the externalServiceUrl to set
	 */
	public void setExternalServiceUrl(ExternalServiceUrl externalServiceUrl) {
		this.externalServiceUrl = externalServiceUrl;
	}

	@Override
	public String toString() {
		return "ExternalConfig [baseUrl=" + baseUrl + ", authSchema=" + authSchema + ", apiKey=" + apiKey + ", idChiave=" + idChiave + ", accountId=" + accountId + ", externalServiceUrl=" + externalServiceUrl + "]";
	}
}
