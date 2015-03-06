package View;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DCon_usu extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8738871563788835495L;
	private Controller.CCon_usu cCon = new Controller.CCon_usu();
	private JTextField tF_sitio;
	private JTextField tF_email;
	private JTextField tF_usuario;
	private JTextField tF_pass;
	private JTextField tF_tipo;
	@SuppressWarnings("rawtypes")
	private JComboBox cB_Tipo;
	
	// 
	// Elementos para la tabla
	public static DefaultTableModel dtm;
	public JTable table;

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DCon_usu() {
		setTitle("Registros");
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 559, 300);
		getContentPane().setLayout(null);
		
		JLabel lb_tipo = new JLabel("Tipo");
		lb_tipo.setBounds(23, 22, 33, 14);
		getContentPane().add(lb_tipo);
		
		JLabel lb_tipo2 = new JLabel("Tipo");
		lb_tipo2.setBounds(337, 178, 33, 21);
		getContentPane().add(lb_tipo2);
		
		JLabel lb_sitio = new JLabel("Sitio");
		lb_sitio.setBounds(198, 22, 33, 14);
		getContentPane().add(lb_sitio);
		JLabel lb_email = new JLabel("Email");
		lb_email.setBounds(23, 181, 42, 14);
		getContentPane().add(lb_email);
		
		JLabel lb_usuario = new JLabel("Usuario");
		lb_usuario.setBounds(185, 181, 46, 14);
		getContentPane().add(lb_usuario);
		
		JLabel lb_pass = new JLabel("Contrase\u00F1a");
		lb_pass.setBounds(10, 221, 68, 14);
		getContentPane().add(lb_pass);
		
		JLabel lb_notas = new JLabel("Notas");
		lb_notas.setBounds(185, 218, 46, 20);
		getContentPane().add(lb_notas);
		
		tF_sitio = new JTextField();
		tF_sitio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cCon.consulta(tF_sitio);
			}
		});
		tF_sitio.setBounds(241, 19, 86, 20);
		getContentPane().add(tF_sitio);
		tF_sitio.setColumns(10);
		
		tF_email = new JTextField();
		tF_email.setBounds(89, 178, 86, 20);
		getContentPane().add(tF_email);
		tF_email.setColumns(10);
		
		tF_usuario = new JTextField();
		tF_usuario.setBounds(241, 178, 86, 20);
		getContentPane().add(tF_usuario);
		tF_usuario.setColumns(10);
		
		tF_pass = new JTextField();
		tF_pass.setBounds(87, 218, 86, 20);
		getContentPane().add(tF_pass);
		tF_pass.setColumns(10);
		
		tF_tipo = new JTextField();
		tF_tipo.setBounds(380, 178, 86, 20);
		getContentPane().add(tF_tipo);
		tF_tipo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(241, 218, 86, 20);
		getContentPane().add(scrollPane);
		
		JTextArea tA_notas = new JTextArea();
		scrollPane.setViewportView(tA_notas);
		
		cB_Tipo = new JComboBox();
		cB_Tipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cCon.consulta(cB_Tipo);
			}
		});
		cB_Tipo.setModel(new DefaultComboBoxModel(new String[] {"------"}));
		cB_Tipo.setBounds(66, 19, 111, 20);
		getContentPane().add(cB_Tipo);
		
		/*t_usuarios = new JTable();
		t_usuarios.setBounds(10, 54, 414, 0);
		getContentPane().add(t_usuarios);
		
		ScrollPane sP_usuarios = new ScrollPane();
		sP_usuarios.setBounds(10, 54, 414, 100);
		getContentPane().add(sP_usuarios);
		*/
		dtm = new DefaultTableModel();
		
		table= new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*if(table.getRowCount()>0){
					int table_row_selected = table.getSelectedRow();
					tF_User.setText((String)table.getValueAt(table_row_selected,0));
					tF_Pass.setText((String)table.getValueAt(table_row_selected,1));
					tF_Acces.setText((String)table.getValueAt(table_row_selected,2));
				}*/
			}
		});
		
		table.setBounds(20, 372, 519, -151);
		getContentPane().add(table);
		
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(21, 48, 477, 122);
		getContentPane().add(scrollPane1, BorderLayout.CENTER);
		
		JButton btn_ok = new JButton("Ok");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cCon.consulta(tF_sitio);
			}
		});
		btn_ok.setBounds(349, 19, 53, 20);
		getContentPane().add(btn_ok);
	}
}
