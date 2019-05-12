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
