package com.crypto.calculator;

import com.crypto.alogrithm.hash.crc.Checksum;
import com.crypto.alogrithm.util.Base;
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

	public String toString(Base base) {
		HashResult result = new HashResult(algo.getHash(), algo.getLength());
		String hash;
		if (result.getValue() instanceof Long) {
			hash = Long.toString(result.longValue(), base.getBaseValue());
		} else {
			hash = Integer.toString(result.intValue(), base.getBaseValue());
		}
		if(hash.startsWith("-")) {
			hash = hash.substring(1);
		}
		return hash;
	}
}
