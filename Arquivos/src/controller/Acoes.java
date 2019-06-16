/*Objetivo:     ...
                
				Este codigo fonte sera salvo no arquivo Acoes.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        15/06/2019
*/

package controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Texto;

public class Acoes {

	public String abreArq() throws IOException {
		Arquivos arq = new Arquivos();
		String caminhoArquivo = "", nomeArquivo = "", pastaArquivo = "";
		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File(diretorioBase);
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(true);

		int retorno = choose.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			pastaArquivo = choose.getSelectedFile().getAbsolutePath(); // coleta o caminho total do arquivo
			caminhoArquivo = choose.getSelectedFile().getParent(); // coleta o caminho do arquivo sem o nome no final
			nomeArquivo = choose.getSelectedFile().getName(); // coleta o nome do arquivo

		}
		arq.abreArq(caminhoArquivo, nomeArquivo);
		return pastaArquivo;
	}

	public String abreDir() throws IOException {
		Arquivos arq = new Arquivos();
		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File(diretorioBase);

		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		String pastaArquivo = "";

		int retorno = choose.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			pastaArquivo = choose.getSelectedFile().getAbsolutePath();
		}

		arq.leDir(pastaArquivo);
		return pastaArquivo;
	}

	public String procuratxt() throws IOException {
		Arquivos arq = new Arquivos();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Documentos de texto (*.txt)", "txt");

		String diretorioBase = System.getProperty("user.home") + "/Desktop";
		File dir = new File(diretorioBase);

		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro); // pode ser vetor com varios tipos
		String caminhoArquivo = "", nomeArquivo = "", pastaArquivo = "";

		int retorno = choose.showOpenDialog(null); // para salvar uso o showSaveDialog
		if (retorno == JFileChooser.APPROVE_OPTION) {
			pastaArquivo = choose.getSelectedFile().getAbsolutePath(); // coleta o caminho total do arquivo
			caminhoArquivo = choose.getSelectedFile().getParent(); // coleta o caminho do arquivo sem o nome no final
			nomeArquivo = choose.getSelectedFile().getName(); // coleta o nome do arquivo
		}
		arq.leArq(caminhoArquivo, nomeArquivo);
		return pastaArquivo;
	}

	public String CriaTxt() {
		String diretorioBase = System.getProperty("user.home") + "/Desktop";

		File dir = new File(diretorioBase);
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		String caminho = "";
		int retorno = choose.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminho = choose.getSelectedFile().getAbsolutePath();
		}
		return caminho;
	}
}
