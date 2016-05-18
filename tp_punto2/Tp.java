/*
 * 2) Escriba un programa que obtenga los datos de los clientes y 
 * los guarde en una colección de objetos de tipo Cliente.
 * 
 */
package tp_punto2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

//framenwork larbel

public class Tp {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		List<Clientes> clientes = new LinkedList<Clientes>();		

		/*----------------------------------------------------------------------------------------------------*/
		Class.forName("org.postgresql.Driver");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/dbventas", "postgres", "admin");
		
		//System.out.println(conn.getClass().getCanonicalName());
		Statement stmt = conn.createStatement();
		
		String sql = 
		"SELECT numero_documento, apellido, nombre, fecha_nacimiento, sexo,domicilio,localidad FROM cliente";
		
		System.out.println(sql);
		ResultSet rs1 = stmt.executeQuery(sql);
		
		System.out.println("____________________________________________________________________________________");	
		System.out.println("DNI  |	APELLIDO | NOMBRE |  FECHA DE NACIMIENTO | SEXO	 | DOMICILIO | LOCALIDAD");
		System.out.println("____________________________________________________________________________________");
		while(rs1.next()){
			
			int documento  = rs1.getInt("numero_documento");
			String apellido = rs1.getString("apellido");
			String nombre = rs1.getString("nombre");
			String fechaNacimiento = rs1.getString("fecha_nacimiento");
			String sexo = rs1.getString("sexo");
			String domicilio = rs1.getString("domicilio");
			int localidad = rs1.getInt("localidad");
			
			clientes.add(new Clientes(documento,apellido,nombre,fechaNacimiento,sexo,domicilio,localidad));
		}
		
		for (Clientes clientes2 : clientes) {		
		System.out.println(clientes2.getNro_documento() + " - " +clientes2.getApellido()+ " - " +clientes2.getNombre()+ " - " +clientes2.getFechaNnacimiento()+ " - " +clientes2.getSexo()+ " - " +clientes2.getDomicilio()+ " - " +clientes2.getLocalidad());
		}
			conn.close();	
	}
}
