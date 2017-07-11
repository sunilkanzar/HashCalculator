package com.crypto.alogrithm.hash.checksums;

import com.crypto.alogrithm.hash.crc.Checksum;
import com.crypto.alogrithm.util.HashUtility;

/**
 * Implementation of 32 bit Adler<br>
 * This class not able to set initial hash value and not able to set final XOR
 * value<br>
 * For more information {@link https://en.wikipedia.org/wiki/Adler-32}
 *
 * @author Sunil Kanjar
 */
public class Adler extends Checksum {

	/**
	 * Prime value under {@code 0xffff}
	 */
	static boolean[] primeList = HashUtility.getPrimeList(0xffff);

	/**
	 * First half of hash
	 */
	private int a = 1;

	/**
	 * Second half of hash
	 */
	private int b;

	/**
	 * Default Adler base prime value for mod with new {@code a} and {@code b}
	 */
	private int adler = 65521;

	/**
	 * it will update hash with passed {@code byte data} and return new hash
	 *
	 * @param data byte data to add in hash
	 */
	@Override
	public void update(byte data) {
		a = (a + data) % adler;
		b = (b + a) % adler;
	}

	/**
	 * Get the final hash.
	 *
	 * @return hash in {@code long} form
	 */
	@Override
	public long getHash() {
		return (b << 16) | a;
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

	/**
	 * Set new Adler base prime value it returns true if value is valid prime
	 * otherwise it will not sets
	 *
	 * @param adler new Adler base prime value
	 * @return Value is set or not
	 */
	public boolean setAdler(int adler) {
		if (adler < 0xffff && primeList[adler]) {
			this.adler = adler;
			return true;
		}
		return false;
	}
}
