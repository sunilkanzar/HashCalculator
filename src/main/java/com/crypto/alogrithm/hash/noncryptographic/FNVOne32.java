package com.crypto.alogrithm.hash.noncryptographic;

public class FNVOne32 extends FNVZero32 {

	public FNVOne32() {
		this.setInitialHashValue(0x811c9dc5L);
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
