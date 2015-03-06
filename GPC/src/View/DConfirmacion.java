package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class DConfirmacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3666457384240724751L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DConfirmacion dialog = new DConfirmacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DConfirmacion() {
		setBounds(100, 100, 599, 143);
		getContentPane().setLayout(null);
		
		JButton btn_si = new JButton("Si");
		btn_si.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_si.setBounds(236, 71, 89, 23);
		getContentPane().add(btn_si);
		
		JButton btn_no = new JButton("No");
		btn_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btn_no.setBounds(281, 71, 89, 23);
		getContentPane().add(btn_no);

		JLabel lb_mensaje = new JLabel("");
		lb_mensaje.setBounds(10, 11, 563, 52);
		getContentPane().add(lb_mensaje);
	}

}
