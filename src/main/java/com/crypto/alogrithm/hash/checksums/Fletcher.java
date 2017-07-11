package com.crypto.alogrithm.hash.checksums;

import com.crypto.alogrithm.hash.crc.Checksum;

/**
 * Base class to generate fletcher hash for {@code FletcherXX} algorithm<br>
 * All Fletcher under this this class not able to set initial hash value and not
 * able to set final XOR value<br>
 * For more information
 * {@link https://en.wikipedia.org/wiki/Fletcher%27s_checksum}
 *
 * @author Sunil Kanjar
 */
public abstract class Fletcher extends Checksum {

	/**
	 * Max length of hash bit
	 */
	protected long maxBit;

	/**
	 * Checksum1
	 */
	private long sum1;
	/**
	 * Checksum2
	 */
	private long sum2;

	/**
	 * it will update hash with passed {@code byte data} and return new hash
	 *
	 * @param data byte data to add in hash
	 */
	@Override
	public void update(byte data) {
		sum1 = (sum1 + data) % maxBit;
		sum2 = (sum2 + sum1) % maxBit;
	}

	/**
	 * Get the final hash.<br> Form of hash is {@code Checksum1+Checksum2} so
	 * first {@code X} number of bit is of {@code Checksum1} and then {@code X}
	 * number of bit for {@code Checksum2}.<br>
	 * Size of {@code X} is depend on Hash length of algorithm
	 *
	 * @return hash in {@code long} form
	 */
	@Override
	public long getHash() {
		return (sum2 << getLength()) | sum1;
	}

	/**
	 * Return {@code int} length of hash
	 *
	 * @return The length of hash in bit
	 */
	@Override
	abstract public int getLength();

	/**
	 * Reset all the Hash to {@code 0}zero
	 */
	@Override
	public void resetAlgorithm() {
		this.sum1 = 0;
		this.sum2 = 0;
	}
}
