package vista;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Controlador;
import modelo.Instalacion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class VistaAdministrativo extends JFrame{
	
	JPanel panel;
	TableModel modelf;
	TableModel modelif;
	TableModel modeli;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdministrativo frame = new VistaAdministrativo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaAdministrativo() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,1000,700);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		panel.setLayout(null);
		setContentPane(panel);
	
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.setBounds(0,0,1000,700);
		panel.add(tabbed);
		
		// Pestaña Facturas
		
		String[] columnasif = {"Nro de instalacion",
				"Cliente",
				"Tecnico",
				"Estado",
				"Facturada"
		};

		String[][]	dataif = {};
		
		JPanel panel1 = new JPanel();
		tabbed.addTab("Facturar Cliente", panel1);
		panel.setLayout(new GridLayout(0,1,0,0));
		
		modelif = new DefaultTableModel(dataif,columnasif) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		String[] columnasf = {"Nro de factura",
				"Nro Instalacion",
				"Costo"
		};

		String[][]	dataf = {};
		
		
		modelf = new DefaultTableModel(dataf,columnasf) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable tableif = new JTable(modelif);
		JScrollPane scrollPane = new JScrollPane(tableif);
		
		scrollPane.setBounds(10, 11, 473, 345);
		
		JTable tablef = new JTable(modelf);
		JScrollPane scrollPane_1 = new JScrollPane(tablef);
		scrollPane_1.setBounds(493, 11, 476, 345);
		panel1.setLayout(null);
		panel1.add(scrollPane);
		panel1.add(scrollPane_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 367, 959, 255);
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Facturar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 188, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nro Instalacion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 79, 104, 25);
		panel_1.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 82, 89, 22);
		panel_1.add(comboBox);
		
		Controlador.cargaTablaIF(tableif,comboBox);
		
		JButton btnNewButton = new JButton("Facturar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(131, 197, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.facturarCliente(Integer.parseInt(comboBox.getSelectedItem().toString()));
				Controlador.cargaTablaIF(tableif,comboBox);
				Controlador.cargaTablaF(tablef);
			}
		});
		
		panel_1.add(btnNewButton);
		
		//Pestaña Instalaciones
		
		String[] columnasi = {"Nro de instalacion",
				"Cliente",
				"Tecnico",
				"Estado",
				"Evaporadoras",
				"Condensadoras",
				"Kits de Instalacion"
		};

		String[][]	datai = {};
		
		JPanel panel2 = new JPanel();
		tabbed.addTab("Ajustar instalacion", panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		modeli = new DefaultTableModel(datai, columnasi) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable tablei = new JTable(modeli);
		
		JScrollPane scrollPane_2 = new JScrollPane(tablei);
		panel2.add(scrollPane_2);
		
		Controlador.cargaTablaI(tablei);
		
		JPanel panel_2 = new JPanel();
		panel2.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ajustar Instalacion");
		lblNewLabel_2.setBounds(10, 11, 192, 25);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Evaporadoras");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 106, 98, 25);
		panel_2.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(140, 110, 86, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Condensadores");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(12, 143, 118, 25);
		panel_2.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 147, 86, 20);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Evaporadoras");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(10, 181, 98, 25);
		panel_2.add(lblNewLabel_3_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 185, 86, 20);
		panel_2.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(135, 251, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.ajustarInstalacion(Integer.parseInt(textField_3.getText()), Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()));
				Controlador.cargaTablaI(tablei);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 217, 292, 23);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_2 = new JLabel("Nro Instalacion");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(12, 66, 98, 25);
		panel_2.add(lblNewLabel_3_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(140, 70, 86, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
				
		
		
		
	}
}
