package com.crypto.alogrithm.hash.crc;

/**
 * Implementation of SYSV (Unix)
 * <br>For more information {@link https://en.wikipedia.org/wiki/SYSV_checksum}
 *
 * @author Sunil Kanjar
 */
public class SYSV extends Checksum {

	/**
	 * it will update hash with passed {@code byte data} and return new hash
	 *
	 * @param data byte data to add in hash
	 */
	@Override
	public void update(byte data) {
		hash += data & 0xFF;
	}

	/**
	 * Finalize the hash like XOR with {@code finalXorValue} and return the
	 * final hash.
	 *
	 * @return hash in {@code long} form
	 */
	@Override
	public long getHash() {
		long r = (hash & 0xffff) + (((hash & 0xffffffff) >> 16) & 0xffff);
		r = (r & 0xffff) + (r >> 16);
		return r ^ getFinalXorValue();
	}

	/**
	 * Return {@code int} length of hash.
	 *
	 * @return The length of hash in bit
	 */
	@Override
	public int getLength() {
		return 16;
	}

}
