public class Cliente{
   private String id;
   private String nombre;
   private String direccion;
   private double monto;

   public Cliente(){
      id = "0001";
      nombre = "Jorge";
      direccion = "direccion";
      monto = 1500D;
   }

   public Cliente(String id,String nombre,String direccion,double monto){
      this.id = id;
      this.nombre = nombre;
      this.direccion = direccion;
      this.monto = monto;
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

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
}
