package View;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class DMod_adm extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -493888800605671009L;

	Controller.CCon_usu cCon = new Controller.CCon_usu();
	
	public JTextField tF_usuario;
	public JTextField tF_acceso;
	public JTextField tF_pass;
	
	// Elemtos para la tabla
	private final JPanel contentPanel = new JPanel();
	public static DefaultTableModel dtm;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DMod_adm dialog = new DMod_adm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DMod_adm() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lb_usuario = new JLabel("Usuario");
			lb_usuario.setBounds(32, 159, 46, 14);
			getContentPane().add(lb_usuario);
			
		
		
			tF_usuario = new JTextField();
			tF_usuario.setBounds(104, 156, 86, 20);
			getContentPane().add(tF_usuario);
			tF_usuario.setColumns(10);
		
		
			JLabel lb_acceso = new JLabel("Acceso");
			lb_acceso.setBounds(252, 159, 46, 14);
			getContentPane().add(lb_acceso);
		
		
			tF_acceso = new JTextField();
			tF_acceso.setBounds(301, 156, 86, 20);
			getContentPane().add(tF_acceso);
			tF_acceso.setColumns(10);
		
		
			JLabel lb_pass = new JLabel("Contrase\u00F1a");
			lb_pass.setBounds(32, 197, 64, 14);
			getContentPane().add(lb_pass);
		
		
			tF_pass = new JTextField();
			tF_pass.setBounds(104, 194, 86, 20);
			getContentPane().add(tF_pass);
			tF_pass.setColumns(10);
		
		
			JButton btn_limpiar = new JButton("Limpiar");
			btn_limpiar.setBounds(175, 228, 89, 23);
			getContentPane().add(btn_limpiar);
		
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
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(21, 11, 401, 122);
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			
			cCon.tabla();
	}

}
