/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crypto.alogrithm.hash.noncryptographic;

/**
 *
 * @author skanjar
 */
public class FNVOneA64 extends FNVOne64 {

	@Override
	public void update(byte data) {
		hash ^= data;
		hash *= prime;
	}
}
