package Controller;

public class CCon_usu {
	
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
			//cleanTable();
		}
		View.DMod_adm.dtm.setDataVector(data, columnNames);
	}
}
