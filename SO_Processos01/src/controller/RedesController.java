/* Objetivo:    Coletar e exibir os seguintes itens: informações do 
 				Sistema Operacional, Informações de rede (Apenas IPv4)
 				e coletar a media do ping. Tanto as informacoes de rede como
 				o ping deverao receber o nome do SO coletado anteriormente 
 				para assim entao, prosseguir com o codigo de acordo com cada SO.

                Este codigo fonte sera salvo no arquivo RedesController.java
                Exemplificar um programa Java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        06/03/2019
*/

package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.JOptionPane;

public class RedesController {
	public RedesController() {
		super();
	}

	public String so() throws SocketException {
		String so = "----- Informacoes do Sistema -----\n";
		so = so + "\nNome do usuario: " + System.getProperty("user.name");
		so = so + "\nSistema Operacional: " + System.getProperty("os.name");
		so = so + "\nArquitetura do Sistema: " + System.getProperty("os.arch") + "\n";
		return so;
	}

	public void ip(String so, NetworkInterface netint) {
		String result = "";

		Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
		for (InetAddress inetAddress : Collections.list(inetAddresses)) {
			String IPv4 = inetAddress.getHostAddress();
			String quebrado[] = IPv4.split(":");
			if (quebrado.length < 5) {
				System.out.println(result += ("Placa de Rede: " + netint.getDisplayName()) + "\nIpv4: " + inetAddress);
			}
		}
	}

	public void ping(String so) {
		if (so.contains("Windows")) {
			int valorFinal = 0;
			String armazenaLinha = ""; // armazenara todas as linhas do ping mas em String e sem buffer
			String sitePing = "ping -n 10 www.google.com.br"; // variavel com o site a ser testado
			System.out.println("\n----- Teste de Ping -----\n"
					+ "\nO site utilizado para testar o ping sera: 'www.google.com.br'. ");
			try {
				Process pr = Runtime.getRuntime().exec(sitePing);
				InputStream fluxo = pr.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				int posicaoInicial = 44, posicaoFinal = 47; // posicao dos valores do ping
				System.out.print("\nAguarde...");
				while (linha != null) {
/*					 System.out.println(linha); //imprime o ping  */
					if (linha.contains("Esgotado o tempo limite do pedido.")) {
						System.out.println("Pacote perdido");
						linha = buffer.readLine();
					} else {
						armazenaLinha = linha;
						int tamanhoLinha = armazenaLinha.length(); // int contendo o tamanho de cada linha
						if (tamanhoLinha == 49 && linha.contains("=")) {
							valorFinal += Integer.parseInt(armazenaLinha.substring(posicaoInicial, posicaoFinal));
						} else if (tamanhoLinha == 50 && linha.contains("=")) {
							valorFinal += Integer.parseInt(armazenaLinha.substring(posicaoInicial+1, posicaoFinal+1));
						} else if (tamanhoLinha == 48 && linha.contains("=")) {
							valorFinal += Integer.parseInt(armazenaLinha.substring(posicaoInicial-1, posicaoFinal-1));
						}
						System.out.print(".");
/*					System.out.println(linha.length()); //imprime tamanho de cada linha */
						linha = buffer.readLine();
					}
				}
				if (valorFinal > 0) { // condicao para um cenario em que nao ha conexao com a internet
					System.out.println("\nA media do ping: " + valorFinal + "ms!");
				} else {
					System.out.println(
							"\nErro! Todos os pacotes foram perdidos! \nVerifique sua conexao com a internet e tente novamente.");
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} else if (so.contains("Linux")) {
			double valorFinal = 0;
			String armazenaLinha = ""; // armazenara todas as linhas do ping mas em String e sem buffer
			String sitePing = "ping -c 10 www.google.com.br"; // variavel com o site a ser testado
			System.out.println("\n----- Teste de Ping -----\n"
					+ "\nO site utilizado para testar o ping sera: 'www.google.com.br'. ");
			try {
				Process pr = Runtime.getRuntime().exec(sitePing);
				InputStream fluxo = pr.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				int posicaoInicial = 31, posicaoFinal = 37; // posicao dos valores do ping
				System.out.print("\nAguarde...");
				while (linha != null) {
//					System.out.println(linha);	//imprimir o ping 
					armazenaLinha = linha;
					int tamanhoLinha = linha.length();
/*					System.out.println(tamanhoLinha);	//imprime o tamanho de cada linha do ping */
					System.out.print(".");
					if (tamanhoLinha == 56) {
						valorFinal = Double.parseDouble(armazenaLinha.substring(posicaoInicial, posicaoFinal));
					} else if(tamanhoLinha == 57) {
						valorFinal = Double.parseDouble(armazenaLinha.substring(posicaoInicial+1, posicaoFinal+1));
					} else if (tamanhoLinha == 55) {
						valorFinal = Double.parseDouble(armazenaLinha.substring(posicaoInicial-1, posicaoFinal-1));
					}
					linha = buffer.readLine(); // usa o buffer para ler uma linha e joga na mesma
				}
					System.out.println("\nA media do ping: " + valorFinal + "ms!");
				 	if (valorFinal == 0) {
					System.out.println(
							"\nErro! Todos os pacotes foram perdidos! \nVerifique sua conexao com a internet e tente novamente.");
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
}