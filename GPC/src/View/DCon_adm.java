package View;


import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DCon_adm extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -493888800605671009L;

	Controller.CCon_adm cCon_Adm = new Controller.CCon_adm();
	
	public static JTextField tF_usuario;
	@SuppressWarnings("rawtypes")
	public static JComboBox cB_acceso;
	public static JPasswordField tF_pass;
	public static JTextField tF_intento;
	
	// Elemtos para la tabla
	private final JPanel contentPanel = new JPanel();
	public static DefaultTableModel dtm;
	public static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DCon_adm dialog = new DCon_adm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DCon_adm() {
		setTitle("Administraci\u00F3n");
		setSize(658, 358);
		setLocationRelativeTo(null);

		getContentPane().setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lb_usuario = new JLabel("Usuario");
		lb_usuario.setBounds(32, 197, 46, 14);
		getContentPane().add(lb_usuario);
			
		JLabel lb_acceso = new JLabel("Acceso");
		lb_acceso.setBounds(240, 197, 46, 14);
		getContentPane().add(lb_acceso);

		JLabel lb_pass = new JLabel("Contrase\u00F1a");
		lb_pass.setBounds(32, 232, 64, 14);
		getContentPane().add(lb_pass);

		JLabel lb_intento = new JLabel("Intentos");
		lb_intento.setBounds(240, 232, 46, 14);
		getContentPane().add(lb_intento);

		JLabel lb_titulo = new JLabel("Lista de Usuarios");
		lb_titulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb_titulo.setBounds(258, 11, 129, 14);
		getContentPane().add(lb_titulo);

		tF_usuario = new JTextField();
		tF_usuario.setBounds(104, 194, 86, 20);
		getContentPane().add(tF_usuario);
		
		tF_pass = new JPasswordField();
		tF_pass.setBounds(103, 228, 109, 20);
		getContentPane().add(tF_pass);
		
		tF_intento = new JTextField();
		tF_intento.setBounds(296, 229, 23, 20);
		getContentPane().add(tF_intento);

		cB_acceso = new JComboBox();
		cB_acceso.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Administrador"}));
		cB_acceso.setBounds(305, 194, 118, 20);
		getContentPane().add(cB_acceso);
		
		dtm = new DefaultTableModel();
			
		table= new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cCon_Adm.autoCompletar();
			}
		});
			
		table.setBounds(20, 372, 519, -151);
		getContentPane().add(table);
			
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(22, 32, 401, 122);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JButton btn_limpiar = new JButton("Limpiar");
		btn_limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_limpiar.setBounds(457, 228, 89, 23);
		getContentPane().add(btn_limpiar);

		JButton btn_modificar = new JButton("Modificar");
		btn_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cCon_Adm.modificarUsu();
			}
		});
		btn_modificar.setBounds(457, 29, 89, 23);
		getContentPane().add(btn_modificar);

		JButton btn_borrar = new JButton("Borrar");
		btn_borrar.setBounds(457, 76, 89, 23);
		getContentPane().add(btn_borrar);
		cCon_Adm.tabla();
	}

}
