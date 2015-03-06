package Controller;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CCon_usu {
	
	/**
	 * Elements of JTable
	 */
	@SuppressWarnings("unused")
	private String[] idReg;
	private Object[] columnNames = {};
	private Object[][] data;
	private String query;
	private String[][] param;
	
	@SuppressWarnings("unused")
	private void tabla(){
		int row=0,rowFor=0;
		int colums=columnNames.length;
		
		// Increment the row variable according to quantity of results
		//
		try{
			CPrincipal.result = CPrincipal.gpc.getData(CPrincipal.con, query, param);
			while(CPrincipal.result.next()){
				row++;
			}
		}catch(Exception e){
			System.out.println("asdaasdas"+e.getMessage()+" "+ e.getCause());
			//cargarMsn("Error Consulta","Error al comprobar datos","E");
		}
		// If row variable is distinct of 0, columns are filled else clean the table
		//
		if(row!=0){
			data = new Object[row][colums];
			
			try{
				CPrincipal.result = CPrincipal.gpc.getData(CPrincipal.con, query, param);
				while(CPrincipal.result.next()){
					for(int i=0;i<colums;i++){
						if(!CPrincipal.result.getString(i+1).isEmpty()){
							if(i==2){
								if(CPrincipal.result.getInt(i+1) == 0){
									data[rowFor][i] = "Normal";
								}else{
									data[rowFor][i] = "Administrador";
								}
							}
							else{
								data[rowFor][i] = CPrincipal.result.getString(i+1);
							}
						}
					}
					rowFor++;
				}
				
				CPrincipal.result.close();					
			}catch(Exception e){
				//cargarMsn("Error Consulta","Error al cargar datos","E");
			}
		}else{
			//cleanTable();
		}
		View.DCon_usu.dtm.setDataVector(data, columnNames);
	}

	@SuppressWarnings("rawtypes")
	public void consulta(JComboBox tipo){
		query = "select sitio,usuario_sitio,pass_sitio,correo,notas,id_gpc from gpc where usuario = ? and tipo = ?";
		param = new String[][] {
				{},
				{}
		};
	}
	public void consulta(JTextField sitio){
		query = "select sitio,usuario_sitio,pass_sitio,correo,notas,id_gpc from gpc where usuario = ? and sitio = ?";
		
	}
	
	@SuppressWarnings("unused")
	private void cleanTabla(){
		data=null;
		View.DCon_usu.dtm.setDataVector(data, null);
	}
}
