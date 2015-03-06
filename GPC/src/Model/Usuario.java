package Model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Usuario {
	
	/*** 
	 * @throws SQLException Parametro incorrecto
	 ***/
	// Metodo para comparar la contraseña del usuario
	public ResultSet getPass(Conexion con, String usu) throws SQLException, NumberFormatException{
		String query = "select pass_usu, acceso from usuario where nombre_usu = ?";
		String[][] param = {{"String",usu}};
		return con.getData(query, param);
	}
	
	/*** 
	 * @throws SQLException Parametro incorrecto
	 ***/
	// Metodo para comprobar los intentos que tiene el usuario
	public ResultSet checkIntentos(Conexion con, String nombre_usu) throws SQLException, NumberFormatException{
		String query = "select intento from usuario where nombre_usu = ?";
		String[][] param = {{"String",nombre_usu+""}};
		return con.getData(query, param);
	}
	
	/***
	 * @throws SQLException Parametros incorrectos
	 */
	// Metodo para actualizar el numero de intentos de logeo
	public int updateIntento(Conexion con, String nombre_usu) throws SQLException, NumberFormatException{
		String query = "update usuario set intento = 0 where nombre_usu = ?";
		String[][] param = {{"String",nombre_usu+""}};
		return con.manipulatedReg(query, param);
	}
	
	/***
	 * @throws SQLException parametros incorrectos
	 ***/
	// Metodo para actualizar los registros del usuario 
	public int updateReg_Usu(Conexion con, String[][] param) throws SQLException, NumberFormatException{
		String query = "update usuario set nombre_usu = ?, pass_usu = ?, acceso = ?, intento=? where nombre_usu = ?";
		return con.manipulatedReg(query, param);
	}
	
	/***
	 * @throws SQLException error en el objeto Conexion
	 * @throws SQLException La consulta devuelve 0 por que no tiene ningun valor la base de datos
	 ***/
	// Metodo para obtener los usuarios 
	public ResultSet getUser(Conexion con) throws SQLException, NumberFormatException{
		String query = "select nombre_usu, pass_usu, acceso, intento from usuario";
		return con.getData(query);
	}
	
	/***
	 * @throws SQLException parametros incorrectos
	 ***/
	// Metodo para añadir un usuario
	public int addUser(Conexion con, String[][] param) throws SQLException, NumberFormatException{
		String query = "insert into usuario (nombre_usu, pass_usu, acceso) values (?,?,?)";
		return con.manipulatedReg(query, param);
	}
	
	/***
	 * @throws SQLException parametros incorrectos
	 ***/
	 // Metodo para borrar usuarios 
	public int dropUser(Conexion con, String[][] param) throws SQLException, NumberFormatException{
		String query = "delete from usuario where id_usuario = ?";
		return con.manipulatedReg(query, param);
	}
}
