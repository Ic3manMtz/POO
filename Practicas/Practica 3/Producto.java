public class Producto{
   private String nombre;
   private double precio;
   private int stock;
   private String descripcion;
   private int id;

   public Producto(String nombre, double precio, int stock, String descripcion, int id){
      this.nombre = nombre;
      this.precio = precio;
      this.stock = stock;
      this.descripcion = descripcion;
      this.id = id;
   }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "\nNombre=" + nombre + "\n Precio=" + precio + "\n Stock=" + stock + "\n Descripcion=" + descripcion + "\n Id=" + id;
	}
}
