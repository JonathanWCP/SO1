/*Objetivo:  	Fazer uma aplicação que rode 5 Threads que
				cada uma delas imprima no console o seu número
                
                Este codigo fonte sera salvo no arquivo ToadRace.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/
package controller;

import java.util.Random;

public class PrintController extends Thread {
	static int alea = 0;
	static Random rand = new Random();


	static Thread program1 = new Thread() {
		public void run() {
			alea = rand.nextInt(101);
			System.out.println(alea);
		}
	};
	
	static Thread program2 = new Thread() {
		public void run() {
			alea = rand.nextInt(101);
			System.out.println(alea);
		}
	};
	
	static Thread program3 = new Thread() {
		public void run() {
			alea = rand.nextInt(101);
			System.out.println(alea);
		}
	};
	
	static Thread program4 = new Thread() {
		public void run() {
			alea = rand.nextInt(101);
			System.out.println(alea);
		}
	};
	
	static Thread program5 = new Thread() {
		public void run() {
			alea = rand.nextInt(101);
			System.out.println(alea);
		}
	};
	
	public static void main(String[] args) {
		program1.start();
		program2.start();
		program3.start();
		program4.start();
		program5.start();
	}
	
}
