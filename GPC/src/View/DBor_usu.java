package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.ScrollPane;

public class DBor_usu extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8321128100984861025L;
	private JTextField tF_sitio;
	private JTable t_usuarios;
	private JTextField tF_email;
	private JTextField tF_usuario;
	private JTextField tF_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DCon_usu dialog = new DCon_usu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBor_usu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		Choice c_tipo = new Choice();
		c_tipo.setBounds(55, 22, 79, 20);
		getContentPane().add(c_tipo);
		
		JLabel lb_tipo = new JLabel("Tipo");
		lb_tipo.setBounds(23, 22, 46, 14);
		getContentPane().add(lb_tipo);
				
		JLabel lb_sitio = new JLabel("Sitio");
		lb_sitio.setBounds(222, 22, 33, 14);
		getContentPane().add(lb_sitio);
				tF_sitio = new JTextField();
		tF_sitio.setBounds(253, 22, 86, 20);
		getContentPane().add(tF_sitio);
		tF_sitio.setColumns(10);
				
		JButton btn_ok = new JButton("Ok");
		btn_ok.setBounds(361, 22, 53, 20);
		getContentPane().add(btn_ok);
				t_usuarios = new JTable();
		t_usuarios.setBounds(10, 54, 414, 0);
		getContentPane().add(t_usuarios);
				
		ScrollPane sP_usuarios = new ScrollPane();
		sP_usuarios.setBounds(10, 54, 414, 100);
		getContentPane().add(sP_usuarios);
				
		JLabel lb_email = new JLabel("Email");
		lb_email.setBounds(32, 181, 46, 14);
		getContentPane().add(lb_email);
				
		tF_email = new JTextField();
		tF_email.setBounds(77, 178, 86, 20);
		getContentPane().add(tF_email);
		tF_email.setColumns(10);
				
		tF_usuario = new JTextField();
		tF_usuario.setBounds(310, 178, 86, 20);
		getContentPane().add(tF_usuario);
		tF_usuario.setColumns(10);
				
		JLabel lb_usuario = new JLabel("Usuario");
		lb_usuario.setBounds(264, 181, 46, 14);
		getContentPane().add(lb_usuario);
				
		tF_pass = new JTextField();
		tF_pass.setBounds(77, 218, 86, 20);
		getContentPane().add(tF_pass);
		tF_pass.setColumns(10);
				
		JLabel lb_pass = new JLabel("Contrase\u00F1a");
		lb_pass.setBounds(10, 221, 68, 14);
		getContentPane().add(lb_pass);
				
		JButton btn_notas = new JButton("Notas");
		btn_notas.setBounds(280, 221, 89, 23);
		getContentPane().add(btn_notas);
	}

}