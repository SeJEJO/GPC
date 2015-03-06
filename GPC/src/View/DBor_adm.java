package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import java.awt.ScrollPane;
import javax.swing.JLabel;

public class DBor_adm extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8569247846288729804L;
	private JTable t_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBor_adm dialog = new DBor_adm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBor_adm() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		t_usuario = new JTable();
		t_usuario.setBounds(10, 10, 414, 0);
		getContentPane().add(t_usuario);
		
		ScrollPane sP_usuario = new ScrollPane();
		sP_usuario.setBounds(10, 10, 414, 109);
		getContentPane().add(sP_usuario);
		
		JLabel lb_usuario = new JLabel("Usuario");
		lb_usuario.setBounds(31, 152, 46, 14);
		getContentPane().add(lb_usuario);
		
		JLabel lb_acceso = new JLabel("Acceso");
		lb_acceso.setBounds(267, 152, 46, 14);
		getContentPane().add(lb_acceso);
		
		JLabel lb_pass = new JLabel("Contrase\u00F1a");
		lb_pass.setBounds(31, 193, 62, 14);
		getContentPane().add(lb_pass);
		
		JButton btn_borrar = new JButton("Borrar");
		btn_borrar.setBounds(173, 228, 89, 23);
		getContentPane().add(btn_borrar);
	}
}
