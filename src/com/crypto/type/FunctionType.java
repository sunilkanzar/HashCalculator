package com.crypto.type;

/**
 *
 * @author Sunil
 */
public enum FunctionType {
	CRC(Function.HASH, "Cyclic redundancy checks"),
	SUM(Function.HASH, "Checksums"),
	UNIVERSAL(Function.HASH, "Universal hash function families"),
	NON_CRYPTOGRAPHIC(Function.HASH, "Non-cryptographic hash functions"),
	KEYED_CRYPTOGRAPHIC(Function.HASH, "Keyed cryptographic hash functions"),
	UNKEYED_CRYPTOGRAPHIC(Function.HASH, "Unkeyed cryptographic hash functions");
	private final String name;
	private final Function function;

	private FunctionType(Function function, String name) {
		this.function = function;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Function getFunction() {
		return function;
	}
}
