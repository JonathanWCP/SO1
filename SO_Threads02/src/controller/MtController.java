package controller;

import java.util.Random;

public class MtController extends Thread {
	static int[][] mt = new int[3][5];
	static int soma;
	
	static Thread tSoma1 = new Thread() {
		public void run() {
			soma = 0;
			for (int i = 0; i < 5; i++) {
				soma += mt[0][i];
			}
			System.out.println("A soma da primeira linha: " + soma);
		}
	};
	static Thread tSoma2 = new Thread() {
		public void run() {
			soma = 0;
			for (int i = 0; i < 5; i++) {
				soma += mt[1][i];
			}
			System.out.println("A soma da segunda linha: " + soma);
		}
	};
	static Thread tSoma3 = new Thread() {
		public void run() {
			soma = 0;
			for (int i = 0; i < 5; i++) {
				soma += mt[2][i];
			}
			System.out.println("A soma da terceira linha: " + soma);
		}
	};
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Random generator = new Random();
		for (int j = 0; j < 3; j++ ) {
			if (j != 0) {System.out.println("\n");}
			for (int i = 0; i < 5; i ++) {
				mt[j][i] = generator.nextInt(1001);
				System.out.print("["+ mt[j][i]+"]");
			}
		}
		System.out.print("\n");
		tSoma1.start();
		tSoma2.start();
		tSoma3.start();
	}
}
