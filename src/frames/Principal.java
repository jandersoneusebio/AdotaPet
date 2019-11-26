package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class Principal {
	

	private JFrame frmAdotapet;

	/**
	 * Launch the application.
	 */
	public void iniciarPrincipal() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmAdotapet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmAdotapet = new JFrame();
		frmAdotapet.setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("iconPata.png")));
		frmAdotapet.setTitle("AdotaPet");
		frmAdotapet.setBounds(100, 100, 530, 580);
		frmAdotapet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdotapet.setLocationRelativeTo(null);
		
		
		// Barra de Menu
		JMenuBar menuBar = new JMenuBar();
		frmAdotapet.setJMenuBar(menuBar);
		
		
		JMenu jmCadastro = new JMenu("Cadastro");
		JMenu jmAdotar = new JMenu("Adotar");
		JMenu jmSair = new JMenu("Sair");
		menuBar.add(jmCadastro);
		menuBar.add(jmAdotar);
		menuBar.add(jmSair);
		
		JMenuItem miSair = new JMenuItem("Sair da Aplicação");
		ActionListener sair = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair da Aplicação",JOptionPane.YES_NO_OPTION);
				
				if (op == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		};
		jmSair.add(miSair);
		miSair.addActionListener(sair);
		
		JMenuItem miCadUser = new JMenuItem("Cadastrar Usuário");
		JMenuItem miCadPet = new JMenuItem("Cadastrar Pet");
		
		jmCadastro.add(miCadUser);
		jmCadastro.add(miCadPet);
		
		ActionListener cadUser = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadUser user = new CadUser();
				user.cadastrar();
			}
		};
		miCadUser.addActionListener(cadUser);
		
		ActionListener cadPet = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadPetWindow pet = new CadPetWindow();
				pet.cadPet();
			}
		};
		miCadPet.addActionListener(cadPet);
		
		JPanel panel = new JPanel();
		frmAdotapet.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[410.00,grow]", "[18.00][30.00][18.00][417.00,grow]"));
		
		JLabel lblAdotapet = new JLabel("AdotaPet");
		lblAdotapet.setFont(new Font("FreeSans", Font.BOLD, 20));
		panel.add(lblAdotapet, "cell 0 1,alignx center");
		
		JLabel lblIconAdotaPet = new JLabel("");
		lblIconAdotaPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAdotaPet.setIcon(new ImageIcon(Principal.class.getResource("/imagens/adotaPetLOGO.png")));
		
		panel.add(lblIconAdotaPet, "cell 0 3,alignx center,aligny center");
		
	}

}
