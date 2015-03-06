package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.CLogin;

import java.awt.Font;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

public class DLogin extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3250581390190812788L;
	private JTextField tF_usuario;
	private JTextField tF_pass;
	private CLogin cLog = new CLogin();
	public static int intentos = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DLogin dialog = new DLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public DLogin() {
		if (intentos >= 1){
		setUndecorated(true);
		setResizable(false);
		setLocale(new Locale("es"));
		setModal(true);
		setAlwaysOnTop(true);
		setSize(429, 237);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lb_bienvenido = new JLabel("Bienvenido");
		lb_bienvenido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb_bienvenido.setBounds(155, 26, 108, 29);
		getContentPane().add(lb_bienvenido);
		
		JLabel lb_usuario = new JLabel("Usuario");
		lb_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_usuario.setBounds(134, 72, 46, 14);
		getContentPane().add(lb_usuario);
		
		JLabel lb_pass = new JLabel("Contrase\u00F1a");
		lb_pass.setHorizontalAlignment(SwingConstants.RIGHT);
		lb_pass.setBounds(106, 106, 74, 14);
		getContentPane().add(lb_pass);
		
		tF_usuario = new JTextField();
		tF_usuario.setBounds(190, 69, 86, 20);
		getContentPane().add(tF_usuario);
		tF_usuario.setColumns(10);
		
		tF_pass = new JTextField();
		tF_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cLog.eventLogin(tF_usuario, tF_pass, intentos);
			}
		});
		tF_pass.setBounds(190, 100, 86, 20);
		getContentPane().add(tF_pass);
		tF_pass.setColumns(10);
		
		JButton btn_entrar = new JButton("Entrar");
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cLog.eventLogin(tF_usuario, tF_pass, intentos);
			}
		});
		
		JButton btn_salir = new JButton("Salir");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cLog.cerrar();
			}
		});
		btn_entrar.setBounds(222, 151, 89, 23);
		getContentPane().add(btn_entrar);
		btn_salir.setBounds(91, 151, 89, 23);
		getContentPane().add(btn_salir);
		}
	}
}
