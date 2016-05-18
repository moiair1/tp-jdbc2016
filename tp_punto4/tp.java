package tp_punto4;
	import java.sql.*;
	 
	public class tp {
	 

	    static DatabaseMetaData metadatos;
	    static ResultSetMetaData rsmetadatos;
	 
	 
	    public static void recibeDatabase(String nombreDB) throws ClassNotFoundException{
	        
	 
	        try {
	            //REALIZANDO CONEXON
	            Class.forName("org.postgresql.Driver");
	            Connection  conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/"+nombreDB, "postgres", "admin");
	            /*DatabaseMetaData
	            
	             * Obteniendo Informacion sobre una base de datos
	            */
	            
	            System.out.println("Obteniendo Informacion sobre una base de datos");
	            metadatos = conexion.getMetaData();
	            //Nombre de db
	            System.out.println("Nombre de base de datos ventas" + metadatos.getDatabaseProductName());
	            //Version de db
	            System.out.println("Version de de base de datos: "+metadatos.getDatabaseProductVersion());
	            //Nombre de driver
	            System.out.println("Nombre de Driver: "+metadatos.getDriverName());
	            //Version de driver
	            System.out.println("Version de Driver: "+metadatos.getDriverVersion());

	            
	            /*Muestro la informacion de la tabla*/
	            
	            String[] tablas={"TABLE"}; // guardo en una cadena = TABLE 

	            ResultSet rs=metadatos.getTables(null, null, null, tablas); 
	            //guarda las tablas ingresadas que se ingreso el usuario o creado
	            //ejemplo venta, vendedor tarjeta producto etc.
	            
	            while(rs.next()){
	            	
		            System.out.println("--------------------------------------------------------------------------");
	                String nombreTabla=rs.getString(3); //en cada iter guardo el nombre de la tabla
	                System.out.print("Nombre de la Tabla:    "+nombreTabla);   //muestra nombre de la tabla
	                PreparedStatement stmt=conexion.prepareStatement("SELECT * FROM "+nombreTabla); // realizo la consulta con preparestatment
	                ResultSet rsaux=stmt.executeQuery(); //ahora guardo en resultset toda la consulta rsaux
	                
	                ResultSetMetaData rsmdaux=rsaux.getMetaData();  //guarda la estructra de de la tabla
	                int numeroColumnas=rsmdaux.getColumnCount();	//cuenta cantidad de columnas
	                System.out.println("        Cantidad de Columnas:     "+numeroColumnas);
	                System.out.println("--------------------------------------------------------------------------");
	                for(int i=1;i<=numeroColumnas; i++){ //iteracion hasta numero de columnas
	                System.out.println("Columna:     "+rsmdaux.getColumnLabel(i)+"       Tipo:       "+rsmdaux.getColumnTypeName(i));
	                }
	            }
	                  
	        }catch(SQLException e){
	            System.out.println(e.getMessage());
	        }
	     }
	    public static void main(String[] args) throws ClassNotFoundException {
	        recibeDatabase("dbventas");
	    }
	
}
