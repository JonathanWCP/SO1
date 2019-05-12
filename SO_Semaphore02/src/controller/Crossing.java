/*Objetivo:     ...
                
				Este codigo fonte sera salvo no arquivo Crossing.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package controller;

import java.util.concurrent.Semaphore;

public class Crossing extends Thread {
	int id;
	String sentido;
	Semaphore semaforo;

	public Crossing(int id, String sentido, Semaphore semaforo) {
		this.id = id;
		this.sentido = sentido;
		this.semaforo = semaforo;
	}

	public void run() {
		try {
			semaforo.acquire();
			Cruzando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.printf("O carro#%d cruzou!\n", id);
			semaforo.release();
		}
	}

	private void Cruzando() {
		System.out.printf("O carro#%d esta cruzando no sentido %s\n", id, sentido);
		try {
			int tempo = (int) (Math.random() * 7000) + 2000;
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
