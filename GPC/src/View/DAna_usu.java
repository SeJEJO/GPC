package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class DAna_usu extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9009509229464633636L;
	private Controller.CAna_usu cAnUsu = new Controller.CAna_usu();
	private JTextField tF_sitio;
	private JTextField tF_mail;
	private JTextField tF_usuario;
	private JPasswordField tF_pass;
	private JTextField tF_tipo;
	private JTextArea tA_notas;

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
		setBounds(100, 100, 424, 298);
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
			
		JLabel lbl_notas = new JLabel("Notas");
		lbl_notas.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_notas.setBounds(199, 127, 46, 14);
		getContentPane().add(lbl_notas);
		
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
		
		tF_pass = new JPasswordField();
		tF_pass.setBounds(255, 83, 86, 20);
		getContentPane().add(tF_pass);
		tF_pass.setColumns(10);
		
		tF_mail = new JTextField();
		tF_mail.setBounds(255, 34, 86, 20);
		getContentPane().add(tF_mail);
		tF_mail.setColumns(10);
		
		JButton btn_anadir = new JButton("A\u00F1adir");
		btn_anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cAnUsu.insertReg(tF_sitio, tF_tipo, tF_usuario, tF_pass, tF_mail, tA_notas);
			}
		});
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 122, 143, 96);
		getContentPane().add(scrollPane);
			
		tA_notas = new JTextArea();
		scrollPane.setViewportView(tA_notas);
		tA_notas.setWrapStyleWord(true);
		tA_notas.setLineWrap(true);
		tA_notas.setRows(2);
		btn_anadir.setBounds(48, 195, 109, 23);
		getContentPane().add(btn_anadir);
	}
}
