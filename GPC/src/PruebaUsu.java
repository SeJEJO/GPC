import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import Model.Conexion;
import Model.Usuario;


public class PruebaUsu {
	
	/* Array
	String[][] param = new String[10][10];
	String[][] param2 = {
			{"int","1"},
			{"String","nombre"}
	};
	param[0][0] = "1";
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Conexion con = new Conexion();
			Usuario usu = new Usuario();
			
			con.conLoc();
			
			/* Comprobamos getUser (ver todos los registros de usuarios)
			ResultSet res = usu.getUser(con);
			while (res.next()){
				System.out.println(res.getString(2));
			}
			*/
			
			//Comprobamos el addUser (añadir usuarios)
			/*String passwd,user;
			user = Model.Crypto.cifra("Admin")+"";
			passwd = Model.Crypto.cifra("admin")+"";
			System.out.println(user+"/:"+user.length()+"****"+passwd+"/:"+passwd.length());
			String[][] param = {
				{"String",user},
				{"String",passwd},
				{"String","S"}
			};
			usu.addUser(con, param);*/
			
			/* Comprobamos el dropUser (borrar usuarios)
			String[][] param = {
					{"int","1"}
			};			
			usu.dropUser(con, param);
			*/
			
			/* Comprobamos el updateReg_Usu (actualizar los usuarios)
			String[][] param = {
					{"String","jesus"},
					{"String","stallman"},
					{"String","S"},
					{"int","1"}
			};
			usu.updateReg_Usu(con, param);
			*/
			
			/* Comprobamos el checkIntentos (Vemos los intentos del usuario)
			String[][] param = {
					{"int","3"}
			};
			ResultSet res = usu.checkIntentos(con, param);
			while (res.next()){
				System.out.println(res.getInt(1));
			}
			*/
			
			/* Comprobamos el updateIntentos (Para actualizar los intentos del usuario)
			String[][] param = {
					{"int","1"},
					{"String","nombre"}
			};
			usu.updateIntento(con, param);
			*/
			
			/* Comprobamos el getPass (para obtener el nombre de usuario y el acceso mediante la clave)
			*//*String[][] param = {
					{"String", "Juan"}
			};*/
			String passwd,user;
			user = Model.Crypto.cifra("Admin")+"";
			passwd = Model.Crypto.cifra("admin")+"";
			String[][] param = {
				{"String",user},
			};
			ResultSet res = usu.getPass(con, user);
			java.sql.ResultSetMetaData rsmd = res.getMetaData();
			/*for (int i = 1; i < rsmd.getColumnCount(); i++) {
				   System.out.println("columna=" + rsmd.getTableName(i) + "."
				      + rsmd.getColumnName(i) + " --> "
				      + rsmd.getColumnTypeName(i));
				}*/
			while (res.next()){
				System.out.println(res.getString(1));
			}		
		} catch (ClassNotFoundException | SQLException | NumberFormatException | InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage()+" "+e.getCause()+"/*"+e.getClass());
		}
	}

}
