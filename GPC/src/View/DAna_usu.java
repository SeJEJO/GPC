package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DAna_usu extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9009509229464633636L;
	private Controller.CAna_usu cAnUsu = new Controller.CAna_usu();
	private JTextField tF_sitio;
	private JTextField tF_mail;
	private JTextField tF_usuario;
	private JTextField tF_pass;
	private JTextField tF_tipo;
	public static String notas="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DAna_usu dialog = new DAna_usu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DAna_usu() {
		setModal(true);
		setTitle("A\u00F1adir registro");
		setAlwaysOnTop(true);
		setBounds(100, 100, 398, 251);
		getContentPane().setLayout(null);
		
			JLabel lb_sitio = new JLabel("Sitio");
			lb_sitio.setHorizontalAlignment(SwingConstants.RIGHT);
			lb_sitio.setBounds(21, 37, 46, 14);
			getContentPane().add(lb_sitio);
		
			JLabel lb_email = new JLabel("Email");
			lb_email.setHorizontalAlignment(SwingConstants.RIGHT);
			lb_email.setBounds(189, 37, 56, 14);
			getContentPane().add(lb_email);
		
			JLabel lb_usuario = new JLabel("Usuario");
			lb_usuario.setHorizontalAlignment(SwingConstants.RIGHT);
			lb_usuario.setBounds(21, 86, 46, 14);
			getContentPane().add(lb_usuario);
		
			JLabel lb_pass = new JLabel("Contrase\u00F1a");
			lb_pass.setHorizontalAlignment(SwingConstants.RIGHT);
			lb_pass.setBounds(167, 86, 78, 14);
			getContentPane().add(lb_pass);
		
			JLabel lb_tipo = new JLabel("Tipo");
			lb_tipo.setHorizontalAlignment(SwingConstants.RIGHT);
			lb_tipo.setBounds(21, 127, 46, 14);
			getContentPane().add(lb_tipo);
		
			tF_sitio = new JTextField();
			tF_sitio.setBounds(71, 34, 86, 20);
			getContentPane().add(tF_sitio);
			tF_sitio.setColumns(10);
		
			tF_tipo = new JTextField();
			tF_tipo.setBounds(71, 124, 86, 20);
			getContentPane().add(tF_tipo);
			tF_tipo.setColumns(10);
		
			tF_usuario = new JTextField();
			tF_usuario.setBounds(71, 83, 86, 20);
			getContentPane().add(tF_usuario);
			tF_usuario.setColumns(10);
		
			tF_pass = new JTextField();
			tF_pass.setBounds(255, 83, 86, 20);
			getContentPane().add(tF_pass);
			tF_pass.setColumns(10);
		
			tF_mail = new JTextField();
			tF_mail.setBounds(255, 34, 86, 20);
			getContentPane().add(tF_mail);
			tF_mail.setColumns(10);
		
			JButton btn_anadirNotas = new JButton("A\u00F1adir Notas");
			btn_anadirNotas.setBounds(232, 123, 109, 23);
			getContentPane().add(btn_anadirNotas);
		
			JButton btn_anadir = new JButton("A\u00F1adir");
			btn_anadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cAnUsu.insertReg(tF_sitio, tF_tipo, tF_usuario, tF_pass, tF_mail, notas);
				}
			});
			btn_anadir.setBounds(232, 168, 109, 23);
			getContentPane().add(btn_anadir);
	}
}
