import java.util.ArrayList;
import javax.swing.table.*;

public class Carro{
   private int id;
   private ArrayList <Item> items;

   public Carro(){
      id = 0;
      items = new ArrayList<>();
   }

   public Carro(int id){
      this.id = id;
      items = new ArrayList<>();
   }

   public int getId(){
      return id;
   }

   public int getSize(){
      return items.size();
   }

   public String getItem(int index){
      return items.get(index).getProducto().getNombre();
   }

   public void agregarACarro(Producto producto){
      int stock = producto.getStock();
      if(stock >= 1){
         items.add(new Item(producto,1));
         producto.setStock(stock - 1);
      }else{
         GUI.sinStock();
      }
   }

   public void quitarDeCarro(int index, Producto producto){
      items.remove(index);
      producto.setStock(producto.getStock() + 1);
   }

   public int cambiarCantidad(int index){
      int cantidad = GUI.preguntarCantidad(items.get(index).getCantidad());
      int stock = items.get(index).getProducto().getStock();

      if(stock >= cantidad){
         items.get(index).setCantidad(cantidad);
         return stock - cantidad;
      }else{
         GUI.sinStock();
         return stock;
      }

   }

   public void vaciarCarro(){
      items.clear();
   }

   public DefaultTableModel checkout(DefaultTableModel modelo){
      //DefaultTableModel modeloAux = modelo;
      String nombre;
      int cantidad;
      double precio;
      double subtotal;
      double total = 0;

      for(int i = 0;i < items.size();i++){
         nombre = getItem(i);
         cantidad = items.get(i).getCantidad();
         precio = items.get(i).getProducto().getPrecio();
         subtotal = cantidad * precio;
         total += subtotal;
         modelo.insertRow(modelo.getRowCount(),new Object[]{cantidad,nombre,"$"+precio,"$"+subtotal});
      }
      modelo.insertRow(modelo.getRowCount(),new Object[]{"","","",""});
      modelo.insertRow(modelo.getRowCount(),new Object[]{"","","Total","$"+total});

      return modelo;
   }
}
