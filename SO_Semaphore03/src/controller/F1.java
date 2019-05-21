/*Objetivo:     Voce foi contratado para automatizar um treino de Formula 1.
				As regras estabelecidas pela direcao da provas sao simples:
				ate no maximo 5 carros das 7 escuderias (14 carros no total)
				presentes podem entrar na pista simultaneamente, mas apenas
				um carro de cada equipe. O segundo carro deve ficar a espera,
				caso um companheiro de equipe ja esteja na pista. Cada piloto
				deve dar 3 voltas na pista. O tempo de cada volta devera ser
				exibido e a volta mais rapida de cada piloto deve ser
				armazenada para, ao final, exibir o grid de largada, ordenado
				do menor tempo para o maior.
                
				Este codigo fonte sera salvo no arquivo F1.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package controller;

import java.util.concurrent.Semaphore;

public class F1 extends Thread {
	int id;
	Semaphore semaforo;
	final int tamanhoPista = 100;
	static int posicao = 0;
	static int[] melhorTempo = {9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999};

	public F1(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}

	public void melhoresTempos() {
		for (int id = 0; id < 14; id++) {
			System.out.printf("O carro#%d teve o melhor tempo em " + melhorTempo[id] + " segundos\n", id + 1);
		}
	}

	public void run() {
		try {
			semaforo.acquire();
			System.out.printf("Simulacao de F1 com o carro#%d iniciada! \n", id);
			Corrida();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		if (posicao == 14) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				melhoresTempos();
			}
		}
	}

	private void Corrida() {
		int numeroVoltas = 0, distanciaPercorrida = 0, tempoVolta = 0;
		while (distanciaPercorrida < tamanhoPista && numeroVoltas < 3) {
			distanciaPercorrida += (int) (Math.random() * 11) + 5;
			if (distanciaPercorrida >= 100 && numeroVoltas < 3) {
				numeroVoltas++;
				distanciaPercorrida = 0;
				System.out.printf("O carro#%d deu a %dª volta em %d segundos!\n", id, numeroVoltas, tempoVolta);
				melhorTempo(tempoVolta);
				tempoVolta = 0;
			}
			if (numeroVoltas == 3) {
				System.out.printf("O carro#%d chegou em %dº lugar!\n", id, ++posicao);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tempoVolta++;
		}
	}

	private void melhorTempo(int tempoVolta) {
		if (tempoVolta < melhorTempo[id-1]) {
			melhorTempo[id-1] = tempoVolta;
		}
	}
}
