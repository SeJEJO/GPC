package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;



public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2242634543303193651L;
		
	private JPanel contentPane;
	
	/**
	 * Object of controller depends on the view
	 * Objeto del controlador pertinente a la vista
	 */
	public static Controller.CPrincipal cPrin = new Controller.CPrincipal();

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
	@SuppressWarnings("static-access")
	public Principal() {
		/**
		 * Conexion call the method while there is no user logged
		 * Llamamos al método de conexion mientras no haya un usuario logueado
		 */
		do
			cPrin.conectar();
		while(cPrin.nombre_usu == null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		
		JMenuBar mB_menu = new JMenuBar();
		setJMenuBar(mB_menu);
		
		JMenu mn_admin = new JMenu("Administracion");
		mB_menu.add(mn_admin);
		
		JMenuItem mntm_anadirAdm = new JMenuItem("A\u00F1adir");
		mntm_anadirAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cPrin.cargarViewAnAdmin();
			}
		});
		mn_admin.add(mntm_anadirAdm);
		
		JMenuItem mntm_borrarAdm = new JMenuItem("Borrar");
		mn_admin.add(mntm_borrarAdm);
		
		JMenuItem mntm_consultarAdm = new JMenuItem("Consultar");
		mntm_consultarAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cPrin.cargarViewConAdmin();
			}
		});
		mn_admin.add(mntm_consultarAdm);
		
		JMenuItem mntm_logout = new JMenuItem("Logout");
		mntm_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cPrin.vaciarVariables();
				do
					cPrin.conectar();
				while(cPrin.nombre_usu == null);
			}
		});
		mB_menu.add(mntm_logout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cPrin.cargarViewAnUsu();
			}
		});
		btnNewButton.setBounds(26, 24, 99, 45);
		contentPane.add(btnNewButton);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setBounds(26, 102, 99, 45);
		contentPane.add(btnConsultar);
	}
}
