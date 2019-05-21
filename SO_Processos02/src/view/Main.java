/*Objetivo:     Fazer, em java, uma aplicação que liste os processos ativos, permita ao
				usuario entrar com o nome ou o PID do processo e o mate.
				A aplicacao devera funcionar, minimamente em Windows e Linux (Alunos
				com Mac podem fazer para os 3 SO).
				Cada SO tem comandos diferentes para as ações
				supracitadas. Pesquisar os comandos para cada SO.
				A aplicacao devera ter, no package view, uma classe que tenha um metodo
				main que de ao usuario a possibilidade de ver os processos ativos ou matar
				os processos (Por Nome ou PID).
				No package controller, devera ter:
				1) Uma classe que tenha um metodo que identifique o SO;
				2) Um metodo que, recebendo o SO, no qual está rodando, como
				parametro de entrada, selecione o comando para listar os processos
				ativos;
				3) Um metodo que, recebendo o SO, no qual esta rodando, e o PID do
				processo, como parametros de entrada, selecione o comando para
				matar o processo e o finalize;
				4) Um metodo que, recebendo o SO, no qual esta rodando, e o Nome
				do processo, como parametros de entrada, selecione o comando
				para matar o processo e o finalize;
                
				Este codigo fonte sera salvo no arquivo Main.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        06/03/2019
*/
package view;

import javax.swing.JOptionPane;

import controller.ProcessosController;

public class Main {

	public static void main(String args[]) {
		int opc = 0;
		String info = "";
		ProcessosController proc = new ProcessosController();
		String so = proc.so();
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("----- Menu Principal ----- " + "\n1 - Listar processos"
					+ "\n2 - Matar processo (PID)" + "\n3 - Matar processo (Nome)" + "\n9 - Sair"));

			switch (opc) {
			case 1:
				proc.leProcesso(so);
				break;

			case 2:
				info = JOptionPane.showInputDialog("Digite o ID do processo");
				proc.mataProcesso(so, info);
				break;

			case 3:
				info = JOptionPane.showInputDialog("Digite o nome do processo");
				proc.mataProcesso(so, info);
				break;

			case 9:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Opcao invalida!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
