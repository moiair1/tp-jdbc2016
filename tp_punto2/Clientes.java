package tp_punto2;

import java.util.Date;

public class Clientes {

	
	private int nro_documento;
	private String apellido;
	private String nombre;
	private String  fechaNnacimiento;
	private String sexo;
	private String domicilio;
	private int localidad;
	public Clientes(int nro_documento, String apellido, String nombre, String fechaNnacimiento, String sexo,
			String domicilio, int localidad) {
		super();
		this.nro_documento = nro_documento;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNnacimiento = fechaNnacimiento;
		this.sexo = sexo;
		this.domicilio = domicilio;
		this.localidad = localidad;
	}
	public int getNro_documento() {
		return nro_documento;
	}
	public void setNro_documento(int nro_documento) {
		this.nro_documento = nro_documento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaNnacimiento() {
		return fechaNnacimiento;
	}
	public void setFechaNnacimiento(String fechaNnacimiento) {
		this.fechaNnacimiento = fechaNnacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getLocalidad() {
		return localidad;
	}
	public void setLocalidad(int localidad) {
		this.localidad = localidad;
	}
	
	
}
