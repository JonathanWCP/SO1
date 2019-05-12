/*Objetivo:     Corrida de sapos usando 5 Threads, onde cada thread controla 
				um sapo. Deve haver um tamanho maximo para o pulo do sapo e
				para a distancia total da corrida; para cada salto, 
				onde pode ser de 0 até a distancia maxima do pulo, deve 
				imprimir o tamanho do salto e a distancia percorrida. 
				Assim que o sapo percorrer a distancia total da corrida, 
				imprimir o seu lugar de chegada. 
                
                Este codigo fonte sera salvo no arquivo FiveFrogs.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package controller;

public class FiveFrogs extends Thread {
	private static final int distanciaMax = 100;
	private static final int saltoMax = 15;
	static int lugar = 0;

	static Thread Sapo1 = new Thread() {
		public void run() {
			int distanciaPercorrida = 0;
			while (distanciaPercorrida <= distanciaMax) {
				int distanciaPulo = (int) (Math.random() * saltoMax);
				distanciaPercorrida += distanciaPulo;
				System.out.printf("O Sapo #1 saltou %d num total de %d\n", distanciaPulo, distanciaPercorrida);
			}
			System.out.printf("O Sapo #1 chegou em %dº lugar!\n", ++lugar);
		}
	};

	static Thread Sapo2 = new Thread() {
		public void run() {
			int distanciaPercorrida = 0;
			while (distanciaPercorrida < distanciaMax) {
				int distanciaPulo = (int) (Math.random() * saltoMax);
				distanciaPercorrida += distanciaPulo;
				System.out.printf("O Sapo #2 saltou %d num total de %d\n", distanciaPulo, distanciaPercorrida);
			}
			System.out.printf("O Sapo #2 chegou em %dº lugar!\n", ++lugar);
		}
	};

	static Thread Sapo3 = new Thread() {
		public void run() {
			int distanciaPercorrida = 0;
			while (distanciaPercorrida < distanciaMax) {
				int distanciaPulo = (int) (Math.random() * saltoMax);
				distanciaPercorrida += distanciaPulo;
				System.out.printf("O Sapo #3 saltou %d num total de %d\n", distanciaPulo, distanciaPercorrida);
			}
			System.out.printf("O Sapo #3 chegou em %dº lugar!\n", ++lugar);
		}
	};

	static Thread Sapo4 = new Thread() {
		public void run() {
			int distanciaPercorrida = 0;
			while (distanciaPercorrida < distanciaMax) {
				int distanciaPulo = (int) (Math.random() * saltoMax);
				distanciaPercorrida += distanciaPulo;
				System.out.printf("O Sapo #4 saltou %d num total de %d\n", distanciaPulo, distanciaPercorrida);
			}
			System.out.printf("O Sapo #4 chegou em %dº lugar!\n", ++lugar);
		}
	};

	static Thread Sapo5 = new Thread() {
		public void run() {
			int distanciaPercorrida = 0;
			while (distanciaPercorrida < distanciaMax) {
				int distanciaPulo = (int) (Math.random() * saltoMax);
				distanciaPercorrida += distanciaPulo;
				System.out.printf("O Sapo #5 saltou %d num total de %d\n", distanciaPulo, distanciaPercorrida);
			}
			System.out.printf("O Sapo #5 chegou em %dº lugar!\n", ++lugar);
		}
	};

	public static void main(String[] args) {
		System.out.println("Corrida de Sapos!" + "\nDistancia máxima: 100 metros!");
		Sapo1.start();
		Sapo2.start();
		Sapo3.start();
		Sapo4.start();
		Sapo5.start();
	}
}
