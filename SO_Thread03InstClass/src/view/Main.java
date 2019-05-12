/*Objetivo:     Corrida de sapos usando 5 Threads, onde cada thread controla 
				um sapo. Deve haver um tamanho maximo para o pulo do sapo e
				para a distancia total da corrida; para cada salto, 
				onde pode ser de 0 até a distancia maxima do pulo, deve 
				imprimir o tamanho do salto e a distancia percorrida. 
				Assim que o sapo percorrer a distancia total da corrida, 
				imprimir o seu lugar de chegada.
                
                Este codigo fonte sera salvo no arquivo Main.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package view;

import controller.ToadRace;

public class Main {
	public static void main(String[] args) {
		for (int id = 1; id <= 5; id++) {
			ToadRace sapo = new ToadRace(id);
			sapo.start();
		}
	}
}
