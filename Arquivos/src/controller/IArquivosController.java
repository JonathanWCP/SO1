/*Objetivo:     Interface da porra toda
                
				Este codigo fonte sera salvo no arquivo IArquivosController.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        21/05/2019
*/

package controller;

import java.io.IOException;

public interface IArquivosController {
	public void escreveArq (String caminho, String nome) throws IOException;
	public void leArq (String caminho, String nome) throws IOException;
	public void abreArq (String caminho, String nome) throws IOException;
	public void leDir (String caminho) throws IOException;
	
}