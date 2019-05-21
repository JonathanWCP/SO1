/*Objetivo:     Um banco deve controlar Saques e Depositos.
				O sistema pode permitir um Saque e um Deposito
				Simultaneos, mas nunca 2 Saques ou 2 Depositos
				Simultaneos.
				Para calcular a transacao (Saque ou Deposito), o metodo deve
				receber o codigo da conta, o saldo da conta e o valor a ser
				transacionado.
				Deve-se montar um sistema que deve considerar que 20
				transacoes simultaneas serao enviadas ao sistema
				(aleatoriamente essas transacoes podem ser qualquer uma das
				opcoes) e tratar todas as transacoes, de acordo com as regras
				acima.
                
				Este codigo fonte sera salvo no arquivo Main.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package view;

import java.util.concurrent.Semaphore;

import controller.Bank;

public class Main {
	public static void main(String[] args) {
		Semaphore[] permissoes = new Semaphore[2];
		
		for (int i = 0; i < 2; i++) {
			permissoes[i] = new Semaphore(1);
		}
		
		for (int id = 1; id <= 20; id++) {
			Thread banco = new Bank(id, (int)(Math.random()*2153)+1523, (int)(Math.random()*238)+512, permissoes);
			banco.start();
		}
	}
}
