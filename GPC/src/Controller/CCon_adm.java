package Controller;

import java.sql.SQLException;

public class CCon_adm {
	
	/**
	 * Elements of JTable
	 */
	private Object[] columnNames = {"Usuario","Clave","Acceso","Intentos"};
	private Object[][] data;
	
	public void tabla(){
		int row=0,rowFor=0;
		int colums=columnNames.length;
		
		// Increment the row variable according to quantity of results
		try{
			CPrincipal.result = CPrincipal.usu.getUser(CPrincipal.con);
			while(CPrincipal.result.next()){
				row++;
			}
		}catch(Exception e){
			System.out.println("asdaasdas"+e.getMessage()+" "+ e.getCause());
			//cargarMsn("Error Consulta","Error al comprobar datos","E");
		}
		// If row variable is distinct of 0, columns are filled else clean the table
		if(row!=0){
			data = new Object[row][colums];
			
			try{
				CPrincipal.result = CPrincipal.usu.getUser(CPrincipal.con);
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
			cleanTable();
		}
		View.DCon_adm.dtm.setDataVector(data, columnNames);
	}
	
	// Metodo para auto completar los campos
	public void autoCompletar(){
		if(View.DCon_adm.table.getRowCount()>0){
			int table_row_selected = View.DCon_adm.table.getSelectedRow();
			View.DCon_adm.tF_usuario.setText((String)View.DCon_adm.table.getValueAt(table_row_selected,0));
			View.DCon_adm.tF_pass.setText((String)View.DCon_adm.table.getValueAt(table_row_selected,1));
		
			if (View.DCon_adm.table.getValueAt(table_row_selected,2).equals("Administrador")){
				View.DCon_adm.cB_acceso.setSelectedItem("Administrador");
			}else{
				View.DCon_adm.cB_acceso.setSelectedItem("Normal");
			}
			View.DCon_adm.tF_intento.setText((String)View.DCon_adm.table.getValueAt(table_row_selected,3));
		}
	}
	
	// Metodo para modificar los datos de un usuario
	public void modificarUsu(){
		comprobarCampos();
		@SuppressWarnings("deprecation")
		String[][] param = {
			{"String", View.DCon_adm.tF_usuario.getText()},
			{"String", View.DCon_adm.tF_pass.getText()},
			{"int", View.DCon_adm.cB_acceso.getSelectedIndex()+""},
			{"int", View.DCon_adm.tF_intento.getText()},
			{"String", View.DCon_adm.table.getValueAt(View.DCon_adm.table.getSelectedRow(),0)+""}
		};
		try {
			CPrincipal.usu.updateReg_Usu(CPrincipal.con, param);
			recargarTable();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void comprobarCampos(){
		// TODO
	}
	
	public void recargarTable(){
		cleanTable();
		tabla();
	}
	
	public void cleanTable(){
		data=null;
		View.DCon_adm.dtm.setDataVector(data, null);
	}
	
	
}
