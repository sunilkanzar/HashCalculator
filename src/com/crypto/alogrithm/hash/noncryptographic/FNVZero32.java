package com.crypto.alogrithm.hash.noncryptographic;

public class FNVZero32 extends FNV {

	public FNVZero32() {
		super.setInitialHashValue(0);
		prime = 0x01000193;
	}

	@Override
	public void setInitialHashValue(long hash) {
	}

	@Override
	protected long getMod() {
		return 0x100000000L;
	}

	@Override
	public int getLength() {
		return 32;
	}
}
