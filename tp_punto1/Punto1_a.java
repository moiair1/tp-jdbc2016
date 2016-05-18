/*1) Escriba un programa que se conecte a la base de datos Ventas y realice las siguientes tareas:


   a) Imprima un listado de los vendedores con los importes 
   promedio de ventas y la cantidad total de ventas realizadas.
   
   b) Informe el ranking de los diez mejores clientes.
   
   c) Informe el total de ventas por localidad.
 */
package tp_punto1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Punto1_a {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			Class.forName("org.postgresql.Driver");  //carga la clase controlador de postgree
			
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/dbventas", "postgres", "admin");
			//establece la conexion a la base de datos dbventas
			
			System.out.println(conn.getClass().getCanonicalName()); //muestra la conexion a postgree
			
			Statement stmt = conn.createStatement(); //crea statement para consultar a la base de datos
			
			
			String sql = 

			"SELECT vd.nombre as nombre, avg(total) as promedio, count(total) as cantidad_de_ventas"
			+ " from venta v, vendedor vd "
			+ "WHERE v.vendedor=vd.codigo	group by vd.codigo";
			
			
			System.out.println(sql); //te muestra la consulta en la pantalla
			
			ResultSet rs1 = stmt.executeQuery(sql); //consulta la base de datos y guarda en rs1
			
			System.out.println("______________________________________________________________");	
			System.out.println("NOMBRE    	  | PROMEDIO  	 |  TOTAL DE COMPRAS");
			System.out.println("______________________________________________________________");
						
			while(rs1.next()){
				
				String nombrevendedor = rs1.getString("nombre");
				double promedio = rs1.getDouble("promedio");
				double total = rs1.getDouble("cantidad_de_ventas");	
				System.out.println(nombrevendedor + "  	  | " +  promedio +" 			| " + total);
			}
			
			conn.close();
		}
	}

