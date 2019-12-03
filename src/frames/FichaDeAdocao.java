package frames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import javamail.JavaMailApp;
import jdbc.dao.Adocao;
import jdbc.dao.ResponsavelDAO;
import jdbc.modelo.Ficha;
import jdbc.modelo.Responsavel;
import net.miginfocom.swing.MigLayout;

public class FichaDeAdocao {
	static Adocao apropriar = new Adocao();
	static List<Ficha> lista = apropriar.preencher();

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfEndereco;
	private JTextField tfEmail;
	private JTextField tfSobrenome;
	private JTextField tfTelefone;
	private JTextField tfPetNome;
	private JTextField tfPetIdade;
	private JTextField tfPetSexo;
	private JTextField tfPetRaca;
	private JTextField tfPetDeficiencia;
	private JCheckBox ckDeficiente;

	private String nome;
	private String sexo;

	public void popular(String nome, String idade, String sexo, String raca, String deficiencia) {
		tfPetNome.setText(nome);
		tfPetIdade.setText(idade);
		tfPetSexo.setText(sexo);
		tfPetRaca.setText(raca);
		tfPetDeficiencia.setText(deficiencia);
	}

	/**
	 * Launch the application.
	 */
	public void fichaDeAdocao() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaDeAdocao window = new FichaDeAdocao();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FichaDeAdocao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		sexo = "Masculino";

