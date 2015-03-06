package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	// Elementos para conexiones a la base de datos
	// Elements for connections to the database
	private Connection con;
	private PreparedStatement sta;
	private ResultSet res;
	
	// Elementos para configurar la conexion a la base de datos
	// Elements for config the connection to the database
	private String host="localhost";
	private int port=3306;
	private String dbNm="gpc";
	private String user="root";
	private String pass="";
	
	/**
	 * @throws ClassNotFoundException si no existe driver de conexion o no está cargado  *  
	 * @throws ClassNotFoundException if not exist driver of connection or not is charge *
	 ***/
	// Establece el tipo de conexion a la base de datos
	// Set the type of connection to the database
	public Conexion() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	/**
	 * @throws SQLException Si no se puede establecer conexion a la base de datos *
	 * @throws SQLException if cannot establish connection to database *  
	 ***/
	// Establece la conexion a un servidor local
	// Set the connection to a local server
	public void conLoc() throws SQLException{
		if(sta!=null){
			sta = null;
			con = null;
		}
		con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbNm,user,pass);
	}
	
	//
	public void conRem(){ //TODO 
	}
	
	/***
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 * @throws SQLException if the instrucction is not correct or @param query do not have a correct value *
	 ***/
	// Lanza una sentencia preparada, por defecto (Selects)
	// Throw a prepared statement, by default (Selects)
	public ResultSet getData(String query) throws SQLException{
		sta=con.prepareStatement(query);
		res=sta.executeQuery();
		return res;
	}
	/***
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 * @throws SQLException if the instrucction is not correct or @param query do not have a correct value *
	 * @throws NumberFormatException Si hay un parametro que se haya tratar como numero y su valor no es un numero *
	 * @throws NumberFormatException If exist a param like a number and his value not is a number *
	 ***/
	// Lanza una sentencia preparada a base de unos parametros, por defecto (Selects)
	// Throw a prepared statement based parameters, by default (Selects)
	public ResultSet getData(String query,String[][] param) throws SQLException, NumberFormatException{
		sta=con.prepareStatement(query);
		// Dependiendo del valor [x][0] que indica el tipo se utiliza el setParam correspondiente al valor de [x][1]
		// Depends of value [x][0] that set the type that use el setParam for the value of [x][1]
		for(int i=0;i<param.length;i++){
			if(param[i][0].equals("int")){
				try{
					int tmp = Integer.valueOf(param[i][1]) ;
					sta.setInt(i+1, tmp);
				}catch(NumberFormatException e){
					throw new NumberFormatException("Parametro no es número");
				}
			}else if(param[i][0].equals("String")){
				System.out.println(param[i][1]);
				sta.setString(i+1, param[i][1]);
			}
		}
		res=sta.executeQuery();
		return res;
	}
	
	/***
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 * @throws SQLException if the instrucction is not correct or @param query do not have a correct value *
	 ***/
	// Lanza una sentencia preparada, por defecto (Insertar,borrar y actualizar)
	// Throw a prepared statement, by default (Inserts,delete and update)
	public int manipulatedReg(String query) throws SQLException{
		sta=con.prepareStatement(query);
		return sta.executeUpdate();
	}
	
	/***
	 * @throws SQLException Si la instrucción no es correcto o @param query no tiene un valor correcto *
	 * @throws SQLException if the instrucction is not correct or @param query do not have a correct value *
	 * @throws NumberFormatException Si hay un parametro que se haya tratar como numero y su valor no es un numero *
	 * @throws NumberFormatException If exist a param like a number and his value not is a number *
	 ***/
	// Lanza una sentencia preparada a base de unos parametros, por defecto (Insertar,borrar y actualizar)
	// Throw a prepared statement based parameters, by default (Inserts,delete and update)
	public int manipulatedReg(String query,String[][] param) throws SQLException, NumberFormatException{
		sta=con.prepareStatement(query);
		// Dependiendo del valor [x][0] que indica el tipo se utiliza el setParam correspondiente al valor de [x][1]
		// Depends of value [x][0] that set the type that use el setParam for the value of [x][1]
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
		return sta.executeUpdate();
	}
	
	/***
	 * @throws SQLException si las variables res o sta no se pueden cerrar o no existen*
	 * @throws SQLException if the vars res or sta cannot close or not exist *
	 ***/
	// Métodos para cerra las variables res y sta
	// Methods for close the vars res and sta
	public void closeRes() throws SQLException{res.close();sta.close();}
	public void closeSta() throws SQLException{sta.close();}
	public void closeCon() throws SQLException{res.close();sta.close();con.close();}
}
