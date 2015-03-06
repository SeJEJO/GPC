package Controller;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CAna_adm {
	private boolean existe = false;

	// TODO
	// 
	public boolean comparaUsu(String usuario, String result_base){
		if (result_base.equals(usuario)){
			existe = true;
		}
		return existe;
	}
	// TODO
	// 
	public boolean checkUsu(String usuario){
		boolean retorno = false;
		try {
			CPrincipal.result = CPrincipal.usu.getUser(CPrincipal.con);
			if (CPrincipal.result.first()){
				// 
				// Llamamos al metod para comparar el usuario con los de la base de datos
				comparaUsu(usuario, CPrincipal.result.getString(1));
				while (CPrincipal.result.next()){
					// 
					// Llamamos al metodo para comparar el usuario con los de la base de datos
					comparaUsu(usuario, CPrincipal.result.getString(1));
				}
				if (existe == true){
					retorno = true;
					existe = false;
					CPrincipal.title = "Error";
					CPrincipal.message = "El usuario "+ usuario +", ya existe en la base de datos";
					CPrincipal.cargarError();
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			CPrincipal.title = "Error";
			CPrincipal.message = "Ha habido un problema con la base de datos";
			CPrincipal.cargarError();
		} catch (SQLException e) {
			CPrincipal.title = "Error";
			CPrincipal.message = "Ha habido un problema con la base de datos";
			CPrincipal.cargarError();
		}
		return retorno;	
	}
	// TODO
	// 
	public void ana_usu(JTextField usuario, JTextField pass, JComboBox<?> acceso){
		String[][] param = {
				{"String",usuario.getText()},
				{"String",pass.getText()},
				{"int",acceso.getSelectedIndex()+""}
		};
		//
		// Comprobamos si el nombre de usuario existe
		if(!checkUsu(usuario.getText())){
			try {
				CPrincipal.usu.addUser(CPrincipal.con, param);
				CPrincipal.title = "Correcto";
				CPrincipal.message = "El usuario "+usuario.getText()+", se ha insertado correctamente";
			} catch (NumberFormatException e) {
				CPrincipal.title = "Error";
				CPrincipal.message = "Ha habido un problema con la base de datos";
			} catch (SQLException e) {
				CPrincipal.title = "Error";
				CPrincipal.message = "El usuario no se puede insertar correctamente";
			}
			CPrincipal.cargarError();
		}
	}
}
