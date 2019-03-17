public class Cliente{
   private String id;
   private String nombre;
   private String direccion;
   private double saldo;

   public Cliente(){
      id = "0001";
      nombre = "Jorge";
      direccion = "Direccion";
      saldo = 1500D;
   }

   public Cliente(String id,String nombre,String direccion,double saldo){
      this.id = id;
      this.nombre = nombre;
      this.direccion = direccion;
      this.saldo = saldo;
   }


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
