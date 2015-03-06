package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Conexion;

public class CPrincipal {
	/**
	 * Set the Model objects
	 * Inicialización de los objetos Modelos
	 */
	public static Conexion con;
	public static Model.Gpc gpc = new Model.Gpc();
	public static Model.Usuario usu = new Model.Usuario();
	
	/**
	 * Set the objects of the Views
	 * Inicialización de los objetos de las Vistas
	 */
	public static View.DAna_adm dAn_Adm;
	public static View.DAna_usu dAn_Usu;
	public static View.DBor_adm dBo_Adm;
	public static View.DBor_usu dBo_Usu;
	public static View.DCon_adm dCon_Adm;
	public static View.DCon_usu dCon_Usu;
	public static View.DLogin dLog = new View.DLogin();
	public static View.DConfirmacion dConf;
	public static View.DError dError;
	
	/**
	 * Var of program
	 * Variables del programa
	 */
	public static String acceso;
	public static String nombre_usu;
	public static ResultSet result;
	
	/**
	 * Elements of DConfirmacion
	 */
	public static String confirmar;

	/**
	 * Elements of DErrors
	 * Elementos de DErrors
	 */
	public static String title;
	public static String message;
	public static String type;
	
	// 
	// Establece la llamada de conexión a la base de datos
	public void conectar(){
		try {
			if(con == null){
				// Se crea un objeto del Modelo Conexion
				con=new Conexion();
				// Y se llama a una función del Modelo
				con.conLoc();
			}
			if(!dLog.isVisible())
				dLog.setVisible(true);
		} catch (ClassNotFoundException e) {
			title = "Error conexion";
			message = "No detecta el Driver";
			cargarErrorExit();
		} catch (SQLException e) {
			title = "Error conexion";
			message = "La base de datos no esta conectada";
			cargarErrorExit();
		}
	}
	/**
	 * View for add registers in GPC/Users
	 * Vista para añadir Registros en GPC/Usuarios
	 */
	// View for add registers to the users
	// Vista para añadir registros de los usuarios
	public void cargarViewAnUsu(){
		dAn_Usu =  new View.DAna_usu();
		dAn_Usu.setVisible(true);
	}
	// View for add users (Only visible to Administrators)
	// Vista para añadir usuarios (Solo visible a los Administradores)
	public void cargarViewAnAdmin(){
		dAn_Adm =  new View.DAna_adm();
		dAn_Adm.setVisible(true);
	}
	/**
	 * 
	 */
	// TODO
	//
	public void cargarViewConUsu(){
		// TODO
		dCon_Usu =  new View.DCon_usu();
		dCon_Usu.setVisible(true);
	}
	// TODO
	//
	public void cargarViewConAdmin(){
		dCon_Adm =  new View.DCon_adm();
		dCon_Adm.setVisible(true);
	}
	//
	// Este método se encarga de vaciar las variables de una sesión
	public void vaciarVariables(){
		nombre_usu=((String) null);
		acceso=null;
	}
	//
	// Este método vacía las variables de los mensajes de error
	private static void vaciarMsgError(){
		title=null;
		message=null;
		type=null;
	}
	// TODO
	// 
	public void cargarConfirmacion(){
		dConf = new View.DConfirmacion();
		dConf.setVisible(true);
		dConf=null;
	}
	// 
	// Este método carga la ventana de error sin que al dar en "Aceptar" se salga del programa  
	public static void cargarError(){
		dError = new View.DError();
		dError.setVisible(true);
		vaciarMsgError();
		dError=null;
	}
	//
	// Este método carga la ventana de error sin que al dar en "Aceptar" se salga del programa
	public static void cargarError(String title,String message){
		CPrincipal.title = title;
		CPrincipal.message = message;
		dError = new View.DError();
		dError.setVisible(true);
		vaciarMsgError();
		dError=null;
	}
	//
	// Este método carga la ventana de error al dar en "Aceptar" se salga del programa
	public static void cargarErrorExit(){
		dError = new View.DError();
		dError.setVisible(true);
		dError=null;
		vaciarMsgError();
		System.exit(0);
	}
}
