package frames;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jdbc.dao.LoginDAO;
import jdbc.modelo.Usuarios;

public class LoginFrame {
	public static void main(String[] args) {
		Principal success = new Principal();

		// Labels
		JLabel email = new JLabel("E-mail: ");
		JLabel senha = new JLabel("Senha: ");

		// Campos de texto
		JTextField entEmail = new JTextField();
		entEmail.setColumns(10);
		JPasswordField entSenha = new JPasswordField();
		entSenha.setColumns(10);

		// Botões
		JButton entrar = new JButton("Entrar");
		JCheckBox ckMostrar = new JCheckBox("Mostrar Senha");

		JPanel panel = new JPanel();
		panel.add(email);
		panel.add(entEmail);
		panel.add(senha);
		panel.add(entSenha);
		panel.add(ckMostrar);
		panel.add(entrar);

		JFrame janela = new JFrame("Login");
		janela.add(panel);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);
		janela.setSize(200, 160);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		
		entrar.getRootPane().setDefaultButton(entrar);
		

		ActionListener logar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuario = new Usuarios();
				usuario.setEmail(entEmail.getText());
				usuario.setSenha(new String(entSenha.getPassword()));
				LoginDAO check = new LoginDAO();
				try {
					if (check.logar(usuario)) {
						janela.setVisible(false);
						success.iniciarPrincipal();
					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos", "ERRO",JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException | SQLException ex) {
					ex.printStackTrace();
				}
			}
		};
		entrar.addActionListener(logar);

		ActionListener mostrar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckMostrar.isSelected()) {
					entSenha.setEchoChar((char) 0);
				} else {
					entSenha.setEchoChar('*');
				}
			}
		};
		ckMostrar.addActionListener(mostrar);

	}

}
