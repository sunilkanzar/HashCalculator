package com.crypto.alogrithm.hash.checksums;

/**
 * Implementation of 8 bit Fletcher
 *
 * @author Sunil Kanjar
 */
public class Fletcher8 extends Fletcher {

	/**
	 * It creates Fletcher object with some initial value
	 */
	public Fletcher8() {
		maxBit = 0xff - 1;
	}

	/**
	 * Return {@code int} length of hash
	 *
	 * @return The length of hash in bit
	 */
	@Override
	public int getLength() {
		return 8;
	}

}
