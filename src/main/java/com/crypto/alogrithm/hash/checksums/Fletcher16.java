package com.crypto.alogrithm.hash.checksums;

/**
 * Implementation of 16 bit Fletcher
 *
 * @author Sunil Kanjar
 */
public class Fletcher16 extends Fletcher {

	/**
	 * It creates Fletcher object with some initial value
	 */
	public Fletcher16() {
		maxBit = 0xffff - 1;
	}

	/**
	 * Return {@code int} length of hash
	 *
	 * @return The length of hash in bit
	 */
	@Override
	public int getLength() {
		return 16;
	}
}
