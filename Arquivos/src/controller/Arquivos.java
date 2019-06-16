/*Objetivo:     Metodos para manipular um arquivo
                
				Este codigo fonte sera salvo no arquivo Arquivos.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        21/05/2019
*/

package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Arquivos implements IArquivosController {

	@Override
	public void escreveArq(String caminho, String nome) throws IOException {
		boolean existe = false;
		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(dir, nome);
			if (arq.exists()) {
				existe = true;
			}
			String texto = criaTexto();
			FileWriter abre = new FileWriter(arq, existe);
			PrintWriter escreve = new PrintWriter(abre);
			escreve.write(texto);
			escreve.flush(); // corrige e/ou finaliza qualquer apontamento de memoria
			escreve.close();
			abre.close();
		} else {
			throw new IOException("Dir. invalida");
		}
	}

	public String criaTexto() {
		StringBuffer buffer = new StringBuffer();
		String linha = JOptionPane.showInputDialog(null, "Digite o conteudo para o arquivo (escreva fim para finalizar)");
		while (!linha.equalsIgnoreCase("fim")) {
			buffer.append(linha);
			buffer.append("\n");
			linha = JOptionPane.showInputDialog(null, "Digite (fim para finalizar)");
		}
		JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
		return buffer.toString();

	}

	@Override
	public void leArq(String caminho, String nome) throws IOException {
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			System.out.println("Lendo arquivo " + nome + "...");
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo invalido");
		}
	}

	@Override
	public void abreArq(String caminho, String nome) throws IOException {
		Desktop desktop = Desktop.getDesktop();
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			System.out.println("Abrindo arquivo " + nome + "...");
			desktop.open(arq);
		} else {
			throw new IOException("Arq. invalido");
		}
	}

	@Override
	public void leDir(String caminho) throws IOException {
		File dir = new File(caminho); // percorre o file e cada file sera armazenado no vetor
		if (dir.exists() && dir.isDirectory()) {
			System.out.println("Diretorio -> " + caminho);
			File[] vetFile = dir.listFiles();
			for (File f : vetFile) {
				if (f.isDirectory()) {
					System.out.println("[" + f.getName() + "]");
				}
			}
			for (File f : vetFile) {
				if (f.isFile()) {
					// abreArq(f.getAbsolutePath(), f.getName()); abre todos os arquivos no diretorio (nao usar por motivos obvios)
					System.out.println(f.getName() + "\t\t" + f.getAbsolutePath()); //imprime nome do arquivo e o caminho
				}
			}
		} else {
			throw new IOException("Dir. invalido");
		}
	}

}
