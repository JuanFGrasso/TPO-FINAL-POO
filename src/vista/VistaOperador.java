package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Controlador;

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
	private JTextField textField5_3;
	private JTextField textField5_4;
	private JTextField textField5_5;
	private JTextField textField5_6;
	
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
		setTitle("Vista de Operador");
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
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField4_1.getText().equals("") || textField4_2.getText().equals("") || textField4_3.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Ingrese todos los campos");
				} else {
					if (!Controlador.isNumeric(textField4_1.getText())) {
						JOptionPane.showMessageDialog(panel, "Datos ingresados incorrectos");
					} else {
						Controlador.crearCliente(Integer.parseInt(textField4_1.getText()), textField4_2.getText(), textField4_3.getText());
						String[] datac = {textField4_1.getText(), textField4_2.getText(), textField4_3.getText()};
						
						DefaultTableModel tblModel = (DefaultTableModel)tablec.getModel();
						tblModel.addRow(datac);
						textField4_1.setText("");
						textField4_2.setText("");
						textField4_3.setText("");
					}
				}
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
							"Estado",
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
		
		JButton btnNewButton5_1 = new JButton("Programar");
		btnNewButton5_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		btnNewButton5_1.setBounds(862, 264, 105, 27);
		panel5.add(btnNewButton5_1);
		
		JComboBox comboBox5_1 = new JComboBox();
		comboBox5_1.setBounds(405, 76, 62, 22);
		panel5.add(comboBox5_1);
		
		for (int i = 0; i < 6; i++) {
			comboBox5_1.addItem(i);
		}
		
		JLabel label5_6 = new JLabel("Horario");
		label5_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_6.setBounds(321, 119, 62, 14);
		panel5.add(label5_6);
		
		JComboBox comboBox5_2 = new JComboBox();
		comboBox5_2.setBounds(405, 117, 62, 22);
		panel5.add(comboBox5_2);
		
		for (int i = 0; i < 24; i++) {
			comboBox5_2.addItem(i);
		}
		
		JLabel label5_7 = new JLabel("Tiempo");
		label5_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_7.setBounds(321, 159, 77, 14);
		panel5.add(label5_7);
		
		textField5_3 = new JTextField();
		textField5_3.setColumns(10);
		textField5_3.setBounds(405, 158, 77, 20);
		panel5.add(textField5_3);
		
		JLabel label5_8 = new JLabel("Cant. Evaporadoras");
		label5_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_8.setBounds(544, 79, 151, 14);
		panel5.add(label5_8);
		
		textField5_4 = new JTextField();
		textField5_4.setColumns(10);
		textField5_4.setBounds(705, 77, 122, 20);
		panel5.add(textField5_4);
		
		JLabel label5_9 = new JLabel("Cant. Condensadoras");
		label5_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_9.setBounds(544, 115, 151, 14);
		panel5.add(label5_9);
		
		textField5_5 = new JTextField();
		textField5_5.setColumns(10);
		textField5_5.setBounds(705, 113, 122, 20);
		panel5.add(textField5_5);
		
		JLabel label5_10 = new JLabel("Cant. Kits");
		label5_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5_10.setBounds(544, 155, 151, 14);
		panel5.add(label5_10);
		
		textField5_6 = new JTextField();
		textField5_6.setColumns(10);
		textField5_6.setBounds(705, 153, 122, 20);
		panel5.add(textField5_6);
		
		btnNewButton5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField5_1.getText().equals("") || textField5_2.getText().equals("") || textField5_3.getText().equals("") || textField5_4.getText().equals("") || textField5_5.getText().equals("") || textField5_6.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Ingrese todos los campos");
				} else {
					if (!Controlador.isNumeric(textField5_1.getText()) || !Controlador.isNumeric(textField5_2.getText()) || !Controlador.isNumeric(textField5_3.getText()) || !Controlador.isNumeric(textField5_4.getText()) || !Controlador.isNumeric(textField5_5.getText()) || !Controlador.isNumeric(textField5_6.getText())) {
						JOptionPane.showMessageDialog(panel, "Datos ingresados incorrectos");
					} else {
						String flag = Controlador.programarInstalacion(Integer.parseInt(textField5_1.getText()), Integer.parseInt(textField5_2.getText()), Integer.parseInt(comboBox5_1.getSelectedItem().toString()), Integer.parseInt(comboBox5_2.getSelectedItem().toString()), Integer.parseInt(textField5_3.getText()), Integer.parseInt(textField5_4.getText()), Integer.parseInt(textField5_5.getText()), Integer.parseInt(textField5_6.getText()));
						if (flag.equals("")) {
							Controlador.cargaTablaI(tablei);
							label5_5.setText("");
							textField5_1.setText("");
							textField5_2.setText("");
							textField5_3.setText("");
							textField5_4.setText("");
							textField5_5.setText("");
							textField5_6.setText("");
						} else {
							label5_5.setText(flag);
						}
					}
				}
			}
		});
	}
}
