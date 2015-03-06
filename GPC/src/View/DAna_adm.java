package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controller.CAna_adm;

public class DAna_adm extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5661802505090071002L;
	private JTextField tF_usuario;
	private JTextField tF_pass;
	@SuppressWarnings("rawtypes")
	private JComboBox cB_acceso;
	
	private CAna_adm cAna_adm = new CAna_adm();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DAna_adm dialog = new DAna_adm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DAna_adm() {
		setTitle("A\u00F1adir Usuario");
		setBounds(100, 100, 450, 230);
		getContentPane().setLayout(null);
		{
			JLabel lb_usuario = new JLabel("Usuario");
			lb_usuario.setBounds(32, 45, 46, 14);
			getContentPane().add(lb_usuario);
		}
		{
			JLabel lb_pass = new JLabel("Contrase\u00F1a");
			lb_pass.setBounds(10, 94, 68, 14);
			getContentPane().add(lb_pass);
		}
		{
			JLabel lb_acceso = new JLabel("Acceso");
			lb_acceso.setBounds(210, 45, 46, 14);
			getContentPane().add(lb_acceso);
		}
		{
			tF_usuario = new JTextField();
			tF_usuario.setBounds(88, 42, 86, 20);
			getContentPane().add(tF_usuario);
			tF_usuario.setColumns(10);
		}
		{
			tF_pass = new JTextField();
			tF_pass.setBounds(88, 91, 86, 20);
			getContentPane().add(tF_pass);
			tF_pass.setColumns(10);
		}
		{
			JButton btn_anadir = new JButton("A\u00F1adir");
			btn_anadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cAna_adm.ana_usu(tF_usuario, tF_pass, cB_acceso);
				}
			});
			
			cB_acceso = new JComboBox();
			cB_acceso.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Administrador"}));
			cB_acceso.setBounds(266, 42, 118, 20);
			getContentPane().add(cB_acceso);
			btn_anadir.setBounds(173, 151, 89, 23);
			getContentPane().add(btn_anadir);
			
			//cB_acceso.setSelectedItem();
		}
	}
}
