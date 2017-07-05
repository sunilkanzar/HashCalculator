package com.crypto.alogrithm.hash.checksums;

import com.crypto.alogrithm.hash.crc.Checksum;

/**
 * Base class to generate sum for {@code SumXX} algorithm
 *
 * @author Sunil Kanjar
 */
public abstract class Sum extends Checksum {

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
	public abstract long getHash();

}
