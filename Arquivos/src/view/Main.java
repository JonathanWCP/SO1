/*Objetivo:     ...
                
				Este codigo fonte sera salvo no arquivo Main.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        21/05/2019
*/

package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.Arquivos;
import controller.IArquivosController;

public class Main {
	public static void main(String[] args) {
		String path = "C:\\Windows";
		String caminho = "C:\\Windows\\TEMP";
		String outroCaminho = "C:\\Users\\joni_\\OneDrive\\Fotos";
		String nome = "arquivoTeste.txt";
		String outroNome = "jow.jpg";
		IArquivosController ac = new Arquivos();
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("----- Menu Principal ----- "
					+ "\n1 - Abrir arquivo"
					+ "\n2 - Abrir diretorio"
					+ "\n3 - Criar arquivo de texto", "Escolha uma opcao"));
			switch (opc) {
			case 1:
				
			}
		}
		
		try {
//			ac.escreveArq(caminho, nome);
//			ac.leArq(caminho, nome);
//			ac.leDir(path);
			ac.abreArq(outroCaminho, outroNome);
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
