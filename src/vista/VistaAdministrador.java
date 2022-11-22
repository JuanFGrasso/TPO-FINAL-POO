package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class VistaAdministrador extends JFrame{
	
	JPanel panel;
	
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
		
		JPanel panel1 = new JPanel();
		tabbed.addTab("ABM Personal", panel1);
		
		JPanel panel2 = new JPanel();
		tabbed.addTab("Configurar costos", panel2);
		
		JPanel panel3 = new JPanel();
		tabbed.addTab("Ajustar Stock", panel3);
		
		
	}

}
