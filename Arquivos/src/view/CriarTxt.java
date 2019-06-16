/*Objetivo:     ...
                
				Este codigo fonte sera salvo no arquivo Txt.java
   Programador: Jonathan Willian Castro Pinheiro
   Data:        16/06/2019
*/

package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Acoes;
import model.Texto;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CriarTxt extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldCaminho;

	public CriarTxt(Texto txt) {
		setTitle("Criar .txt");
		this.setModal(true);
		setBounds(100, 100, 452, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNomeDoArquivo = new JLabel("Insira o nome do arquivo");
			lblNomeDoArquivo.setBounds(30, 29, 285, 14);
			contentPanel.add(lblNomeDoArquivo);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.setBounds(30, 54, 127, 20);
			contentPanel.add(textFieldNome);
			textFieldNome.setColumns(10);
		}
		{
			JLabel lblEscolhaOCaminho = new JLabel("Escolha o caminho que deseja salvar o arquivo");
			lblEscolhaOCaminho.setBounds(30, 94, 285, 14);
			contentPanel.add(lblEscolhaOCaminho);
		}
		{
			textFieldCaminho = new JTextField();
			textFieldCaminho.setBounds(30, 119, 202, 20);
			contentPanel.add(textFieldCaminho);
			textFieldCaminho.setColumns(10);
		}
		{
			JButton btnProcurar = new JButton("Procurar...");
			btnProcurar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Acoes ac = new Acoes();
					String caminho = ac.CriaTxt();
					preencheTextField(caminho);
				}
			});
			btnProcurar.setBounds(30, 150, 89, 23);
			contentPanel.add(btnProcurar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);

				ActionListener ok = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						txt.setNome(textFieldNome.getText());
						txt.setCaminho(textFieldCaminho.getText());
						dispose();
					}
				};
				okButton.addActionListener(ok);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void preencheTextField(String caminho) {
		textFieldCaminho.setText(caminho);
	}
}
