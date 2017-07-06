package com.crypto.alogrithm.hash.crc;

/**
 * Base class for all kind of algorithms which generate hash lesser or equal to
 * 64 bit.<br>All algorithms under this class has default initial value is
 * 0(Zero) and final XOR value is also 0(Zero)
 *
 * @author Sunil Kanjar
 */
public abstract class Checksum {

	/**
	 * Hash for algorithm
	 */
	protected long hash;

	/**
	 * initial hash value
	 */
	protected long initHash;

	/**
	 * Value to XOR with final hash bits
	 */
	private long finalXorValue;

	/**
	 * it will update hash with passed {@code byte data} and return new hash
	 *
	 * @param data byte data to add in hash
	 */
	abstract public void update(byte data);

	/**
	 * Return {@code int} length of hash
	 *
	 * @return The length of hash in bit
	 */
	abstract public int getLength();

	/**
	 * Reset all the status of implemented algorithm like hash value set back to
	 * {@code initHash}
	 */
	public void resetAlgorithm() {
		this.hash = initHash;
	}

	/**
	 * Finalize the hash like XOR with {@code finalXorValue} and return the
	 * final hash.
	 *
	 * @return hash in {@code long} form
	 */
	public long getHash() {
		return hash ^ finalXorValue;
	}

	/**
	 * Sets initial hash value
	 *
	 * @param hash initial hash value
	 */
	public void setInitialHashValue(long hash) {
		this.hash = hash;
		this.initHash = hash;
	}

	/**
	 * Gets initial hash value
	 *
	 * @return initial hash value
	 */
	public long getInitialHashValue() {
		return this.initHash;
	}

	/**
	 * Sets value to XOR with final hash
	 *
	 * @param finalXorValue value to XOR with final hash
	 */
	public void setFinalXorValue(long finalXorValue) {
		this.finalXorValue = finalXorValue;
	}

	/**
	 * Gets value to XOR with final hash
	 *
	 * @return value to XOR with final hash
	 */
	protected long getFinalXorValue() {
		return this.finalXorValue;
	}
}
