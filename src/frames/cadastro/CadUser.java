package frames.cadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.mail.MessagingException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javamail.JavaMailApp;
import jdbc.dao.EnviarBD;
import jdbc.modelo.Usuarios;
import net.miginfocom.swing.MigLayout;

public class CadUser {
	JavaMailApp email = new JavaMailApp();
	private JFrame frmCadastroDeUsuarios;
	private JTextField tfNome;
	private JTextField tfSobre;
	private JTextField tfEmail;
	private JPasswordField pfSenha;
	private JCheckBox ckMostrarSenha;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public void cadastrar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadUser window = new CadUser();
					window.frmCadastroDeUsuarios.setVisible(true);
					window.frmCadastroDeUsuarios.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeUsuarios = new JFrame();
		frmCadastroDeUsuarios.setTitle("Cadastro de Usuários");
		frmCadastroDeUsuarios.setBounds(100, 100, 403, 236);
		frmCadastroDeUsuarios.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Cadastro"));
		frmCadastroDeUsuarios.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][107.00,grow,left][][127.00,grow]", "[][-5.00][][][10.00][grow][]"));

		JLabel lblNome = new JLabel("Nome:");
		panel.add(lblNome, "cell 0 0,alignx trailing");

		tfNome = new JTextField();
		panel.add(tfNome, "cell 1 0,growx");
		tfNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		panel.add(lblSobrenome, "cell 2 0,alignx trailing");

		tfSobre = new JTextField();
		panel.add(tfSobre, "cell 3 0,growx");
		tfSobre.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		panel.add(lblEmail, "cell 0 2,alignx trailing");

		tfEmail = new JTextField();
		panel.add(tfEmail, "cell 1 2 3 1,growx");
		tfEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		panel.add(lblSenha, "cell 0 3,alignx trailing");

		pfSenha = new JPasswordField();
		panel.add(pfSenha, "cell 1 3 2 1,growx");

		ckMostrarSenha = new JCheckBox("Mostrar Senha");
		panel.add(ckMostrarSenha, "cell 3 3");

		btnCadastrar = new JButton("Cadastrar");

		panel.add(btnCadastrar, "cell 0 5 4 1,alignx center");

		ActionListener mostrar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// •
				if (ckMostrarSenha.isSelected()) {
					pfSenha.setEchoChar((char) 0);
				} else {
					pfSenha.setEchoChar('•');
				}
			}
		};
		ckMostrarSenha.addActionListener(mostrar);

		btnCadastrar.getRootPane().setDefaultButton(btnCadastrar);

		ActionListener cadastrar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Os campos não podem estar em branco!");
				} else {
					btnCadastrar.setText("");
					btnCadastrar.setIcon(new ImageIcon(CadUser.class.getResource("/frames/carregandooo.gif")));

					Usuarios user = new Usuarios();
					user.setNome(tfNome.getText());
					user.setSobrenome(tfSobre.getText());
					user.setEmail(tfEmail.getText());
					user.setSenha(new String(pfSenha.getPassword()));

					Random aut = new Random();

					user.setCodigo(aut.nextInt(9999));

					email.enviarCodigo(user);
					boolean aute = false;

					while (aute == false) {
						if (email.autenticar(user)) {
							JOptionPane.showMessageDialog(null, "Código correto, autenticado!");
							EnviarBD enviar = new EnviarBD();
							enviar.salvar(user);
							email.emailBoasVindas(user);

							aute = true;
						} else {
							JOptionPane.showMessageDialog(null, "Código Incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}

					frmCadastroDeUsuarios.setVisible(false);
				}
			}
		};
		btnCadastrar.addActionListener(cadastrar);
	}
}
