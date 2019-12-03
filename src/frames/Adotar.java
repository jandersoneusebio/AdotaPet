package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdbc.dao.Adocao;
import jdbc.dao.ListarPet;
import jdbc.modelo.Pets;
import net.miginfocom.swing.MigLayout;

public class Adotar {
	DefaultTableModel modelo = new DefaultTableModel();
	FichaDeAdocao ficha = new FichaDeAdocao();

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNome;
	private JLabel lblRaca;
	private JLabel lblIdade;
	private JLabel lblSexo;
	private JLabel lblAnimal;
	private JLabel bdAnimal;
	private JLabel bdNome;
	private JLabel bdRaca;
	private JLabel bdIdade;
	private JLabel bdSexo;
	private JLabel lblDeficiencia;
	private JLabel bdDeficiencia;
	private JButton btnAbrirFicha;

	/**
	 * Launch the application.
	 */
	public void adotar() {
//	public void listarAdotar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adotar window = new Adotar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Adotar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 780, 420);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[21.00][100.00][133.00][286.00][73.00,grow][71.00,grow]",
				"[][130.00][15.00][][][][][25.00][33.00][29.00,grow]"));

		scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 1 3 9,grow");

		table = new JTable(modelo);
		scrollPane.setViewportView(table);

		lblAnimal = new JLabel("Animal:");
		panel.add(lblAnimal, "cell 4 2");

		bdAnimal = new JLabel("");
		panel.add(bdAnimal, "cell 5 2");

		lblNome = new JLabel("Nome:");
		panel.add(lblNome, "cell 4 3");

		bdNome = new JLabel("");
		panel.add(bdNome, "cell 5 3");

		lblRaca = new JLabel("Raça:");
		panel.add(lblRaca, "cell 4 4");

		bdRaca = new JLabel("");
		panel.add(bdRaca, "cell 5 4");

		lblIdade = new JLabel("Idade:");
		panel.add(lblIdade, "cell 4 5");

		bdIdade = new JLabel("");
		panel.add(bdIdade, "cell 5 5");

		lblSexo = new JLabel("Sexo:");
		panel.add(lblSexo, "cell 4 6");

		bdSexo = new JLabel("");
		panel.add(bdSexo, "cell 5 6");

		lblDeficiencia = new JLabel("Deficiência:");
		panel.add(lblDeficiencia, "cell 4 7");
		lblDeficiencia.setEnabled(false);

		bdDeficiencia = new JLabel("");
		panel.add(bdDeficiencia, "cell 5 7");

		btnAbrirFicha = new JButton("Abrir Ficha de Adoção");
		panel.add(btnAbrirFicha, "cell 4 8 2 1,alignx center");

		modelo.addColumn("ID");
		modelo.addColumn("Animal");
		modelo.addColumn("Nome");
		modelo.addColumn("Raça");
		modelo.addColumn("Idade");
		modelo.addColumn("Sexo");
		modelo.addColumn("Deficiencia");

		table.getColumnModel().getColumn(0).setPreferredWidth(0);

		carregarTabela();

		table.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();

				bdAnimal.setText(modelo.getValueAt(linha, 1).toString());
				bdNome.setText(modelo.getValueAt(linha, 2).toString());
				bdRaca.setText(modelo.getValueAt(linha, 3).toString());
				bdIdade.setText(modelo.getValueAt(linha, 4).toString());
				bdSexo.setText(modelo.getValueAt(linha, 5).toString());

				Adocao apropriar = new Adocao();
				Pets pet = new Pets();

				pet.setIdPet(Integer.parseInt(modelo.getValueAt(table.getSelectedRow(), 0).toString()));
				apropriar.apropriar(pet);

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}

		});

		btnAbrirFicha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ficha.fichaDeAdocao();
			}
		});
	}

	public void carregarTabela() {
		ListarPet listar = new ListarPet();
		List<Pets> lista = listar.listar();

		for (Pets pet : lista) {
			modelo.addRow(new Object[] { pet.getIdPet(), pet.getPet(), pet.getNome(), pet.getRaca(), pet.getIdade(),
					pet.getSexo(), pet.getDeficiencia() });
		}

	}

}
