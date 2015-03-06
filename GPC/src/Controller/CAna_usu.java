package Controller;

import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CAna_usu {
	//
	//
	private int longitudMaxReq(String campo){
		int num=0;
		switch (campo) {
		case "sitio": case "correo": case "pass":
			num=50;
			break;
		case "tipo":
			num=25;
		case "usuario":
			num=30;
		case "notas":
			num=100;
		}
		return num;
	}
	//
	//
	@SuppressWarnings("deprecation")
	private boolean pasanRequisitos(JTextField sitio, JTextField tipo,
			JTextField usuario_sit, JPasswordField pass_sit, JTextField correo,JTextArea notas) 
	{
		if(sitio.getText().length() == 0 ){CPrincipal.cargarError("Error", "El sitio ha de contener un valor");return false;
		}else if(sitio.getText().length() > longitudMaxReq("sitio")){CPrincipal.cargarError("Error", "El sitio no ha de superar "+longitudMaxReq("sitio")+" caracteres");return false;
		}
		if(correo.getText().length() == 0){CPrincipal.cargarError("Error", "El email ha de contener un valor");return false;
		}else if(correo.getText().length() > longitudMaxReq("correo")){CPrincipal.cargarError("Error", "El email no ha de superar "+longitudMaxReq("correo")+" caracteres");return false;
		}
		if(tipo.getText().length() == 0){CPrincipal.cargarError("Error", "El tipo ha de contener un valor");return false;
		}else if(tipo.getText().length() > longitudMaxReq("tipo")){CPrincipal.cargarError("Error", "El tipo no ha de superar "+longitudMaxReq("tipo")+" caracteres");return false;
		}
		if(usuario_sit.getText().length() > longitudMaxReq("usuario")){CPrincipal.cargarError("Error", "El usuario no ha de superar "+longitudMaxReq("usuario")+" caracteres");return false;
		}
		if(pass_sit.getText().length() > longitudMaxReq("pass")){CPrincipal.cargarError("Error", "La contraseña no ha de superar "+longitudMaxReq("pass")+" caracteres");return false;
		}
		if(notas.getText().length() > longitudMaxReq("notas")){CPrincipal.cargarError("Error", "Notas no ha de superar "+longitudMaxReq("notas")+" caracteres");return false;
		}
		return true;
	}
	//
	// 
	private boolean noExistReg(String sitio, String correo){
		String query = "Select count(id_gpc) from gpc where usuario=? and sitio=? and correo=?";
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
			System.out.println(e.getMessage()+"-"+e.getCause()+"*"+e.getClass());
			CPrincipal.cargarError("Error", "La comprobación del registro está fallando");
		}
		return true;
	}
	//
	//
	@SuppressWarnings("deprecation")
	public void insertReg(JTextField sitio,JTextField tipo,
			JTextField usuario_sit,JPasswordField pass_sit,JTextField correo,JTextArea notas)
	{
		if(pasanRequisitos(sitio,tipo,usuario_sit,pass_sit,correo,notas)){
			if(noExistReg(sitio.getText(), correo.getText())){
				String contrasena="";
				if(!pass_sit.getText().equals(""))
					contrasena=Model.Crypto.desordenar(pass_sit.getText());
				String[][] param = 
					{
						{"String",sitio.getText()},
						{"String",tipo.getText()},
						{"String",usuario_sit.getText()},
						{"String",contrasena},
						{"String",correo.getText()},
						{"String",notas.getText()},
						{"String",CPrincipal.nombre_usu}
					};
				try {
					int ins = CPrincipal.gpc.addGpc(CPrincipal.con, param);
					if(ins==1)
						CPrincipal.cargarError("Correcto", "El registro se ha insertado correctamente");
				} catch (NumberFormatException | SQLException e) {
					CPrincipal.cargarError("Error Insertar", "El registro no se ha insertado correctamente");
				}
			}else
				CPrincipal.cargarError("Error Insertar", "El registro ya existe");
			limpiar(sitio,tipo,usuario_sit,pass_sit,correo,notas);
		}
	}
	//
	//
	private void limpiar(JTextField sitio,JTextField tipo,
			JTextField usuario_sit,JPasswordField pass_sit,JTextField correo,JTextArea notas)
	{
		sitio.setText(""); tipo.setText("");
		usuario_sit.setText(""); pass_sit.setText("");
		correo.setText("");notas.setText("");
	}
}
