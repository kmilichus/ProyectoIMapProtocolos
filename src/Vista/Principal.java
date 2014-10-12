package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class Principal extends JFrame implements ActionListener{

	private JPanel panel;
	private JButton btnCerrarSesin;
	private JMenuBar menuBar;
	private JMenuItem mntmNuevoCorreo;
	
	public final static String CERRAR = "cerrar";
	public final static String NUEVO="nuevo";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Bandeja de Entrada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 313);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntmNuevoCorreo = new JMenuItem("Nuevo Correo");
		mntmNuevoCorreo.setActionCommand(NUEVO);
		mntmNuevoCorreo.addActionListener(this);
		menuBar.add(mntmNuevoCorreo);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		btnCerrarSesin = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesin.setBounds(137, 223, 164, 23);
		btnCerrarSesin.setActionCommand(CERRAR);
		btnCerrarSesin.addActionListener(this);
		panel.add(btnCerrarSesin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 430, 200);
		panel.add(scrollPane);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if ( comando.equals(CERRAR)){
			JOptionPane.showMessageDialog(this,"Cerrar Sesión por desarrollar");
		}else if(comando.equals(NUEVO)){
			
			JOptionPane.showMessageDialog(this,"Nuevo Correo por desarrollar");
		}
		}
		
		
	}

