package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Controlador;
import modelo.Empresa;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;

public class VistaOperador extends JFrame{
	
	JPanel panel;
	TableModel modelc;
	TableModel modelt;
	TableModel modeli;
	private JTextField textField4_1;
	private JTextField textField4_2;
	private JTextField textField4_3;
	private JTextField textField5_1;
	private JTextField textField5_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaOperador frame = new VistaOperador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaOperador() {
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
		
		// Pestaña Clientes
		
		
		String[] columnasc = {"Nro Documento",
							"Nombre",
							"Direccion"
		};
		
		String[][] datac = {};
		
		
		JPanel panel1 = new JPanel();
		tabbed.addTab("Clientes", panel1);
		panel1.setLayout(new GridLayout(0, 1, 0, 0));
		
		modelc = new DefaultTableModel(datac,columnasc) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable tablec = new JTable(modelc);
		
		panel1.add(new JScrollPane(tablec));
		
		Controlador.cargaTablaC(tablec);
		
		JPanel panel4 = new JPanel();
		panel1.add(panel4);
		panel4.setLayout(null);
		
		JLabel label4_1 = new JLabel("Alta Cliente");
		label4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label4_1.setBounds(10, 11, 158, 27);
		panel4.add(label4_1);
		
		JLabel label4_2 = new JLabel("Nro de documento");
		label4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label4_2.setBounds(10, 78, 122, 14);
		panel4.add(label4_2);
		
		textField4_1 = new JTextField();
		textField4_1.setBounds(156, 77, 216, 20);
		panel4.add(textField4_1);
		textField4_1.setColumns(10);
		
		JLabel label4_3 = new JLabel("Nombre");
		label4_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label4_3.setBounds(10, 119, 122, 14);
		panel4.add(label4_3);
		
		textField4_2 = new JTextField();
		textField4_2.setColumns(10);
		textField4_2.setBounds(156, 118, 216, 20);
		panel4.add(textField4_2);
		
		JLabel label4_4 = new JLabel("Dirección");
		label4_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label4_4.setBounds(10, 167, 122, 14);
		panel4.add(label4_4);
		
		textField4_3 = new JTextField();
		textField4_3.setColumns(10);
		textField4_3.setBounds(156, 166, 216, 20);
		panel4.add(textField4_3);
		
		JLabel label4_5 = new JLabel("");
		label4_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label4_5.setBounds(10, 224, 257, 27);
		panel4.add(label4_5);
		
		JButton btnNewButton1 = new JButton("Crear");
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.crearCliente(Integer.parseInt(textField4_1.getText()), textField4_2.getText(), textField4_3.getText());
				String[] datac = {textField4_1.getText(), textField4_2.getText(), textField4_3.getText()};
				
				DefaultTableModel tblModel = (DefaultTableModel)tablec.getModel();
				tblModel.addRow(datac);
				textField4_1.setText("");
				textField4_2.setText("");
				textField4_3.setText("");
			}
		});
		btnNewButton1.setBounds(211, 262, 89, 23);
		panel4.add(btnNewButton1);
		
		// Pestaña Tecnicos
		
		String[] columnast = {"Nro Empleado",
				"Nombre",
				"Nivel"
		};

		String[][] datat = {};
		
		modelt = new DefaultTableModel(datat,columnast) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable tablet = new JTable(modelt);
		
		JPanel panel2 = new JPanel();
		tabbed.addTab("Tecnicos", panel2);
		panel2.setLayout(new GridLayout(0,1,0,0));
		
		panel2.add(new JScrollPane(tablet));
		
		Controlador.cargaTablaT(tablet);
		
		// Pestaña Instalaciones
		
		String[] columnasi = {"Nro de instalacion",
							"Cliente",
							"Tecnico",
							"Fecha",
							"Evaporadoras",
							"Condensadoras",
							"Kits de Instalacion"
		};
		
		String[][]	datai = {};
		
		modeli = new DefaultTableModel(datai,columnasi) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable tablei = new JTable(modeli);
		
		JPanel panel3 = new JPanel();
		tabbed.addTab("Instalaciones", panel3);
		panel3.setLayout(new GridLayout(0,1,0,0));
		
		panel3.add(new JScrollPane(tablei));
		
		Controlador.cargaTablaI(tablei);
		
		JPanel panel5 = new JPanel();
		panel3.add(panel5);
		panel5.setLayout(null);
		
		JLabel label5_1 = new JLabel("Programar Instalacion");
		label5_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label5_1.setBounds(10, 11, 274, 27);
		panel5.add(label5_1);
		
		JLabel label5_2 = new JLabel("Nro Cliente");
		label5_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_2.setBounds(10, 78, 122, 14);
		panel5.add(label5_2);
		
		textField5_1 = new JTextField();
		textField5_1.setBounds(120, 77, 151, 20);
		panel5.add(textField5_1);
		textField5_1.setColumns(10);
		
		JLabel label5_3 = new JLabel("Nro Tecnico");
		label5_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_3.setBounds(10, 119, 122, 14);
		panel5.add(label5_3);
		
		textField5_2 = new JTextField();
		textField5_2.setColumns(10);
		textField5_2.setBounds(120, 118, 151, 20);
		panel5.add(textField5_2);
		
		JLabel label5_4 = new JLabel("Dia");
		label5_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_4.setBounds(321, 78, 62, 14);
		panel5.add(label5_4);
		
		JLabel label5_5 = new JLabel("");
		label5_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_5.setBounds(10, 224, 442, 27);
		panel5.add(label5_5);
		
		JButton btnNewButton2 = new JButton("Programar");
		btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnNewButton2.setBounds(862, 264, 105, 27);
		panel5.add(btnNewButton2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(405, 76, 62, 22);
		panel5.add(comboBox);
		
		for (int i = 1; i < 7; i++) {
			comboBox.addItem(i);
		}
		
		JLabel label5_4_1 = new JLabel("Horario");
		label5_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_4_1.setBounds(321, 119, 62, 14);
		panel5.add(label5_4_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(405, 117, 62, 22);
		panel5.add(comboBox_1);
		
		for (int i = 1; i < 25; i++) {
			comboBox_1.addItem(i);
		}
		
		JLabel label5_3_1 = new JLabel("Tiempo");
		label5_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_3_1.setBounds(321, 159, 77, 14);
		panel5.add(label5_3_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(405, 158, 77, 20);
		panel5.add(textField);
		
		JLabel label5_2_1 = new JLabel("Cant. Evaporadoras");
		label5_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_2_1.setBounds(544, 79, 151, 14);
		panel5.add(label5_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(705, 77, 122, 20);
		panel5.add(textField_1);
		
		JLabel label5_2_1_1 = new JLabel("Cant. Condensadoras");
		label5_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_2_1_1.setBounds(544, 115, 151, 14);
		panel5.add(label5_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(705, 113, 122, 20);
		panel5.add(textField_2);
		
		JLabel label5_2_1_1_1 = new JLabel("Cant. Kits");
		label5_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_2_1_1_1.setBounds(544, 155, 151, 14);
		panel5.add(label5_2_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(705, 153, 122, 20);
		panel5.add(textField_3);
		
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String flag = Controlador.programarInstalacion(Integer.parseInt(textField5_1.getText()), Integer.parseInt(textField5_2.getText()), Integer.parseInt(comboBox.getSelectedItem().toString()), Integer.parseInt(comboBox_1.getSelectedItem().toString()), Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()), Integer.parseInt(textField_3.getText()));
				if (flag.equals("")) {
					Controlador.cargaTablaI(tablei);
				} else {
					label5_5.setText(flag);
				}
			}
		});
	}
}
