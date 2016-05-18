/*1) Escriba un programa que se conecte a la base de datos Ventas y realice las siguientes tareas:
   
   c) Informe el total de ventas por localidad.
   */
package tp_punto1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Punto3 {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");  //carga la clase controlador de postgree
		
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/dbventas", "postgres", "admin");
		//establece la conexion a la base de datos dbventas
		
		System.out.println(conn.getClass().getCanonicalName()); //muestra la conexion a postgree
		
		Statement stmt = conn.createStatement(); //crea statement para consultar a la base de datos
		
		
		String sql = 
				"select l.nombre as nombre, sum(v.total) as total from localidad l "
						+ "inner join cliente c "
						+ "on c.localidad = l.codigo "
						+ "inner join venta v "
						+ "on c.numero_documento = v.cliente  "
						+ "group by l.nombre "
						+ "order by total desc ";		
		
		System.out.println(sql); //te muestra la consulta en la pantalla
		
		ResultSet rs1 = stmt.executeQuery(sql); //consulta la base de datos y guarda en rs1
		
		System.out.println("______________________________________________________________");	
		System.out.println("LOCALIDAD    	 	  |  TOTAL DE VENTAS");
		System.out.println("______________________________________________________________");
					
		while(rs1.next()){
			
			String nombrelocalidad = rs1.getString("nombre");
			double total = rs1.getDouble("total");	
			System.out.println(nombrelocalidad + " 						|   " + total);
		}
		
		conn.close();
	}	
	
	
	
}