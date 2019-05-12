/*Objetivo:     Numa prova de triatlo moderno, o circuito se dá da seguinte maneira:
				- 3Km de corrida onde os atletas correm entre 20 e 25 m / 30 ms
				- 3 tiros ao alvo com pontuação de 0 a 10
				- 5 km de ciclismo onde os atletas pedalam entre 30 e 40 m/ 40 ms
				25 atletas participam da prova e largam juntos, no entanto, apenas 5 armas de tiro estão a
				disposição. Cada atleta leva de 0,5 a 3s por tiro. Conforme os atletas finalizam o circuito de
				corrida, em ordem de chegada, pegam a arma para fazer os disparos. Uma vez encerrados os
				disparos, a arma é liberada para o próximo, e o atleta segue para pegar a bicicleta e continuar
				o circuito.
				Para determinar o ranking final dos atletas, considera-se a seguinte regra:
				- O primeiro que chegar recebe 250 pontos, o segundo recebe 240, o terceiro recebe
				230, ... , o último recebe 10.
				- Soma-se à pontuação de cada atleta, o total de pontos obtidos nos 3 tiros (somados)
				Ordenar a pontuação e exibir o resultado final do maior pontuador para o menor.
                
				Este codigo fonte sera salvo no arquivo Triatlo.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        30-04-2019
*/

package controller;

import java.util.concurrent.Semaphore;

public class Triatlo extends Thread {
	private int atleta;
	private Semaphore semaforo;
	private final int CORRIDA = 3000;
	private final int CICLISMO = 5000;
	private int pontosTiro = 0;
	private static int pontosChegada = 250;
	private static int lugar = 0;
	private static int[][] pontuacaoFinal = new int[26][2];

	public Triatlo(int atleta, Semaphore semaforo) {
		this.atleta = atleta;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		corrida();
		try {
			semaforo.acquire();
			tiroAlvo();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			ciclismo();
			chegada();
		}
	}

	private void ordenar() {
		pontuacaoFinal[0][1] = 9999; // espaco 0 nunca sera usado, valor alto para evitar trocas
		for (int x = 0; x < pontuacaoFinal.length; x++) {
			for (int y = 1; y < pontuacaoFinal.length - 1; y++) {
				if (pontuacaoFinal[y][1] < pontuacaoFinal[y + 1][1]) {
					int aux = pontuacaoFinal[y][1];
					pontuacaoFinal[y][1] = pontuacaoFinal[y + 1][1];
					pontuacaoFinal[y + 1][1] = aux;

					int aux1 = pontuacaoFinal[y][0];
					pontuacaoFinal[y][0] = pontuacaoFinal[y + 1][0];
					pontuacaoFinal[y + 1][0] = aux1;
				}
			}
		}
		for (int i = 1; i < 26; i++) {
			System.out.println("O Atleta#" + pontuacaoFinal[i][0] + " tem " + pontuacaoFinal[i][1] + " pontos!");
		}
	}

	private void chegada() {
		int pontuacaoTotal = 0;
		pontuacaoTotal = pontosChegada + pontosTiro;
		pontosChegada = pontosChegada - 10;
		System.out.println("O Atleta#" + atleta + " chegou em " + (++lugar) + "º lugar!");
		pontuacaoFinal[lugar][0] = atleta;
		pontuacaoFinal[lugar][1] = pontuacaoTotal;

		if (lugar == 25) {
			ordenar();
		}
	}

	private void ciclismo() {
		int distanciaPercorrida = 0;
		while (distanciaPercorrida < CICLISMO) {
			distanciaPercorrida += (int) (Math.random() * 11) + 30;
			System.out.printf("O Atleta#%d andou %d metros no ciclismo!\n", atleta, distanciaPercorrida);
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void tiroAlvo() {
		int tiro = 0, tempo = 0;
		while (tiro < 3) {
			tempo = (int) (Math.random() * 2600) + 500;
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				tiro++;
				pontosTiro += (int) (Math.random() * 11);
				System.out.printf("O Alteta#%d deu %d tiro(s), pontuacao: %d\n", atleta, tiro, pontosTiro);
			}
		}
	}

	private void corrida() {
		int distanciaPercorrida = 0;
		while (distanciaPercorrida < CORRIDA) {
			distanciaPercorrida += (int) (Math.random() * 6) + 20;
			System.out.printf("O Atleta#%d andou %d metros\n", atleta, distanciaPercorrida);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
