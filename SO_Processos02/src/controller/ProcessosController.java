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
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ProcessosController {

	public ProcessosController() {
		super();
	}

	public String so() {
		String so = System.getProperty("os.name");
		return so;
	}

	public void chamaProcesso(String processo) {
		StringBuffer buffer = new StringBuffer();
		if (System.getProperty("os.name").contains("Windows")) {

			buffer.append("cmd /c ");
			buffer.append(processo);

			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			buffer.append(processo);

			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	public void leProcesso(String so) {
		if (so.contains("Windows")) {
			String processo = "TASKLIST /FO TABLE";
			try {
				Process pr = Runtime.getRuntime().exec(processo);
				InputStream fluxo = pr.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine(); // usa o buffer para ler uma linha e joga na mesma
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} else {
			try {
				String processo = "ps -a";
				Process pr = Runtime.getRuntime().exec(processo);
				InputStream fluxo = pr.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine(); // usa o buffer para ler uma linha e joga na mesma
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

		}
	}

	public void mataProcesso(String so, String info) { // matar processo por PID e pelo nome do processo
		if (so.contains("Windows")) {
			StringBuffer buffer = new StringBuffer();
			String cmdNome = "TASKKILL /IM "; // matar pelo nome
			String cmdPid = "TASKKILL /PID "; // matar pelo PID
			int pid = 0;

			try {
				pid = Integer.parseInt(info);
				buffer.append(cmdPid);
				buffer.append(pid);
			} catch (NumberFormatException e) {
				if (!info.contains(".exe")) {
					info += ".exe";
				}
				buffer.append(cmdNome);
				buffer.append(info);
			} finally {
				chamaProcesso(buffer.toString());
			}
		} else if (so.contains("Linux")) {
			StringBuffer buffer = new StringBuffer();
			String cmdPid = "kill "; // matar pelo PID
			String cmdNome = "pkill "; // matar pelo nome
			int pid = 0;

			try {
				pid = Integer.parseInt(info);
				buffer.append(cmdPid);
				buffer.append(pid);
			} catch (NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(info);
			} finally {
				chamaProcesso(buffer.toString());
			}

		}
	}
}