		frame = new JFrame();
		frame.setBounds(100, 100, 572, 374);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[57.00,grow][97.00,grow][18.00][86.00][81.00,grow]",
				"[62.00][][][][][][24.00][][][][grow]"));

		JPanel panelResp = new JPanel();
		frame.getContentPane().add(panelResp, "cell 0 0 5 6,grow");
		panelResp.setBorder(BorderFactory.createTitledBorder("Informações do Responsável"));
		panelResp.setLayout(
				new MigLayout("", "[][128.00,grow][70.00][48.00,grow][106.00][35.00][grow]", "[][][][15.00][][]"));

		JLabel lblNome = new JLabel("Nome:");
		panelResp.add(lblNome, "cell 0 0,alignx trailing");

		tfNome = new JTextField();
		panelResp.add(tfNome, "cell 1 0 2 1,growx");
		tfNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		panelResp.add(lblSobrenome, "cell 3 0,alignx trailing");

		tfSobrenome = new JTextField();
		tfSobrenome.setColumns(10);
		panelResp.add(tfSobrenome, "cell 4 0 3 1,growx");

		JLabel lblEndereo = new JLabel("Endereço:");
		panelResp.add(lblEndereo, "cell 0 1,alignx trailing");

		tfEndereco = new JTextField();
		tfEndereco.setToolTipText("(rua, número, bairro, cidade, estado)");
		panelResp.add(tfEndereco, "cell 1 1 6 1,growx");
		tfEndereco.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		panelResp.add(lblEmail, "cell 0 2,alignx trailing");

		tfEmail = new JTextField();
		panelResp.add(tfEmail, "cell 1 2 3 1,growx");
		tfEmail.setColumns(10);

		JLabel lblIdade = new JLabel("Idade:");
		panelResp.add(lblIdade, "flowx,cell 4 2,alignx right");

		JSpinner spIdade = new JSpinner();
		panelResp.add(spIdade, "cell 5 2,growx");

		JLabel lblSexo = new JLabel("Sexo:");
		panelResp.add(lblSexo, "cell 0 3,alignx trailing");

		JRadioButton rbtnMasculino = new JRadioButton("Masculino");
		panelResp.add(rbtnMasculino, "flowy,cell 1 3");

		JCheckBox ckFilhos = new JCheckBox("Possui filhos");
		panelResp.add(ckFilhos, "cell 3 3");

		JRadioButton rbtnFeminino = new JRadioButton("Feminino");
		panelResp.add(rbtnFeminino, "cell 1 4");

		JCheckBox ckAlergico = new JCheckBox("Alérgico");
		panelResp.add(ckAlergico, "cell 3 4");

		JLabel lblCpf = new JLabel("CPF:");
		panelResp.add(lblCpf, "cell 0 5,alignx trailing");

		JTextField tfCpf = new JTextField();
		panelResp.add(tfCpf, "cell 1 5,growx");

		JLabel lblTelefone = new JLabel("Telefone");
		panelResp.add(lblTelefone, "cell 4 5,alignx trailing");

		tfTelefone = new JTextField();
		panelResp.add(tfTelefone, "cell 5 5 2 1,growx");
		tfTelefone.setColumns(10);

		rbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbtnFeminino.isSelected()) {
					rbtnFeminino.setSelected(false);
					sexo = "Masculino";
				}
			}
		});

		rbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbtnMasculino.isSelected()) {
					rbtnMasculino.setSelected(false);
					sexo = "Feminino";
				}
			}
		});

		JPanel panelPet = new JPanel();
		frame.getContentPane().add(panelPet, "cell 0 6 5 4,grow");
		panelPet.setLayout(new MigLayout("", "[][31.00][53.00][96.00][][][]", "[][][][]"));
		panelPet.setBorder(BorderFactory.createTitledBorder("Informações do Pet"));

		JLabel lblNome_1 = new JLabel("Nome:");
		panelPet.add(lblNome_1, "cell 0 0,alignx trailing");

		tfPetNome = new JTextField();
		panelPet.add(tfPetNome, "cell 1 0 3 1,growx");
		tfPetNome.setColumns(10);

		JLabel lblRaa = new JLabel("Raça:");
		panelPet.add(lblRaa, "cell 5 0,alignx trailing");

		tfPetRaca = new JTextField();
		panelPet.add(tfPetRaca, "cell 6 0,growx,aligny top");
		tfPetRaca.setColumns(10);

		JLabel lblIdade_1 = new JLabel("Idade:");
		panelPet.add(lblIdade_1, "cell 0 1,alignx trailing");

		tfPetIdade = new JTextField();
		panelPet.add(tfPetIdade, "cell 1 1 2 1,growx");
		tfPetIdade.setColumns(10);

		JLabel lblDeficiente = new JLabel("Deficiente:");
		panelPet.add(lblDeficiente, "cell 5 1,alignx trailing");
		
		ckDeficiente = new JCheckBox("");
		ckDeficiente.setEnabled(true);
		panelPet.add(ckDeficiente, "cell 6 1");

		JLabel lblSexo_1 = new JLabel("Sexo:");
		panelPet.add(lblSexo_1, "cell 0 2,alignx trailing");

		tfPetSexo = new JTextField();
		panelPet.add(tfPetSexo, "cell 1 2 2 1");
		tfPetSexo.setColumns(10);

		JLabel lblDeficincia = new JLabel("Deficiência:");
		panelPet.add(lblDeficincia, "cell 5 2,alignx trailing");

		tfPetDeficiencia = new JTextField();
		panelPet.add(tfPetDeficiencia, "cell 6 2,growx");
		tfPetDeficiencia.setColumns(10);
		preencher();

		JButton btnFinalizar = new JButton("Finalizar");
		frame.getContentPane().add(btnFinalizar, "cell 0 10 5 1,alignx center");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Responsavel resp = new Responsavel();
				resp.setNome(tfNome.getText());
				resp.setSobrenome(tfSobrenome.getText());
				resp.setEndereco(tfEndereco.getText());
				resp.setEmail(tfEmail.getText());
				resp.setSexo(sexo);
				resp.setFilhos(ckFilhos.isSelected());
				resp.setAlergico(ckAlergico.isSelected());
				resp.setCpf(tfCpf.getText());
				resp.setTelefone(Integer.parseInt(tfTelefone.getText()));
				resp.setAlergico(ckAlergico.isSelected());
				resp.setFilhos(ckFilhos.isSelected());
				ResponsavelDAO enviar = new ResponsavelDAO();
				enviar.cadResp(resp);
				
				Ficha pet = new Ficha();
				pet.setNome(tfPetNome.getText());
				pet.setIdade(tfPetIdade.getText());
				pet.setSexo(tfPetSexo.getText());
				pet.setRaca(tfPetRaca.getText());
				
				JavaMailApp email = new JavaMailApp();
				email.emailAdocao(resp, pet);

			}
		});
	}

	public void preencher() {
		for (Ficha e : lista) {
			tfPetNome.setText(e.getNome());
			tfPetRaca.setText(e.getRaca());
			tfPetIdade.setText(e.getIdade() + " " + e.getTipoIdade());
			tfPetSexo.setText(e.getSexo());
			tfPetDeficiencia.setText(e.getDeficiencia());
			
			if (e.getDeficiencia().equals(null)) {
				ckDeficiente.setSelected(false);
			} else {
				ckDeficiente.setSelected(true);
			}
			
		}
	}

}
