package com.crypto.alogrithm.hash.checksums;

/**
 * Implementation of 4 bit Fletcher
 *
 * @author Sunil Kanjar
 */
public class Fletcher4 extends Fletcher {

	/**
	 * It creates Fletcher object with some initial value
	 */
	public Fletcher4() {
		maxBit = 0xf - 1;
	}

	/**
	 * Return {@code int} length of hash
	 *
	 * @return The length of hash in bit
	 */
	@Override
	public int getLength() {
		return 4;
	}

}
