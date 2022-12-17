package it.test.demo.rest.enums;

public enum HeadersExternal {
	AUTH_SCHEMA("Auth-Schema"), API_KEY("Api-Key"), ID_CHIAVE("Id-chiave"), ID_ACCOUNT("accountId"), X_TIME_ZONE("X-Time-Zone");

	private String desc;

	private HeadersExternal(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
}
