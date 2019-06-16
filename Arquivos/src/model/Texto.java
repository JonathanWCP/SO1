/*Objetivo:     Criar um programa que realize manipulacoes basicas de arquivos 
				como abrir um arquivo, abrir um diretorio, ler e 
				criar um arquivo de texto (.txt).
                
				Este codigo fonte sera salvo no arquivo Texto.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        16/06/2019
*/

package model;

public class Texto {
	private String nome;
	private String caminho;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		
		if (!nome.contains(".txt")) {
			this.nome = nome+".txt";
		}
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
