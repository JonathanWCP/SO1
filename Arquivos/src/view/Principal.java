/*Objetivo:     Criar um programa que realize manipulacoes basicas de arquivos 
				como abrir um arquivo, abrir um diretorio, ler e 
				criar um arquivo de texto (.txt).
                
				Este codigo fonte sera salvo no arquivo Principal.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        15/06/2019
*/

package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Acoes;
import controller.Arquivos;
import model.Texto;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCaminho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		Acoes ac = new Acoes();
		setTitle("Manipular Arquivos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAbrirArq = new JLabel("Abrir Arquivo");
		lblAbrirArq.setBounds(27, 39, 100, 14);
		contentPane.add(lblAbrirArq);

		JButton btnAbrirArq = new JButton("Procurar...");
		btnAbrirArq.setBounds(27, 64, 100, 23);
		contentPane.add(btnAbrirArq);

		ActionListener abrirArq = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String caminho = ac.abreArq();
					escreveCaminho(caminho);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		};

		btnAbrirArq.addActionListener(abrirArq);

		JLabel lblAbrirDiret = new JLabel("Abrir Diret\u00F3rio");
		lblAbrirDiret.setBounds(148, 39, 99, 14);
		contentPane.add(lblAbrirDiret);

		JButton btnAbrirDiret = new JButton("Procurar...");
		btnAbrirDiret.setBounds(148, 64, 99, 23);
		contentPane.add(btnAbrirDiret);

		ActionListener abrirDir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String caminho = ac.abreDir();
					escreveCaminho(caminho);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		};

		btnAbrirDiret.addActionListener(abrirDir);

		JLabel lblLertxt = new JLabel("Ler Arquivo .txt");
		lblLertxt.setBounds(271, 39, 100, 14);
		contentPane.add(lblLertxt);

		JButton btnLertxt = new JButton("Procurar...");
		btnLertxt.setBounds(271, 64, 100, 23);
		contentPane.add(btnLertxt);

		ActionListener buscatxt = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String caminho = ac.procuratxt();
					escreveCaminho(caminho);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};

		btnLertxt.addActionListener(buscatxt);

		JLabel lblCriartxt = new JLabel("Criar Arquivo .txt");
		lblCriartxt.setBounds(401, 39, 100, 14);
		contentPane.add(lblCriartxt);

		JButton btnCriartxt = new JButton("Criar...");
		btnCriartxt.setBounds(401, 64, 100, 23);
		contentPane.add(btnCriartxt);

		ActionListener criarTxt = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Arquivos arq = new Arquivos();
				Texto txt = new Texto();
				CriarTxt frame2 = new CriarTxt(txt);
				frame2.setVisible(true);
				if (txt.getNome() != null && txt.getCaminho() != null) {
					try {
						arq.escreveArq(txt.getCaminho(), txt.getNome());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		};

		btnCriartxt.addActionListener(criarTxt);

		textFieldCaminho = new JTextField();
		textFieldCaminho.setBounds(91, 112, 242, 20);
		contentPane.add(textFieldCaminho);
		textFieldCaminho.setColumns(10);

		JLabel lblCaminho = new JLabel("Caminho:");
		lblCaminho.setBounds(25, 115, 56, 14);
		contentPane.add(lblCaminho);
	}

	public void escreveCaminho(String caminho) {
		textFieldCaminho.setText(caminho);
	}
}
