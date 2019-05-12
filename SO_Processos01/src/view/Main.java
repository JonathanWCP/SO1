/* Objetivo:    Main com menu principal 

                Este codigo fonte sera salvo no arquivo Main.java
                Exemplificar um programa Java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        06/03/2019
*/

package view;

import controller.RedesController;

import java.net.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) throws SocketException, UnknownHostException {
		RedesController rede = new RedesController();
		int opc = 0;
		String so = rede.so();
		try {
			while (opc != 9) {
				opc = Integer.parseInt(
						JOptionPane.showInputDialog("------ MENU PRINCIPAL -----" + "\n1 - Informacoes do Sistema"
								+ "\n2 - Informacoes de Rede" + "\n3 - Teste de Ping (Google)" + "\n9 - Sair"));
				switch (opc) {

				case 1:
					// String so = rede.so();
					System.out.println(so);
					break;

				case 2:
					if (so.contains("Linux") || (so.contains("Windows"))) {
						System.out.println("----- Informacoes de Rede -----\n");
						Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
						for (NetworkInterface netint : Collections.list(nets))
							rede.ip(so, netint);
					}
					break;

				case 3:
					rede.ping(so);
					break;

				default:
					JOptionPane.showMessageDialog(null, "OPC invalida");
				case 9:
					break;
				}

			}
		} catch (NumberFormatException en) {

		}

	}

}