package com.crypto.alogrithm.hash.universalhash;

import java.util.Random;

public class Zobrist {

	int whitePawn = 1;
	int whiteRook = 2;
	int blackKing = 12;

	int[][] table = new int[64][12];

	void initZobrist() {
		Random random = new Random();
		for (int i = 0; i < table.length; i++) {
			int[] is = table[i];
			for (int j = 0; j < is.length; j++) {
				table[i][j] = random.nextInt();
			}
		}
	}

	long getHash(byte data) {

		return 0l;
	}
}
