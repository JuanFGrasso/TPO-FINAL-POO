package vista;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaAdministrativo extends JFrame{
	
	JPanel panel;
	TableModel modelf;
	TableModel modeli;
	
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
		
		String[] columnasi = {"Nro de instalacion",
				"Cliente",
				"Tecnico",
				"Estado"
		};

		String[][]	datai = {};
		
		JPanel panel1 = new JPanel();
		tabbed.addTab("Facturar Cliente", panel1);
		panel.setLayout(new GridLayout(0,1,0,0));
		
		modeli = new DefaultTableModel(datai,columnasi) {
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
		
		JTable tablei = new JTable(modeli);
		JScrollPane scrollPane = new JScrollPane(tablei);
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
		
		JButton btnNewButton = new JButton("Facturar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(131, 197, 89, 23);
		panel_1.add(btnNewButton);
		
		//Pestaña Instalaciones
		
		JPanel panel2 = new JPanel();
		tabbed.addTab("Ajustar instalacion", panel2);
		
	}
}
