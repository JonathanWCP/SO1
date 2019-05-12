/*Objetivo:     4 pessoas caminham em direcao a uma porta em corredores 
 				separados; {apenas 1 pessoa} pode cruzar a porta por vez.
 				Cada corredor tem 200 metros, e cada pessoa anda de
 				4 a 6 m/s. Cada pessoa leva de 1 a 2 segundos
				para abrir e cruzar a porta. Faça uma
				aplicação em java que simule essa situação. 
                
                Este codigo fonte sera salvo no arquivo Main.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package view;

import java.util.concurrent.Semaphore;

import controller.DoorSemaphore;

public class Main {
	public static void main(String[] args) {
		final int permissoes = 1; //numero de permissoes no semaforo
		Semaphore semaforo = new Semaphore(permissoes); //apenas uma pessoa pode cruzar a porta {ler enunciado}

		for (int id = 1; id <= 4; id++) {
			DoorSemaphore walker = new DoorSemaphore(id, semaforo);
			walker.start();
		}
	}
}
