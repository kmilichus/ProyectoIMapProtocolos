package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import Modelo.Cliente;

public class Inicio extends JFrame implements ActionListener {

	/**
	 * Atributos
	 */
	private JPanel panel;
	private JTextField textUser;
	private JPasswordField password;
	private JLabel lblCorreoElctronico;
	private JLabel lbluser;
	private JLabel lblContrasea;
	private JButton btnIniciarSesin;
	
	private Cliente cliente;

	/**
	 * Constantes
	 */
	public final static String INICIAR="iniciar";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setTitle("Correo El\u00E9ctronico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 185);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		lblCorreoElctronico = new JLabel("Correo El\u00E9ctronico");
		lblCorreoElctronico.setBounds(10, 11, 103, 14);
		panel.add(lblCorreoElctronico);
		
		lbluser = new JLabel("Usuario: ");
		lbluser.setBounds(10, 38, 53, 14);
		panel.add(lbluser);
		
		textUser = new JTextField();
		textUser.setBounds(105, 36, 109, 20);
		panel.add(textUser);
		textUser.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setBounds(10, 70, 68, 14);
		panel.add(lblContrasea);
		
		btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.setBounds(54, 106, 124, 23);
		btnIniciarSesin.setActionCommand(INICIAR);
		btnIniciarSesin.addActionListener(this);
		panel.add(btnIniciarSesin);
		
		password = new JPasswordField();
		password.setBounds(105, 67, 109, 20);
		panel.add(password);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String comando=event.getActionCommand();
		if (comando.equals(INICIAR)){
			
			String user = textUser.getText();
			String pass = password.getText();
			JOptionPane.showMessageDialog(this,user);
			JOptionPane.showMessageDialog(this,pass);
			cliente = new Cliente(user, pass);
			cliente.enviarCorreoPlano("Hola", "Correo Prueba", "juanfe.2793@gmail.com");
		}
		
	}
}
