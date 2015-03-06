package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	// Elements for connections to the database
	// Elementos para conexiones a la base de datos
	private Connection con;
	private PreparedStatement sta;
	private ResultSet res;
	
	// Elements for configuration the connection to the database
	// Elementos para configurar la conexion a la base de datos
	private String host="localhost";
	private int port=3306;
	private String dbNm="gpc";
	private String user="root";
	private String pass="";
	
	/**
	 * @throws ClassNotFoundException If not exist driver of connection or not is charge *
	 * @throws ClassNotFoundException Si no existe driver de conexion o no está cargado  *  
	 ***/
	// Set the type of connection to the database
	// Establece el tipo de conexion a la base de datos
	public Conexion() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	/**
	 * @throws SQLException If cannot establish connection to database *  
	 * @throws SQLException Si no se puede establecer conexion a la base de datos *
	 ***/
	// Set the connection to a local server
	// Establece la conexion a un servidor local
	public void conLoc() throws SQLException{
		if(sta!=null){
			sta = null;
			con = null;
		}
		con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbNm,user,pass);
	}
	
	//
	//
	public void conRem(){ //TODO 
	}
	
	/***
	 * @throws SQLException If the instruction is not correct or @param query do not have a correct value *
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 ***/
	// Throw a prepared statement, by default (Selects)
	// Lanza una sentencia preparada, por defecto (Selects)
	public ResultSet getData(String query) throws SQLException{
		sta=con.prepareStatement(query);
		res=sta.executeQuery();
		return res;
	}
	/***
	 * @throws SQLException if the instrucction is not correct or @param query do not have a correct value *
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 * @throws NumberFormatException If exist a param like a number and his value not is a number *
	 * @throws NumberFormatException Si hay un parametro que se haya tratar como numero y su valor no es un numero *
	 ***/
	// Throw a prepared statement based parameters, by default (Selects)
	// Lanza una sentencia preparada a base de unos parametros, por defecto (Selects)
	public ResultSet getData(String query,String[][] param) throws SQLException, NumberFormatException{
		sta=con.prepareStatement(query);
		// Depends of value [x][0] that set the type that use el setParam for the value of [x][1]
		// Dependiendo del valor [x][0] que indica el tipo se utiliza el setParam correspondiente al valor de [x][1]
		for(int i=0;i<param.length;i++){
			if(param[i][0].equals("int")){
				try{
					int tmp = Integer.valueOf(param[i][1]) ;
					sta.setInt(i+1, tmp);
				}catch(NumberFormatException e){
					throw new NumberFormatException("Parametro no es número");
				}
			}else if(param[i][0].equals("String")){
				sta.setString(i+1, param[i][1]);
			}
		}
		res=sta.executeQuery();
		return res;
	}
	
	/***
	 * @throws SQLException If the instruction is not correct or @param query do not have a correct value *
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 ***/
	// Throw a prepared statement, by default (Inserts,delete and update)
	// Lanza una sentencia preparada, por defecto (Insertar,borrar y actualizar)
	public int manipulatedReg(String query) throws SQLException{
		sta=con.prepareStatement(query);
		return sta.executeUpdate();
	}
	
	/***
	 * @throws SQLException If the instrucction is not correct or @param query do not have a correct value *
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 * @throws NumberFormatException If exist a param like a number and his value not is a number *
	 * @throws NumberFormatException Si hay un parametro que se haya tratar como numero y su valor no es un numero *
	 ***/
	// Throw a prepared statement based parameters, by default (Inserts,delete and update)
	// Lanza una sentencia preparada a base de unos parametros, por defecto (Insertar,borrar y actualizar)
	public int manipulatedReg(String query,String[][] param) throws SQLException, NumberFormatException{
		sta=con.prepareStatement(query);
		// Depends of value [x][0] that set the type that use el setParam for the value of [x][1]
		// Dependiendo del valor [x][0] que indica el tipo se utiliza el setParam correspondiente al valor de [x][1]
		for(int i=0;i<param.length;i++){
			if(param[i][0].equals("int")){
				try{
					int tmp = Integer.valueOf(param[i][1]) ;
					sta.setInt(i+1, tmp);
				}catch(NumberFormatException e){
					throw new NumberFormatException("Parametro no es número");
				}
			}else if(param[i][0].equals("String")){
				if(param[i][1].equals("null"))
					sta.setString(i+1, "");
				else
					sta.setString(i+1, param[i][1]);
			}
		}
		return sta.executeUpdate();
	}
	
	/***
	 * @throws SQLException If the vars res or sta cannot close or not exist *
	 * @throws SQLException Si las variables res o sta no se pueden cerrar o no existen*
	 ***/
	// Methods for close the vars res and sta
	// Métodos para cerra las variables res y sta
	public void closeRes() throws SQLException{res.close();sta.close();}
	public void closeSta() throws SQLException{sta.close();}
	public void closeCon() throws SQLException{res.close();sta.close();con.close();}
}
