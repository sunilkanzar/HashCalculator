package com.crypto.alogrithm.util;

/**
 *
 * @author skanjar
 */
public class HashUtility {

	/**
	 * It return {@code boolean[n]} with true in prime number element <br>
	 * Elements start form 1 <br>Implementation of Sieve of Eratosthenes
	 * algorithm for finding prime
	 * {@link https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes}
	 *
	 * @param n number to find prime lesser then {@code n}
	 * @return {@code boolean[]} contains true in prime element
	 */
	public static boolean[] getPrimeList(int n) {
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for (int factor = 2; factor * factor <= n; factor++) {
			if (isPrime[factor]) {
				for (int j = factor; factor * j <= n; j++) {
					isPrime[factor * j] = false;
				}
			}
		}
		return isPrime;
	}
}
