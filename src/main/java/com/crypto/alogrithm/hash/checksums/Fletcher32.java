package com.crypto.alogrithm.hash.checksums;

/**
 * Implementation of 32 bit Fletcher
 *
 * @author Sunil Kanjar
 */
public class Fletcher32 extends Fletcher {

	/**
	 * It creates Fletcher object with some initial value
	 */
	public Fletcher32() {
		maxBit = 0xffffffffL - 1;
	}

	/**
	 * Return {@code int} length of hash
	 *
	 * @return The length of hash in bit
	 */
	@Override
	public int getLength() {
		return 32;
	}

}
