/*Objetivo:     ...
                
				Este codigo fonte sera salvo no arquivo Main.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package view;

import java.util.concurrent.Semaphore;

import controller.Crossing;

public class Main {
	public static void main(String[] args) {
		String sentido = "";
		Semaphore semaforo = new Semaphore(1);
		for(int id = 1; id <= 4; id++) {
			
			if(id == 1) {
				sentido = "SUL";
			}
			if (id == 2) {
				sentido = "LESTE";
			}
			if (id == 3) {
				sentido = "OESTE";
			}
			if (id == 4) {
				sentido = "NORTE";
			}
			
			Crossing cruzamento = new Crossing(id, sentido, semaforo);
			cruzamento.start();
		}		
	}
}
