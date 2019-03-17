public class Contacto{
	private String nombre;
	private String correo;
	private long tel;

	public void setNombre(String nombre){ this.nombre = nombre; }
	public void setCorreo(String correo){ this.correo = correo; }
	public void setTel(long tel){ this.tel = tel; }

	public String getNombre(){ return nombre; }
	public String getCorreo(){ return correo; }
	public long getTel(){ return tel; }

	@Override

	public String toString(){
		return "Nombre: " + nombre + "\nCorreo: " + correo + "\nTelefono: " + tel;
	}
}