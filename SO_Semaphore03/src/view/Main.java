/*Objetivo:     Você foi contratado para automatizar um treino de Fórmula 1.
				As regras estabelecidas pela direção da provas são simples:
				“No máximo 5 carros das 7 escuderias (14 carros no total)
				presentes podem entrar na pista simultaneamente, mas apenas
				um carro de cada equipe. O segundo carro deve ficar à espera,
				caso um companheiro de equipe já esteja na pista. Cada piloto
				deve dar 3 voltas na pista. O tempo de cada volta deverá ser
				exibido e a volta mais rápida de cada piloto deve ser
				armazenada para, ao final, exibir o grid de largada, ordenado
				do menor tempo para o maior.”
                
				Este codigo fonte sera salvo no arquivo Main.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package view;

import java.util.concurrent.Semaphore;

import controller.F1;

public class Main {
	public static void main(String[] args) {
		final int escuderia = 7;
		final int carros = escuderia * 2;
		int permissoes = 5;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int id = 1; id <= carros; id++) {
			F1 corrida = new F1(id, semaforo);
			corrida.start();
		}
		
	}

}
