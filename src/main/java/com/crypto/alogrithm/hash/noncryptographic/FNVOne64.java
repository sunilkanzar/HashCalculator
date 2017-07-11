package com.crypto.alogrithm.hash.noncryptographic;

public class FNVOne64 extends FNVZero64 {

	public FNVOne64() {
		this.setInitialHashValue(0xcbf29ce484222325L);
	}

	/**
	 * Sets initial hash value
	 *
	 * @param hash initial hash value
	 */
	@Override
	public void setInitialHashValue(long hash) {
		super.hash = hash;
		super.initHash = hash;
	}

}
