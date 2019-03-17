import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.lang.String;
import java.util.Arrays;

public class Validar{
   private String cadena;
   private double numero;
   private int stock;

   public Validar(){
      cadena = null;
      numero = 0.0;
      stock = 0;
   }

   public void setCadena(String cadena){
      this.cadena = cadena;
   }

   public void setNumero(double numero){
      this.numero = numero;
   }

   public String getCadena(){
      return cadena;
   }

   public double getNumero(){
      return numero;
   }

   public int getStock(){
      return stock;
   }

   public void validarCadena(int id){
      if(id  == 1){
         do{
             cadena = JOptionPane.showInputDialog(null,"Escriba el nuevo precio: ","Cambio de precio",JOptionPane.CLOSED_OPTION);
          }while(cadena == null || cadena.isEmpty());
      }else if(id == 2){
         do{
             cadena = JOptionPane.showInputDialog(null,"Cantidad negativa: ","Cambio de precio",JOptionPane.CLOSED_OPTION);
          }while(cadena == null || cadena.isEmpty());
      }else if(id  == 3){
         do{
            cadena = JOptionPane.showInputDialog(null,"Escriba el nuevo stock: ","Cambio de stock",JOptionPane.CLOSED_OPTION);
         }while(cadena == null || cadena.isEmpty());
      }else if(id == 4){
         do{
            cadena = (String) JOptionPane.showInputDialog("Inserte el nombre del producto: ");
         }while(cadena == null || cadena.isEmpty());
      }else if(id == 5){
         do{
            cadena = (String) JOptionPane.showInputDialog("Escriba la descripcion del producto: ");
         }while(cadena == null || cadena.isEmpty());
      }
   }

   public double validarNumero(double precio){
      double n =  precio;

      while(n < 0){
         validarCadena(2);
         n = Double.parseDouble(cadena);
      }

      return n;
   }

   public int validarNumero(int stock){
      int n = stock;

      while(n < 0){
         validarCadena(2);
         n = Integer.parseInt(cadena);
      }

      return n;
   }
}
