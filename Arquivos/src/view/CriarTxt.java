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
		this.setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNomeDoArquivo = new JLabel("Insira um nome para o novo arquivo de texto");
			lblNomeDoArquivo.setBounds(30, 29, 242, 14);
			contentPanel.add(lblNomeDoArquivo);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.setBounds(30, 54, 110, 20);
			contentPanel.add(textFieldNome);
			textFieldNome.setColumns(10);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(30, 86, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(30, 85, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel lblEscolhaOCaminho = new JLabel("Escolha o caminho que deseja salvar o arquivo");
			lblEscolhaOCaminho.setBounds(30, 85, 242, 14);
			contentPanel.add(lblEscolhaOCaminho);
		}
		{
			textFieldCaminho = new JTextField();
			textFieldCaminho.setBounds(30, 119, 164, 20);
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void preencheTextField(String caminho) {
		textFieldCaminho.setText(caminho);
	}
}
