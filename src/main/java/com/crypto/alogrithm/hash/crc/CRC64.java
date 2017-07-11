package com.crypto.alogrithm.hash.crc;

/**
 * Implementation of 64 bit CRC
 * <br>For more information
 * {@link https://en.wikipedia.org/wiki/Cyclic_redundancy_check}
 *
 *
 * @author Sunil Kanjar
 */
public final class CRC64 extends Checksum {

	/**
	 * Hashed lookup table for 64 bit CRC
	 */
	private static final long[] LOOKUPTABLE;

	static {
		LOOKUPTABLE = new long[0x100];
		for (int i = 0; i < 0x100; i++) {
			long v = i;
			for (int j = 0; j < 8; j++) {
				if ((v & 1) == 1) {
					v = (v >>> 1) ^ 0xD800000000000000l;
				} else {
					v = (v >>> 1);
				}
			}
			LOOKUPTABLE[i] = v;
		}
	}

	/**
	 * it will update hash with passed {@code byte data} and return new hash
	 *
	 * @param data byte data to add in hash
	 */
	@Override
	public void update(byte data) {
		int lookupidx = ((int) hash ^ data) & 0xff;
		hash = (hash >>> 8) ^ LOOKUPTABLE[lookupidx];
	}

	/**
	 * Return {@code int} length of hash
	 *
	 * @return The length of hash in bit
	 */
	@Override
	public int getLength() {
		return 64;
	}

}
