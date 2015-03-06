package Controller;

import java.sql.SQLException;
import javax.swing.JTextField;

public class CLogin {
	//Method for check the user
	//Metodo para comprobar el usuario
	private boolean checkUser(String usuario,String pass){
		boolean muestra = false; // Variable para mostrar los errores
		try {
			CPrincipal.result = CPrincipal.usu.getPass(CPrincipal.con, usuario);
			//
			// Nos posicionamos en la primera fila que obtenemos
			if(CPrincipal.result.first()){
				// We compare the key that get of select with that user put
				// Comparamos la clave que nos devuelve con la que ha introducido el usuario
			
					if(CPrincipal.result.getString(1).equals(pass)){
						CPrincipal.nombre_usu = usuario;
						CPrincipal.acceso = CPrincipal.result.getString(2);
						return true;
					}
			}
			muestra = true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(muestra){
			CPrincipal.title = "Error logeo";
			CPrincipal.message = "Error Usuario y la contraseña no son correctos";
			CPrincipal.cargarError();
		}
		return false;
	}
	// Check that user and pass are corrects
	// Comprobamos el usuario y la contraseña que son correctos
	public boolean consultarPass(String usuario,String pass){
		boolean retorno = false;
		// Check if the field user and pass is not empty
		// Comprobamos si en los campos usuario y contraseña se ha introducido algo
		if(!usuario.equals("") && !pass.equals("")){
			// Check if the user exist in the database
			// Comprobamos si el usuario existe
			if(checkUser(usuario,pass)){
				try {
					CPrincipal.result = CPrincipal.usu.checkIntentos(CPrincipal.con, usuario);
					if (CPrincipal.result.first()){
						// Check if the tries are greater than 0
						// Comprobamos si lo intentos los tiene mayor que 0
						if (CPrincipal.result.getInt(1) > 0){
							retorno = true;
						}else {
							CPrincipal.title = "Error logeo";
							CPrincipal.message = "No tienes intentos para poder conectar, ponte en contacto con el administrador";
							CPrincipal.cargarErrorExit();
						}
					}
				} catch (NumberFormatException e) {
					CPrincipal.title = "Error logeo";
					CPrincipal.message = "Problemas con la base de datos";
					CPrincipal.cargarErrorExit();
				} catch (SQLException e) {
					CPrincipal.title = "Error logeo";
					CPrincipal.message = "Problemas con la base de datos";
					CPrincipal.cargarErrorExit();
				}
			}
		}else{
			CPrincipal.title = "Error logeo";
			CPrincipal.message = "Hay campos erroneos";
			CPrincipal.cargarError();
		}
		// Check the tries because if don't have tries exit of program
		// Comprobamos los intentos para que cuando no le queden se salga del programa
		if (View.DLogin.intentos == 1 && retorno == false){
			try {
				CPrincipal.usu.updateIntento(CPrincipal.con, usuario);
			} catch (NumberFormatException e) {
				CPrincipal.title = "Error logeo";
				CPrincipal.message = "Problemas con la base de datos";
				CPrincipal.cargarErrorExit();
			} catch (SQLException e) {
				CPrincipal.title = "Error logeo";
				CPrincipal.message = "Problemas con la base de datos";
				CPrincipal.cargarErrorExit();
			}
			// Show message of error and close the program
			// Mensaje de error y se cierra el programa
			CPrincipal.title = "Error logeo";
			CPrincipal.message = "No te quedan más intentos.\n Ponte en contacto con el Administrador para que te vuelva a activar tu cuenta";
			CPrincipal.cargarErrorExit();
		}
		return retorno;
	}
	// TODO
	//
	public void eventLogin(JTextField usuario, JTextField pass, int intentos){
		if(consultarPass(usuario.getText(), pass.getText())){
			CPrincipal.dLog.setVisible(false);
			cleanTF(usuario, pass);
		}else{
			View.DLogin.intentos--;
		}
	}
	// TODO
	//
	private void cleanTF(JTextField usuario, JTextField pass){
		usuario.setText("");
		pass.setText("");
	}
	// Action of close button
	// Accion del boton cerrar
	public void cerrar(){
		try {CPrincipal.con.closeCon(); System.exit(0);} 
		catch (Exception e1) {}
		System.exit(0);
	}
}
	
