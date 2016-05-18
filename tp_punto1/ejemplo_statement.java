package tp_punto1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ejemplo_statement {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/dbventas", "postgres", "admin");
		
		
		System.out.println(conn.getClass().getCanonicalName());
		Statement stmt = conn.createStatement();
		
		/*
		String sql = 

		"SELECT vd.nombre as nombre, avg(total) as promedio, count(total) as cantidad_de_ventas"
		+ " from venta v, vendedor vd "
		+ "WHERE v.vendedor=vd.codigo	group by vd.codigo";
		
		
		
		System.out.println(sql);
		ResultSet rs1 = stmt.executeQuery(sql);
		
		System.out.println("______________________________________________________________");	
		System.out.println("NOMBRE      | PROMEDIO   |  TOTAL DE COMPRAS");
		System.out.println("______________________________________________________________");
		
		while(rs1.next()){
			
			String nombrevendedor = rs1.getString("nombre");
			double promedio = rs1.getDouble("promedio");
			double total = rs1.getDouble("cantidad_de_ventas");
			
			System.out.println(nombrevendedor + "    | " +  promedio +" | " + total);
		}
		*/
		
	

		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM vendedor WHERE codigo = ? and legajo=?");
		
		pstmt.setString(1, "HOL");
		pstmt.setInt(2, 999);
		ResultSet rs = pstmt.executeQuery();
	
		while (rs.next()){
			System.out.print( rs.getString("codigo") );
			System.out.print("   ");
			System.out.println( rs.getString("nombre") );
		}
		

		/*
		System.out.print("->");
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.println( rs.getMetaData().getColumnName(i) + "  " +rs.getMetaData().getColumnTypeName(i)); 
		}
		
		rs.close();
		pstmt.close();
		
		
		PreparedStatement pstmtUpate = conn.prepareStatement(
				"UPDATE vendedor SET nombre = 'GOMES, LUCHO' WHERE codigo = ? ");
		pstmtUpate.setString(1, "GLU");
		
		
		int cant = pstmtUpate.executeUpdate();
		System.out.println("Se actualizaron " + cant + " filas" );
		
		*/
		conn.close();
		
		
		
	}
	
	
}
