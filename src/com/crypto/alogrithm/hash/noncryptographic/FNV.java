package com.crypto.alogrithm.hash.noncryptographic;

import com.crypto.alogrithm.hash.crc.Checksum;

public abstract class FNV extends Checksum {

	protected long prime;

	@Override
	public void update(byte data) {
		hash = (hash * getPrime()) % getMod();
		hash ^= data;
	}

	@Override
	public abstract int getLength();

	public void setPrime(long prime) {
		this.prime = prime;
	}

	public long getPrime() {
		return prime;
	}

	protected abstract long getMod();
}
