package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.Controlador;
import modelo.NivelTecnico;
import modelo.TipoEmpleado;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class VistaAdministrador extends JFrame{
	
	JPanel panel;
	TableModel modelu;
	TableModel modelct;
	TableModel modelce;
	TableModel models;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdministrador frame = new VistaAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaAdministrador(){
		setResizable(false);
		setTitle("Vista de Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,1000,700);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		panel.setLayout(null);
		setContentPane(panel);
	
		JTabbedPane tabbed = new JTabbedPane();
		tabbed.setBounds(0,0,1000,700);
		panel.add(tabbed);
		
		// Pestaña Personal
		
		String[] columnasu = {"Nro de empleado",
				"Nombre",
				"Tipo",
				"Nivel"
		};
		
		String[][] datau = {};
		
		JPanel panel1 = new JPanel();
		tabbed.addTab("ABM Personal", panel1);
		
		modelu = new DefaultTableModel(datau,columnasu) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		panel1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTable tableu = new JTable(modelu);
		
		panel1.add(new JScrollPane(tableu));
		
		Controlador.cargaTablaU(tableu);
		
		JPanel panel_1 = new JPanel();
		panel1.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABM Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 137, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Accion");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 65, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(128, 63, 85, 22);
		panel_1.add(comboBox);
		
		comboBox.addItem("CREAR");
		comboBox.addItem("MODIFICAR");
		comboBox.addItem("BAJA");
		
		JLabel lblNewLabel_2 = new JLabel("Nro Empleado");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 124, 119, 25);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(128, 128, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tipo");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(310, 60, 119, 25);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Clave");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(310, 185, 119, 25);
		panel_1.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(428, 189, 86, 20);
		panel_1.add(textField_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(429, 63, 85, 22);
		panel_1.add(comboBox_1);
		
		comboBox_1.addItem(TipoEmpleado.ADMINISTRADOR.toString());
		comboBox_1.addItem(TipoEmpleado.ADMINISTRATIVO.toString());
		comboBox_1.addItem(TipoEmpleado.OPERADOR.toString());
		comboBox_1.addItem(TipoEmpleado.TECNICO.toString());
		
		JLabel lblNewLabel_2_2 = new JLabel("Nombre");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(10, 185, 119, 25);
		panel_1.add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 189, 86, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Nivel");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(310, 124, 119, 25);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(428, 127, 85, 22);
		panel_1.add(comboBox_2);
		
		comboBox_2.addItem(NivelTecnico.JUNIOR);
		comboBox_2.addItem(NivelTecnico.SEMISENIOR);
		comboBox_2.addItem(NivelTecnico.SENIOR);
		comboBox_2.setEnabled(false);
		
		JButton btnNewButton = new JButton("Ejecutar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("CREAR")) {
					if (textField_1.getText().equals("") || textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(panel, "Ingrese todos los campos");
					} else {
						Controlador.crearPersona(textField_1.getText(), textField_2.getText(), comboBox_1.getSelectedItem().toString(), comboBox_2.getSelectedItem().toString());
						Controlador.cargaTablaU(tableu);
					}
				} else if(comboBox.getSelectedItem().equals("MODIFICAR")) {
					if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(panel, "Ingrese todos los campos");
					} else {
						if (Controlador.isNumeric(textField.getText())) {
							Controlador.modificarPersona(Integer.parseInt(textField.getText()), textField_1.getText(), textField_2.getText());
							Controlador.cargaTablaU(tableu);
						} else {
							JOptionPane.showMessageDialog(panel, "Datos incorrectos");
						}
					}
				} else {
					if (textField.getText().equals("")) {
						JOptionPane.showMessageDialog(panel, "Ingrese todos los campos");
					} else {
						if (Controlador.isNumeric(textField.getText())) {
							Controlador.bajaPersona(Integer.parseInt(textField.getText()));
							Controlador.cargaTablaU(tableu);
						} else {
							JOptionPane.showMessageDialog(panel, "Datos incorrectos");
						}
						
					}
				}
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("CREAR")) {
					textField.setEnabled(false);
					textField_1.setEnabled(true);
					textField_2.setEnabled(true);
					comboBox_1.setEnabled(true);
					comboBox_2.setEnabled(false);
				} else if(comboBox.getSelectedItem().equals("MODIFICAR")) {
					textField.setEnabled(true);
					textField_1.setEnabled(true);
					textField_2.setEnabled(true);
					comboBox_1.setEnabled(false);
					comboBox_2.setEnabled(false);
				} else {
					textField.setEnabled(true);
					textField_1.setEnabled(false);
					textField_2.setEnabled(false);
					comboBox_1.setEnabled(false);
					comboBox_2.setEnabled(false);
				}
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1.getSelectedItem().equals("TECNICO")) {
					comboBox_2.setEnabled(true);
				} else {
					comboBox_2.setEnabled(false);
				}
			}
		});
		
		btnNewButton.setBounds(124, 255, 89, 23);
		panel_1.add(btnNewButton);
		
		// Pestaña Costos
		
		JPanel panel2 = new JPanel();
		tabbed.addTab("Configurar costos", panel2);
		
		String[] columnasct = {"Nivel de Tecnico",
				"Costo",
		};
		
		String[][] datact = {};
		
		modelct = new DefaultTableModel(datact,columnasct) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		panel2.setLayout(null);
		
		JTable tablect = new JTable(modelct);
		
		JScrollPane scrollPane = new JScrollPane(tablect);
		scrollPane.setBounds(0, 0, 489, 336);
		panel2.add(scrollPane);
		
		Controlador.cargaTablaCT(tablect);
		
		String[] columnasce = {"Equipamiento",
				"Costo",
		};
		
		String[][] datace = {};
		
		modelce = new DefaultTableModel(datace,columnasce) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable tablece = new JTable(modelce);
		
		JScrollPane scrollPane_1 = new JScrollPane(tablece);
		scrollPane_1.setBounds(497, 0, 488, 336);
		panel2.add(scrollPane_1);
		
		Controlador.cargaTablaCE(tablece);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 335, 995, 311);
		panel2.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Configurar Costos");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 11, 198, 30);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 76, 59, 19);
		panel_2.add(lblNewLabel_4);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(112, 76, 86, 22);
		panel_2.add(comboBox_3);
		
		comboBox_3.addItem(NivelTecnico.JUNIOR.toString());
		comboBox_3.addItem(NivelTecnico.SEMISENIOR.toString());
		comboBox_3.addItem(NivelTecnico.SENIOR.toString());
		comboBox_3.addItem("Evaporador");
		comboBox_3.addItem("Condensador");
		comboBox_3.addItem("KitInstalacion");
		
		JLabel lblNewLabel_4_1 = new JLabel("Costo");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(10, 130, 59, 19);
		panel_2.add(lblNewLabel_4_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(112, 131, 86, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Configurar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_3.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Ingrese todos los campos");
				} else {
					if (Controlador.isNumeric(textField_3.getText())) {
						if (comboBox_3.getSelectedItem().equals("Evaporador") || comboBox_3.getSelectedItem().equals("Condensador") || comboBox_3.getSelectedItem().equals("KitInstalacion")) {
							Controlador.configurarCostoEquipamiento(comboBox_3.getSelectedItem().toString(), Integer.parseInt(textField_3.getText()));
							Controlador.cargaTablaCE(tablece);
						} else {
							Controlador.configurarCostoHora(comboBox_3.getSelectedItem().toString(), Integer.parseInt(textField_3.getText()));
							Controlador.cargaTablaCT(tablect);
						}
					} else {
						JOptionPane.showMessageDialog(panel, "Datos incorrectos");
					}
				}
			}
		});
		
		btnNewButton_1.setBounds(109, 227, 89, 23);
		panel_2.add(btnNewButton_1);
		
		// Pestaña Stock
		
		JPanel panel3 = new JPanel();
		tabbed.addTab("Ajustar Stock", panel3);
		panel3.setLayout(new GridLayout(0,1,0,0));
		
		String[] columnass = {"Equipamiento",
				"Cantidad",
				"Costo"
		};
		
		String[][] datas = {};
		
		models = new DefaultTableModel(datas,columnass) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable tables = new JTable(models);
		
		JScrollPane scrollPane2 = new JScrollPane(tables);
		panel3.add(scrollPane2);
		
		Controlador.cargaTableE(tables);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel3.add(panel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Ajustar Stock");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 11, 150, 25);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Equipamiento");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 101, 102, 25);
		panel_3.add(lblNewLabel_6);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(122, 104, 89, 22);
		panel_3.add(comboBox_4);
		
		comboBox_4.addItem("Evaporador");
		comboBox_4.addItem("Condensador");
		comboBox_4.addItem("KitInstalacion");
		
		
		JLabel lblNewLabel_6_1 = new JLabel("Cantidad");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1.setBounds(10, 157, 102, 25);
		panel_3.add(lblNewLabel_6_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(125, 161, 86, 20);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Ajustar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(panel, "Ingrese todos los campos");
				} else {
					if (Controlador.isNumeric(textField_4.getText())) {
						Controlador.ajustarStock(comboBox_4.getSelectedItem().toString(), Integer.parseInt(textField_4.getText()));
						Controlador.cargaTableE(tables);
						textField_4.setText("");
					} else {
						JOptionPane.showMessageDialog(panel, "Datos incorrectos");
					}
				}
			}
		});
		
		btnNewButton_2.setBounds(122, 227, 89, 23);
		panel_3.add(btnNewButton_2);
		
	}
}
