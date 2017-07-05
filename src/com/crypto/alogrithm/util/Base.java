package com.crypto.alogrithm.util;

/**
 * Base enumeration for number system
 *
 * @author Sunil Kanjar
 */
public enum Base {
	BIN(2),
	OCTAL(8),
	DECIMAL(10),
	HEXADECIMAL(16);

	/**
	 * Number system base
	 */
	private final int baseValue;

	/**
	 * Create number system using {@code baseValue}
	 *
	 * @param baseValue base for number system
	 */
	private Base(int baseValue) {
		this.baseValue = baseValue;
	}

	/**
	 * Return base value for current number system
	 *
	 * @return {@code baseValue}
	 */
	public int getBaseValue() {
		return baseValue;
	}
}
