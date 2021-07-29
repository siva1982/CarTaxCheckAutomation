package com.carcheck.automation.browsers;

public enum Browsers {

	FIREFOX,
	CHROME,
	SAFARI,
	IE;

	public static Browsers toObtainBrowserInstance(String browser) throws IllegalArgumentException {

		for (Browsers b : values()) {
			if (b.toString().equalsIgnoreCase(browser)) {
				return b;
			}
		}
		throw browserNotFound(browser);
	}

	private static IllegalArgumentException browserNotFound(String browser) {

		return new IllegalArgumentException("Invalid browser [" + browser + "]");
	}
}