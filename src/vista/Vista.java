package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.TipoEmpleado;

public class Vista extends JFrame{
	
	private JPanel panel;
	private JTextField textfield1;
	private JTextField textfield2;
	private JLabel label4;
	
	public static void GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	class ManejadorPanel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!textfield1.getText().equals("") && !textfield2.getText().equals("")) {
				if (Controlador.validarClave(Integer.parseInt(textfield1.getText()), textfield2.getText())) {
					TipoEmpleado tipo = Controlador.getTipoEmpleado(Integer.parseInt(textfield1.getText()));
					switch (tipo) {
					case ADMINISTRADOR:
						VistaAdministrador.GUI();
						break;
					case ADMINISTRATIVO:
						VistaAdministrativo.GUI();
						break;
					case OPERADOR:
						VistaOperador.GUI();
						break;
					case TECNICO:
						VistaTecnico.GUI();
						break;
					}
				} else {
					label4.setText("Usuario o contraseña invalidos");
				}
			}
		}
	}
	
	public Vista() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,500,350);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel label1 = new JLabel("Login - Empresa Aire");
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setBounds(115,39,235,30);
		panel.add(label1);
		
		JLabel label2 = new JLabel("Usuario: ");
		label2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label2.setBounds(100,120,75,15);
		panel.add(label2);
		
		JLabel label3 = new JLabel("Clave: ");
		label3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label3.setBounds(100,150,75,15);
		panel.add(label3);
		
		label4 = new JLabel("");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label4.setBounds(100,200,297,29);
		panel.add(label4);
		
		textfield1 = new JTextField();
		textfield1.setBounds(206,119,100,20);
		panel.add(textfield1);
		
		textfield2 = new JTextField();
		textfield2.setBounds(206,149,100,20);
		panel.add(textfield2);
		
		JButton button1 = new JButton("Ingresar");
		button1.setBounds(206,252,100,20);
		panel.add(button1);
		
		ManejadorPanel manejador = new ManejadorPanel();
		button1.addActionListener(manejador);
		
		

		
		
	}

}
