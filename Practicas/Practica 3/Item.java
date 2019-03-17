public class Item{
   private int id;
   private int cantidad;
   private Producto producto;

   public Item(Producto producto, int cantidad){
      id = incrementarId(id);
      this.cantidad = cantidad;
      this.producto = producto;
   }

   public Producto getProducto(){
      return producto;
   }

   public void setCantidad(int cantidad){
      this.cantidad = cantidad;
   }

   public int getCantidad(){
      return cantidad;
   }

   private static int incrementarId(int id){
      int nvoId = id;
      return nvoId++;
   }
}
