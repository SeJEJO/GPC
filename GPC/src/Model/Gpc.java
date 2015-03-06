package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Gpc {

	/***
	 * @throws SQLException If the instruction is not correct or @param query do not have a correct value *
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 ***/
	// Throw a prepared statement, by default (Selects)
	// Lanza una sentencia preparada, por defecto (Selects)
	public ResultSet getData(Conexion con,String query) throws SQLException{
		return con.getData(query);
	}
	
	/***
	 * @throws SQLException If the instruction is not correct or @param query or @param param do not have a correct value *
	 * @throws SQLException Si la instrucción no es correcto o @param query o @param param no tiene un valor correcto *
	 ***/
	// Throw a prepared statement, by default (Selects)
	// Lanza una sentencia preparada, por defecto (Selects)
	public ResultSet getData(Conexion con,String query,String[][] param) throws SQLException, NumberFormatException{
		return con.getData(query,param);
	}
	// TODO
	// 
	public int addGpc(Conexion con,String query) throws SQLException{
		return con.manipulatedReg(query);
	}
	// TODO
	// 	
	public int addGpc(Conexion con,String[][] param) throws SQLException, NumberFormatException {
		String query="insert into gpc (sitio,tipo_sitio,usuario_sitio,pass_sitio,correo,notas,usuario) values (?,?,?,?,?,?,?)";
		return con.manipulatedReg(query,param);
	}
	// TODO
	// 	
	public int delGpc(Conexion con,String query) throws SQLException{
		return con.manipulatedReg(query);
	}
	// TODO
	// 	
	public int delGpc(Conexion con,String[][] param) throws SQLException, NumberFormatException{
		String query="delete from gpc where id_gpc=?";
		return con.manipulatedReg(query,param);
	}
	// TODO
	// 
	public int updGpc(Conexion con,String query) throws SQLException{
		return con.manipulatedReg(query);
	}
	// TODO
	// 	
	public int updGpc(Conexion con,String[][] param) throws SQLException, NumberFormatException{
		String query="update gpc set tipo_sitio = ?,usuario_sitio = ?,pass_sitio = ?,correo = ?, notas = ? where id_gpc=?";
		return con.manipulatedReg(query,param);
	}
}
