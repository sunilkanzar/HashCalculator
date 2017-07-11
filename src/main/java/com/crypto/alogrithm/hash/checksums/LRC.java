package com.crypto.alogrithm.hash.checksums;

import com.crypto.alogrithm.hash.crc.Checksum;

/**
 * Implementation of 8 bit Longitudinal redundancy check also known as XOR8<br>
 * For more information
 * {@link https://en.wikipedia.org/wiki/List_of_hash_functions} name is "XOR8"
 * algorithm at this link flip the bits at the and of algorithm that can be done
 * through {@code setFinalXorValue(0xff)}
 *
 * @author Sunil Kanjar
 */
public class LRC extends Checksum {

	/**
	 * It will update hash with passed {@code byte data} and return new hash
	 *
	 * @param data byte data to add in hash
	 */
	@Override
	public void update(byte data) {
		hash = (hash + data) & 0xFF;
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
