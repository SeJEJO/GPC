package Controller;

import java.sql.SQLException;
import javax.swing.JTextField;

public class CAna_usu {
	//
	// 
	private boolean noExistReg(String sitio, String correo){
		String query = "Select count(id) from gpc where usuario=? and sitio=? and correo=?";
		String[][] param = 
			{
				{"String",CPrincipal.nombre_usu},
				{"String",sitio},
				{"String",correo}
			};
		try {
			CPrincipal.result = CPrincipal.gpc.getData(CPrincipal.con, query, param);
			if(CPrincipal.result.first()){
				if(CPrincipal.result.getInt(1)>0)
					return false;
			}
		} catch (NumberFormatException | SQLException e) {
			CPrincipal.cargarError("Error", "La comprobación del registro está fallando");
		}
		return true;
	}
	//
	//
	public void insertReg(JTextField sitio,JTextField tipo,JTextField usuario_sit,JTextField pass_sit,JTextField correo,String notas){
		if(noExistReg(sitio.getText(), correo.getText())){
			String[][] param = 
				{
					{"String",sitio.getText()},
					{"String",tipo.getText()},
					{"String",usuario_sit.getText()},
					{"String",Model.Crypto.desordenar(pass_sit.getText())},
					{"String",correo.getText()},
					{"String",notas},
					{"String",CPrincipal.nombre_usu}
				};
			try {
				int ins = CPrincipal.gpc.addGpc(CPrincipal.con, param);
				if(ins==1)
					CPrincipal.cargarError("Correcto", "El registro se ha insertado correctamente");
			} catch (NumberFormatException | SQLException e) {
				CPrincipal.cargarError("Error Insertar", "El registro no se ha insertado correctamente");
			}
		}
		limpiar(sitio,tipo,usuario_sit,pass_sit,correo);
	}
	
	private void limpiar(JTextField sitio,JTextField tipo,JTextField usuario_sit,JTextField pass_sit,JTextField correo){
		sitio.setText(""); tipo.setText("");
		usuario_sit.setText(""); pass_sit.setText("");
		correo.setText("");
		View.DAna_usu.notas="";
	}
}
