import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;

import Model.Conexion;
import Model.Gpc;


public class PruebaGpc {

	public static void main(String[] args) {
		try {
			
			Conexion con = new Conexion();
			Gpc gpc = new Gpc();
			con.conLoc();
			String pass;
			try {
				String desOrden= Model.Crypto.desordenar("5ErG|0.MoR@26|2E2");
				System.out.println(desOrden);
				String orden = Model.Crypto.ordenar(desOrden);
				System.out.println(orden);
				desOrden= Model.Crypto.desordenar("|N*OBd$Xg,ue_FW*");
				System.out.println(desOrden);
				orden = Model.Crypto.ordenar(desOrden);
				System.out.println(orden);
				desOrden= Model.Crypto.desordenar("A#|)z=H!}+Wj!@G*");
				System.out.println(desOrden);
				orden = Model.Crypto.ordenar(desOrden);
				System.out.println(orden);
				desOrden= Model.Crypto.desordenar("@g82WyYWLdg?{(fb7QpUx.XxVhouySW(]wHVS@KT");
				System.out.println(desOrden+" * "+desOrden.length());
				orden = Model.Crypto.ordenar(desOrden);
				System.out.println(orden);
				//query="insert into gpc (sitio,tipo_sitio,usuario_sitio,pass_sitio,correo,notas,usuario) values ('gmail','correo','','"+pass.getBytes()+"','sergiosjejo@gmail.com','','admin')";
				//re=gpc.addGpc(con, query);
				/*String query="insert into gpc (sitio,tipo_sitio,usuario_sitio,pass_sitio,correo,notas,usuario) values ('gmail','correo','','"+pass+"','sergiosjejo@gmail.com','','admin')";
				int re=gpc.addGpc(con, query);
				if(re==1){
					System.out.println("Insertado");
				}else{
					System.out.println("No insertado");
				}*/
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*int re=gpc.addGpc(con, query);
			if(re==1){
				System.out.println("Insertado");
			}else{
				System.out.println("No insertado");
			}
			String[][] param={
					{"String","Youtube"},//sitio,
					{"String","musica"},//tipo_sitio,
					{"String","sejejo"},//usuario_sitio,
					{"String","sergio"},//pass_sitio,
					{"String","sergiosjejo@gmail.com"},//correo,
					{"String",""},//notas,
					{"int","3"},//id_usuario
			};
			try{
				int re=gpc.addGpc(con, param);
				if(re==1){
					System.out.println("Insertado");
				}else{
					System.out.println("No insertado");
				}
			}catch(SQLException e){
				System.out.println(e.getCause()+"----"+e.getMessage()+"-----"+e.getErrorCode());
			}
			/*
			String[][] param={
					{"String","musica"},//tipo_sitio,
					{"String","sejejo"},//usuario_sitio,
					{"String","2"},//pass_sitio,
					{"String","sergiosjejo@gmail.com"},//correo,
					{"String",""},//notas,
					{"int","2"},//id_usuario
			};
			try{
				int re=gpc.updGpc(con, param);
				if(re==1){
					System.out.println("Update");
				}else{
					System.out.println("No update");
				}
			}catch(SQLException e){
				System.out.println(e.getCause()+"----"+e.getMessage()+"-----"+e.getErrorCode());
			}
			String[][] param={
					{"int","asda"}
			};
			try{
				int re=gpc.delGpc(con, param);
				if(re==1){
					System.out.println("Update");
				}else{
					System.out.println("No update");
				}
			}catch(SQLException e){
				System.out.println(e.getCause()+"----"+e.getMessage()+"-----"+e.getErrorCode());
			}catch(NumberFormatException e){
				System.out.println(e.getCause()+"----"+e.getMessage());
			}*/
			/*String query = "select * from gpc";
			try{
				ResultSet res = gpc.getData(con, query);
				ResultSetMetaData rsmd = (ResultSetMetaData) res.getMetaData();
				System.out.println(rsmd.getColumnCount());
				if(res.first()){
					//System.out.println(res.getRow()+" *** "+res.getString(2));
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						System.out.println(i+" *** "+res.getString(i)+"****"+res.getString(i).length());
					}
					System.out.println(Model.Crypto.descifra(res.getBytes(5)));
					while(res.next()){
						for (int i = 1; i <= rsmd.getColumnCount(); i++) {
							System.out.println(i+" *** "+res.getString(i));
						}
						System.out.println(Model.Crypto.descifra(res.getBytes(5)));
					}
				}else{
					System.out.println("Vacío");
				}
			}catch (Exception e) {
				System.out.println(e.getCause()+"----"+e.getMessage());
			}
			con.closeRes();*/
		} catch (ClassNotFoundException e) {
			System.out.println("No se detecta el driver");
		} catch (SQLException e) {
			System.out.println("No se puede conectar a la base de datos");
			System.out.println(e.getCause()+"----"+e.getMessage());
		}
	}

}
