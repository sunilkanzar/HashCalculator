package com.crypto.alogrithm.hash.noncryptographic;

public class FNVZero64 extends FNV {

	public FNVZero64() {
		super.setInitialHashValue(0);
		prime = 0x100000001b3L;
	}

	@Override
	public void update(byte data) {
		hash *= getPrime();
		hash ^= data;
	}

	@Override
	public void setInitialHashValue(long hash) {
	}

	@Override
	protected long getMod() {
		return 0;
	}

	@Override
	public int getLength() {
		return 64;
	}
}
