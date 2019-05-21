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
