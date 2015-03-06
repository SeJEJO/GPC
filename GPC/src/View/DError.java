package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DError extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5743179938505250438L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DError dialog = new DError();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DError() {
		setTitle(Controller.CPrincipal.title);
		setResizable(false);
		setModal(true);
		setAlwaysOnTop(true);
		setSize(594, 147);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		{
			JLabel lb_mensaje = new JLabel("<html>"+Controller.CPrincipal.message+"</html>");
			lb_mensaje.setBounds(10, 11, 559, 44);
			getContentPane().add(lb_mensaje);
		}
		{
			JButton btn_error = new JButton("Aceptar");
			btn_error.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btn_error.setBounds(225, 67, 89, 23);
			getContentPane().add(btn_error);
		}
	}

}
