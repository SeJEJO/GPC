import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Conexion;


public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Conexion con=new Conexion();
			con.conLoc();
			ResultSet res= con.getData("select * from usuario");
			while(res.next()){
				System.out.println(res.getRow()+" ---- "+res.getString(2));
			}
			con.closeRes();con.closeSta();
			String query="Select * from usuario where id_usuario = ? and nombre_usu = ?";
			String[][] param={
					{"int","1"},
					{"String","Admin"}
			};
			try{
				res = con.getData(query,param);
				if(res.first()){
					System.out.println(res.getRow()+" *** "+res.getString(2));
					while(res.next()){
						System.out.println(res.getRow()+" *** "+res.getString(2));
					}
				}else{
					System.out.println("Vacío");
				}
			}catch(NumberFormatException e){
				System.out.println(e.getMessage());
			}
			con.closeRes();con.closeSta();
			try{
				query="insert usuario (nombre_usu,pass_usu) values ('prueba2','pruebas')";
				System.out.println(con.manipulatedReg(query));
			}catch(Exception e){
				System.out.println(e.getMessage()+" --- "+e.getClass()+" --- "+e.getCause());
			}
			con.closeSta();
			
			query="insert usuario (nombre_usu,pass_usu) values (?,?)";
			String[][] param2={
					{"String","Juan"},
					{"String","Juan"}
			};
			System.out.println(query);
			if(con.manipulatedReg(query,param2)==1){
				System.out.println("Positivo");
			}else{
				System.out.println("negativo");
			}
			con.closeSta();
		} catch (ClassNotFoundException e) {
			System.out.println("No se detecta el driver");
		} catch (SQLException e) {
			System.out.println("No se puede conectar a la base de datos");
			System.out.println(e.getCause()+"----"+e.getMessage());
		}
	}

}
