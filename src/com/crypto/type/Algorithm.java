package com.crypto.type;

/**
 *
 * @author Sunil
 */
public enum Algorithm {
	BSD(FunctionType.CRC, "BSD checksum"),
	CRC16(FunctionType.CRC, "CRC-16"),
	CRC32(FunctionType.CRC, "CRC-32"),
	CRC64(FunctionType.CRC, "CRC-64"),
	SYSV(FunctionType.CRC, "SYSV checksum"),
	SUM8(FunctionType.SUM, "SUM-8"),
	SUM16(FunctionType.SUM, "SUM-16"),
	SUM24(FunctionType.SUM, "SUM-24"),
	SUM32(FunctionType.SUM, "SUM-32"),
	FLETCHER4(FunctionType.SUM, "Fletcher-4"),
	FLETCHER8(FunctionType.SUM, "Fletcher-8"),
	FLETCHER16(FunctionType.SUM, "Fletcher-16"),
	FLETCHER32(FunctionType.SUM, "Fletcher-32"),
	ADLER(FunctionType.SUM, "Adler-32"),
	PEARSON(FunctionType.SUM, "Pearson"),
	XOR8(FunctionType.SUM, "XOR8"),;

	private final FunctionType functionType;
	private final String name;

	private Algorithm(FunctionType functionType, String name) {
		this.functionType = functionType;
		this.name = name;
	}

	public Function getFunction() {
		return functionType.getFunction();
	}

	public FunctionType getFunctionType() {
		return functionType;
	}

	public String getName() {
		return name;
	}

	public static Algorithm findByName(String name) {
		for (Algorithm algorithm : Algorithm.values()) {
			if (algorithm.getName().equals(name)) {
				return algorithm;
			}
		}
		return null;
	}
}
