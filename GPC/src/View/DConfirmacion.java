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
		{
			JButton btn_aceptar = new JButton("Aceptar");
			btn_aceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btn_aceptar.setBounds(236, 71, 89, 23);
			getContentPane().add(btn_aceptar);
		}
		{
			JLabel lb_mensaje = new JLabel("");
			lb_mensaje.setBounds(10, 11, 563, 52);
			getContentPane().add(lb_mensaje);
		}
	}

}
