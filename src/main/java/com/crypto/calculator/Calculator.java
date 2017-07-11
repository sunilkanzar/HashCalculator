package com.crypto.calculator;

import com.crypto.alogrithm.hash.crc.Checksum;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author skanjar
 */
public class Calculator {

	private final Checksum algo;

	/**
	 * Create Calculator object for
	 * {@code com.crypto.alogrithm.hash.crc.Checksum} type implementation
	 *
	 * @param algo implementation of hash algorithm
	 * {@code extends com.crypto.alogrithm.hash.crc.Checksum}
	 */
	public Calculator(Checksum algo) {
		algo.resetAlgorithm();
		this.algo = algo;
	}

	/**
	 * Return {@code int} BSDChecksum value of passed {@code String} object
	 *
	 * @param data text to hash in {@code String} object form
	 * @return hash in {@code int} form
	 */
	public long calculate(String data) {
		algo.resetAlgorithm();
		if (data == null) {
			return algo.getHash();
		}
		return calculate(data.getBytes());
	}

	/**
	 * Return {@code int} BSDChecksum value of passed {@code File} object
	 *
	 * @param dataFile file to hash in {@code File} object
	 * @return hash in {@code int} form
	 * @throws IOException
	 */
	public long calculate(File dataFile) throws IOException {
		algo.resetAlgorithm();
		if (dataFile == null || !dataFile.exists() || !dataFile.isFile()) {
			return algo.getHash();
		}
		return calculate(new FileInputStream(dataFile));
	}

	/**
	 * Return {@code int} calculated value of passed {@code byte[]}
	 *
	 * @param data value to hash in {@code byte[]} form
	 * @return hash in {@code int} form
	 */
	public long calculate(byte data[]) {
		algo.resetAlgorithm();
		if (data == null) {
			return algo.getHash();
		}
		for (byte b : data) {
			algo.update(b);
		}
		return algo.getHash();
	}

	/**
	 * Return {@code int} calculated value of passed {@code InputStream}
	 *
	 * @param data value to hash in {@code InputStream} object
	 * @return
	 * @throws IOException
	 */
	public long calculate(InputStream data) throws IOException {
		algo.resetAlgorithm();
		if (data == null) {
			return algo.getHash();
		}
		byte b[] = new byte[1];
		while (data.read(b) != -1) {
			algo.update(b[0]);
		}
		return algo.getHash();
	}

	public String toBinaryString() {
		HashResult result = new HashResult(algo.getHash(), algo.getLength());
		return result.getValue() instanceof Long ? Long.toBinaryString(result.longValue()) : Integer.toBinaryString(result.intValue());
	}

	public String toOctalString() {
		HashResult result = new HashResult(algo.getHash(), algo.getLength());
		return result.getValue() instanceof Long ? Long.toOctalString(result.longValue()) : Integer.toOctalString(result.intValue());
	}

	public String toDecimalString() {
		HashResult result = new HashResult(algo.getHash(), algo.getLength());
		return result.getValue() instanceof Long ? Long.toString(result.longValue()) : Integer.toString(result.intValue());
	}

	public String toHexString() {
		HashResult result = new HashResult(algo.getHash(), algo.getLength());
		return result.getValue() instanceof Long ? Long.toHexString(result.longValue()) : Integer.toHexString(result.intValue());
	}
}
