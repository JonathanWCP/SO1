/*Objetivo:     Corrida de sapos usando 5 Threads, onde cada thread controla 
				um sapo. Deve haver um tamanho maximo para o pulo do sapo e
				para a distancia total da corrida; para cada salto, 
				onde pode ser de 0 at√© a distancia maxima do pulo, deve 
				imprimir o tamanho do salto e a distancia percorrida. 
				Assim que o sapo percorrer a distancia total da corrida, 
				imprimir o seu lugar de chegada.
                
                Este codigo fonte sera salvo no arquivo ToadRace.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package controller;

public class ToadRace extends Thread {
	private final int distanciaTotal = 100;
	private final int saltoMax = 15;
	private static int posicao = 0;
	private int id;

	public ToadRace(int id) {
		this.id = id;
	}

	public void run() {
		Jumpers();
	}

	private void Jumpers() {
		int distanciaPercorrida = 0;
		while (distanciaPercorrida < distanciaTotal) {
			int distanciaSalto = (int)(Math.random()*saltoMax);
			distanciaPercorrida += distanciaSalto;
			System.out.printf("O Sapo#%d pulou %d metros, num total de %d metros\n", id, distanciaSalto, distanciaPercorrida);
		}
		Chegada();
	}

	private void Chegada() {
		System.out.printf("O Sapo#%d chegou em %d∫ lugar!\n", id, ++posicao);
	}
}
