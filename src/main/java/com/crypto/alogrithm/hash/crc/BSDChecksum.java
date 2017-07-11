package com.crypto.alogrithm.hash.crc;

/**
 * BSDChecksum has been implemented in Berkeley Software Distribution.
 * <br>For more information {@link https://en.wikipedia.org/wiki/BSD_checksum}
 *
 * @author Sunil Kanjar
 */
public class BSDChecksum extends Checksum {

	/**
	 * it will update hash with passed {@code byte data} and return new hash
	 *
	 * @param data byte data to add in hash
	 */
	@Override
	public void update(byte data) {
		hash = (hash >> 1) + ((hash & 1) << 15);
		hash += data;
		hash &= 0xffff;
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
