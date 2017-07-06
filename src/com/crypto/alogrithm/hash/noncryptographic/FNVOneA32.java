package com.crypto.alogrithm.hash.noncryptographic;

public class FNVOneA32 extends FNVOne32 {

//	public FNVOneA32() {
//		super();
//	}
	@Override
	public void update(byte data) {
		hash ^= data;
		hash = (hash * prime) % getMod();
	}
}
