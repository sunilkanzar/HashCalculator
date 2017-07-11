package com.crypto.alogrithm.hash.checksums;

/**
 * Implementation of 32 bit Sum
 * <br>For more information {@link https://en.wikipedia.org/wiki/Checksum}
 *
 * @author Sunil Kanjar
 */
public class Sum32 extends Sum {

	/**
	 * Finalize the hash like XOR with {@code finalXorValue} and return the
	 * final hash.
	 *
	 * @return hash in {@code long} form
	 */
	@Override
	public long getHash() {
		return hash % 0x100000000L;
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
