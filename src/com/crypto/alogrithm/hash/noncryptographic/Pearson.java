package com.crypto.alogrithm.hash.noncryptographic;

import com.crypto.alogrithm.hash.crc.Checksum;

/**
 * Pearson hashing is a hash function designed for fast execution on processors
 * with 8-bit registers. Given an input consisting of any number of bytes, it
 * produces as output a single byte that is strongly dependent[1] on every byte
 * of the input. Its implementation requires only a few instructions, plus a
 * 256-byte lookup table containing a permutation of the values 0 through
 * 255.<br>
 * For more Information {@link https://en.wikipedia.org/wiki/Pearson_hashing}
 *
 * @author Sunil Kanjar
 */
public class Pearson extends Checksum {

	int lookupTable[] = {
		189, 205, 199, 128, 176, 19, 211, 236, 127, 192, 231, 70, 233, 88, 146, 44,
		39, 158, 178, 187, 131, 136, 1, 49, 50, 17, 141, 91, 47, 129, 60, 99,
		61, 20, 68, 89, 130, 63, 52, 102, 24, 229, 132, 245, 80, 216, 195, 115,
		133, 232, 196, 144, 198, 124, 53, 4, 108, 74, 223, 234, 134, 230, 157, 139,
		221, 31, 209, 182, 143, 92, 149, 184, 148, 62, 113, 65, 37, 27, 106, 166,
		98, 6, 85, 150, 36, 23, 112, 164, 135, 207, 169, 5, 26, 64, 165, 219,
		43, 119, 224, 71, 122, 142, 42, 160, 104, 48, 247, 103, 15, 11, 138, 239,
		90, 168, 156, 203, 177, 120, 2, 190, 188, 7, 100, 185, 174, 243, 162, 10,
		59, 153, 29, 9, 213, 167, 84, 93, 30, 46, 94, 75, 151, 114, 73, 222,
		154, 35, 86, 171, 105, 34, 38, 200, 147, 58, 77, 118, 173, 246, 76, 254,
		123, 251, 67, 250, 161, 0, 107, 97, 241, 111, 181, 82, 249, 33, 69, 55,
		3, 14, 204, 72, 21, 41, 56, 66, 28, 193, 40, 217, 25, 54, 179, 117,
		183, 201, 22, 83, 13, 214, 116, 109, 159, 32, 95, 226, 140, 220, 57, 12,
		197, 96, 210, 45, 16, 227, 248, 202, 51, 152, 252, 125, 81, 206, 215, 186,
		238, 87, 240, 155, 180, 170, 242, 212, 191, 163, 78, 218, 137, 194, 175, 110,
		237, 18, 253, 225, 8, 208, 172, 244, 255, 126, 101, 79, 145, 235, 228, 121
	};

	/**
	 * Fix Random key : It is array of 256 element 0 to 255 at random
	 * position<br>
	 */
	/**
	 * it will update hash with passed {@code byte data} and return new hash
	 *
	 * @param data byte data to add in hash
	 */
	@Override
	public void update(byte data) {
		hash = lookupTable[((int) hash ^ data) % 0xff];
	}

	/**
	 * Return {@code int} length of hash
	 *
	 * @return The length of hash in bit
	 */
	@Override
	public int getLength() {
		return 8;
	}

	/**
	 * Set new lookup table of 0 to 255
	 *
	 * @param lookupTable byte array of 265 unique element
	 */
	public void setLookupTable(int[] lookupTable) {
		this.lookupTable = lookupTable;
	}

	/**
	 * Return default or previously passed lookup table
	 *
	 * @return Lookup Table byte array of 265 unique element
	 */
	public int[] getLookupTable() {
		return lookupTable;
	}
}
