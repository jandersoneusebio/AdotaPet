package frames.cadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import jdbc.dao.CadPetDAO;
import jdbc.modelo.Pets;
import net.miginfocom.swing.MigLayout;

public class CadPetWindow {
	private JFrame frmCadastroDePets;
	private JTextField tfDeficiencia;
	private JTextField tfNome;

	/**
	 * Launch the application.
	 */
	public void cadPet() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadPetWindow window = new CadPetWindow();
					window.frmCadastroDePets.setVisible(true);
					window.frmCadastroDePets.setSize(370, 250);
					window.frmCadastroDePets.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadPetWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String[] racas = { "Vira-lata",  "SRDF"};
		String[] tipoIdade = { "Dias", "Semanas", "Meses", "Anos" };
		String[] sexo = { "Macho", "Fêmea" };
		String[] pet = {"Gato" , "Cachorro"};

		frmCadastroDePets = new JFrame();
		frmCadastroDePets.setTitle("Cadastro de Pet");

		JPanel panel = new JPanel();
		frmCadastroDePets.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][42.00,grow][73.00,grow][121.00,grow]", "[][][][][][][][]"));

		JLabel lblPet = new JLabel("Pet:");
		panel.add(lblPet, "cell 0 0,alignx trailing");

		JComboBox<Object> cbPet = new JComboBox<Object>(pet);
		panel.add(cbPet, "cell 1 0 2 1,growx");
		
		
		JCheckBox ckApto = new JCheckBox("Apto para adoção");
		panel.add(ckApto, "cell 3 0");

		JLabel lblRaca = new JLabel("Raça: ");
		panel.add(lblRaca, "cell 0 1,alignx trailing");
		
		JComboBox<Object> cbRaca = new JComboBox<Object>(racas);
		panel.add(cbRaca, "cell 1 1 2 1,growx");
		
		JLabel lblIdade = new JLabel("Idade:");
		panel.add(lblIdade, "cell 0 2,alignx trailing");

		JSpinner spIdade = new JSpinner();
		panel.add(spIdade, "cell 1 2,growx");

		JComboBox<Object> cbTipoIdade = new JComboBox<Object>(tipoIdade);
		panel.add(cbTipoIdade, "cell 2 2 2 1,growx");

		JCheckBox ckDeficiente = new JCheckBox("Deficiente");
		panel.add(ckDeficiente, "cell 0 3 2 1,alignx left");
		
		tfDeficiencia = new JTextField();
		tfDeficiencia.setEnabled(false);
		panel.add(tfDeficiencia, "cell 2 3 2 1,growx");
		tfDeficiencia.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		panel.add(lblNome, "cell 0 4,alignx trailing");

		tfNome = new JTextField();
		panel.add(tfNome, "cell 1 4 2 1,growx");
		tfNome.setColumns(10);

		JComboBox<Object> cbSexo = new JComboBox<Object>(sexo);
		panel.add(cbSexo, "cell 3 4,growx");

		JButton btnCadastrar = new JButton("Cadastrar");
		panel.add(btnCadastrar, "cell 2 5,alignx center");
		
		JTable teste = new JTable();
		panel.add(teste,"cell 2 7");
		
		

		ActionListener deficiente = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckDeficiente.isSelected()) {
					JOptionPane.showMessageDialog(null, "Informe a deficiência");
					tfDeficiencia.setEnabled(true);
				} else {
					tfDeficiencia.setEnabled(false);
				}
			}
		};
		ckDeficiente.addActionListener(deficiente);

		ActionListener cadPet = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckDeficiente.isSelected() && tfDeficiencia.equals(null)) {
					JOptionPane.showMessageDialog(null, "Informe a deficiência!", "ERRO", JOptionPane.WARNING_MESSAGE);
					tfDeficiencia.setBackground(Color.getHSBColor(255, 64, 64));
				} else {
					Pets pet = new Pets();
					pet.setPet(cbPet.getSelectedItem().toString());
					pet.setNome(tfNome.getText());
					pet.setRaca(cbRaca.getSelectedItem().toString());
					pet.setIdade(spIdade.getValue().toString());
					pet.setTipoIdade(cbTipoIdade.getSelectedItem().toString());
					pet.setDeficiente(ckDeficiente.isSelected());
					pet.setDeficiencia(tfDeficiencia.getText());
					pet.setSexo(cbSexo.getSelectedItem().toString());
					pet.setAdocao(ckApto.isSelected());
					
					CadPetDAO cad = new CadPetDAO();
					cad.cadastrar(pet);
					frmCadastroDePets.setVisible(false);
				}
			}
		};
		btnCadastrar.addActionListener(cadPet);
		
		
		
	}
}
