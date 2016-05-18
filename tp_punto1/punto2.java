/*1) Escriba un programa que se conecte a la base de datos Ventas y realice las siguientes tareas:
   
   b) Informe el ranking de los diez mejores clientes.
*/

package tp_punto1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	
public class punto2 {
	
			public static void main(String[] args) throws ClassNotFoundException, SQLException {
				
				Class.forName("org.postgresql.Driver");
				
				Connection conn = DriverManager.getConnection(
						"jdbc:postgresql://127.0.0.1:5432/dbventas", "postgres", "admin");
				
				
				System.out.println(conn.getClass().getCanonicalName());
				Statement stmt = conn.createStatement();
				
			
				String sql = "select c.numero_documento as documento, c.nombre as nombre, SUM(v.total) as total "
						+ "from cliente c"
						+ "	inner join venta v "
						+ "on c.numero_documento = v.cliente  "
						+ "GROUP BY  c.numero_documento "
						+ "order by total DESC "
						+ "LIMIT 10";

				
				
				System.out.println(sql);
				ResultSet rs1 = stmt.executeQuery(sql);
				
				System.out.println("______________________________________________________________");	
				System.out.println("DOCUMENTO      | 	NOMBRE    |  TOTAL DE COMPRAS");
				System.out.println("______________________________________________________________");
				
				while(rs1.next()){
					int documento = rs1.getInt("documento");
					String nombreCliente = rs1.getString("nombre");
					double total = rs1.getDouble("total");
					
					System.out.println(documento + "    | " +  nombreCliente +" 	| " + total);
				}
				
				conn.close();
			}
		}

