package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class EnviarMensaje extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField txtSubject;
	private JTextField txtTo;
	private JLabel lblSujeto;
	private JLabel lblPara;
	private JTextArea textMensaje;
	private JButton btnEnviarMensaje;
	private JButton btnAdjuntarArchivo;
	
	public final static String ENVIAR="enviar";
	public final static String ADJUNTAR ="adjuntar";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarMensaje frame = new EnviarMensaje();
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
	public EnviarMensaje() {
		setTitle("Escribir Correo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 336);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		lblSujeto = new JLabel("Sujeto:");
		lblSujeto.setBounds(10, 11, 46, 14);
		panel.add(lblSujeto);
		
		txtSubject = new JTextField();
		txtSubject.setBounds(79, 8, 229, 20);
		panel.add(txtSubject);
		txtSubject.setColumns(10);
		
		lblPara = new JLabel("Para:");
		lblPara.setBounds(10, 36, 46, 14);
		panel.add(lblPara);
		
		txtTo = new JTextField();
		txtTo.setBounds(79, 39, 229, 20);
		panel.add(txtTo);
		txtTo.setColumns(10);
		
		textMensaje = new JTextArea();
		textMensaje.setBounds(10, 77, 329, 174);
		panel.add(textMensaje);
		
		btnEnviarMensaje = new JButton("Enviar Mensaje");
		btnEnviarMensaje.setBounds(20, 262, 133, 23);
		btnEnviarMensaje.setActionCommand(ENVIAR);
		btnEnviarMensaje.addActionListener(this);
		panel.add(btnEnviarMensaje);
		
		btnAdjuntarArchivo = new JButton("Adjuntar Archivo");
		btnAdjuntarArchivo.setBounds(163, 262, 133, 23);
		btnAdjuntarArchivo.setActionCommand(ADJUNTAR);
		btnAdjuntarArchivo.addActionListener(this);
		panel.add(btnAdjuntarArchivo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if (comando.equals(ENVIAR)){
			
			JOptionPane.showMessageDialog(this,"Enviar Mensaje por desarrollar");
		}else if(comando.equals(ADJUNTAR)){
			
			JFileChooser lala= new JFileChooser("");
		}
	}
}
