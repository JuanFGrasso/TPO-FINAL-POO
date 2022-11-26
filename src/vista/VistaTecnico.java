package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Controlador;
import modelo.EstadoInstalacion;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaTecnico extends JFrame{
	
	JPanel panel;
	TableModel model;
	private JTextField textField;
	
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaTecnico frame = new VistaTecnico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaTecnico() {
		setResizable(false);
		setTitle("Vista de Tecnico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,1000,700);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		panel.setLayout(null);
		setContentPane(panel);
	
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.setBounds(0,0,1000,700);
		panel.add(tabbed);
		
		String[] columnasi = {"Nro de instalacion",
				"Cliente",
				"Tecnico",
				"Estado",
				"Evaporadoras",
				"Condensadoras",
				"Kits de Instalacion"
		};
		
		String[][] datai = {};
		
		JPanel panel1 = new JPanel();
		tabbed.addTab("Instalacion", panel1);
		
		model = new DefaultTableModel(datai,columnasi) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		panel1.setLayout(new GridLayout(0, 1, 0, 0));
	
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel1.add(scrollPane);
		
		Controlador.cargaTablaIT(table);
		
		JPanel panel_1 = new JPanel();
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modificar Instalacion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 227, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nro Instalacion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 101, 114, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Estado a Pasar");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 156, 114, 25);
		panel_1.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(132, 105, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 159, 86, 22);
		
		comboBox.addItem(EstadoInstalacion.ENCURSO);
		comboBox.addItem(EstadoInstalacion.CANCELADA);
		comboBox.addItem(EstadoInstalacion.FINALIZADA);
		
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 226, 276, 20);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(129, 257, 89, 23);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Controlador.modificarEstadoInstalacion(Integer.parseInt(textField.getText()), comboBox.getSelectedItem().toString())) {
					Controlador.cargaTablaIT(table);
					textField.setText("");
				} else {
					lblNewLabel_2.setText("Instalacion en estado conclusivo");
				}
			}
		});
		panel_1.add(btnNewButton);
		
	}
}
