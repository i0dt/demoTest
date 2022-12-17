package it.test.demo.rest.enums;

public enum ErrorEnum {
	XXX001("Custom Exception 1"), //
	XXX002("Custom Exception 2"), //
	ZZZ001("Service Unavailable"), //
	ZZZ002("Custom Server Exception 1"), //
	ZZZ003("Custom Server Exception 2"), //
	REQ004("Invalid account identifier"), //
	REQ010("Invalid request: wrong parameter(s)"), //
	REQ017("Invalid date format") //
	;
	
	private String desc;

	private ErrorEnum(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
}
