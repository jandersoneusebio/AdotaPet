package frames.consultas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import jdbc.dao.ListarPet;
import jdbc.modelo.Pets;
import net.miginfocom.swing.MigLayout;

public class Listar {
	DefaultTableModel modelo = new DefaultTableModel();

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField tfAnimal;
	private JTextField tfNome;
	private JTextField tfRaca;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
	public void listar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listar window = new Listar();
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
	public Listar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		String[] animal = {	"Cachorro", "Gato" };
//		
//		String[] gato = {"Persa" , "Spynx" , "Siamês" , "Pelo Curto"};
//		
//		String[] cachorro = {"Vira-lata" , "Pitbull" , "Rottweiler" , "Pinscher"};
		
		
		
		
		
		frame = new JFrame();
		frame.setTitle("Pets Cadastrados");
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 531, 306);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[30.00][100.00][103.00][184.00][16.00,grow]", "[][166.00,grow][41.00]"));
	
		scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 1 1 3 1,grow");
		
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
		
		tfAnimal = new JTextField();
		panel.add(tfAnimal, "cell 1 2,growx");
		tfAnimal.setColumns(10);
		tfAnimal.setEditable(false);
		
		tfNome = new JTextField();
		panel.add(tfNome, "cell 2 2,growx");
		tfNome.setColumns(10);
		tfNome.setEditable(false);
		
		tfRaca = new JTextField();
		panel.add(tfRaca, "cell 3 2,growx");
		tfRaca.setColumns(10);
		tfRaca.setEditable(false);
		
		modelo.addColumn("ID");
		modelo.addColumn("Animal");
		modelo.addColumn("Nome");
		modelo.addColumn("Raça");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(3);
		carregar();
		
		table.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();
				
				tfAnimal.setText(modelo.getValueAt(linha, 0).toString());
				tfNome.setText(modelo.getValueAt(linha, 1).toString());
				tfRaca.setText(modelo.getValueAt(linha, 2).toString());
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
	}
	
	public void carregar() {
		ListarPet listar = new ListarPet();
		List<Pets> lista = listar.listar();
		modelo.isCellEditable(1, 1);
		for (Pets pets : lista) {
			modelo.addRow(new Object[] {pets.getIdPet(),pets.getPet(),pets.getNome(),pets.getRaca()});
		}
	}
}
