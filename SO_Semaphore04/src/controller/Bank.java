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
                
				Este codigo fonte sera salvo no arquivo Bank.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        22-04-2019
*/

package controller;

import java.util.concurrent.Semaphore;

public class Bank extends Thread {
	int id;
	int saldoAtual;
	int valorMovimentacao;
	Semaphore[] semaforo;

	public Bank(int id, int saldoAtual, int valorMovimentacao, Semaphore[] semaforo) {
		this.id = id;
		this.saldoAtual = saldoAtual;
		this.valorMovimentacao = valorMovimentacao;
		this.semaforo = semaforo;
	}

	public void run() {
		try {
			semaforo[id % 2].acquire();
			accout();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo[id % 2].release();
		}
	}

	private void accout() {
		if (id % 2 == 0) {
			saldoAtual += valorMovimentacao;
			System.out.println("A conta #"+id+" efetuou um deposito de R$"+valorMovimentacao+"\nSaldo atual: R$"+saldoAtual);
		} else {
			saldoAtual -= valorMovimentacao;
			System.out.println("A conta #"+id+" efetuou um saque de R$"+valorMovimentacao+"\nSaldo atual: R$"+saldoAtual);
		}
	}

}
