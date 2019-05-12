/*Objetivo:     Um banco deve controlar Saques e Depósitos.
				O sistema pode permitir um Saque e um Depósito
				Simultâneos, mas nunca 2 Saques ou 2 Depósitos
				Simultâneos.
				Para calcular a transação (Saque ou Depósito), o método deve
				receber o código da conta, o saldo da conta e o valor a ser
				transacionado.
				Deve-se montar um sistema que deve considerar que 20
				transações simultâneas serão enviadas ao sistema
				(aleatoriamente essas transações podem ser qualquer uma das
				opções) e tratar todas as transações, de acordo com as regras
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
