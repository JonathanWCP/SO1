/*Objetivo:     4 pessoas caminham em direcao a uma porta em corredores 
 				separados; apenas 1 pessoa pode cruzar a porta por vez.
 				Cada corredor tem 200 metros, e cada pessoa anda de
 				4 a 6 m/s. Cada pessoa leva de 1 a 2 segundos
				para abrir e cruzar a porta. Faca uma
				aplicacao em java que simule essa situacao.
                
                Este codigo fonte sera salvo no arquivo DoorSemaphore.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package controller;

import java.util.concurrent.Semaphore;
public class DoorSemaphore extends Thread {
	private final int Corredor = 200;
	public Semaphore walk;
	public int id;
	static int posChegada = 0;
	
	
	public DoorSemaphore (int id, Semaphore walk) {
		this.id = id;
		this.walk = walk;
	}
	
	public void run() {
		Caminhando();
		try {
			walk.acquire(); //quando uma pessoa anda os 200m, ela precisa cruzar a porta
			Door();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			walk.release();
		}
	}

	private void Door() {
		System.out.printf("A pessoa#%d chegou e esta abrindo a porta...\n", id);
		int tempo = (int)(Math.random()*2)+1; //pessoa leva de 1 a 2 segundos para cruzar a porta
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.printf("A pessoa#%d foi a %dº a cruzar a porta!\n", id, ++posChegada);
		}
	}

	private void Caminhando() {
		int distanciaPercorrida = 0;
		while (distanciaPercorrida < Corredor) {
			int caminhar = (int)(Math.random()*3)+4; //as pessoas andam de 4 a 6 m/s
			distanciaPercorrida += caminhar;
			System.out.printf("A pessoa#%d andou %d metros, num total de %d metros\n", id, caminhar, distanciaPercorrida);
			try {
				Thread.sleep(1000); //caminhando de segundo em segundo {4~6m/s}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
