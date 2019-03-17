import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.lang.String;
import java.util.Arrays;

public class Validar{
   private String cadena;
   private double numero;

   public Validar(){
      cadena = null;
      numero = 0.0;
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

   public void validarCadena(int id){
      if(id == 1){
         do{
            cadena = (String) JOptionPane.showInputDialog(null,"Escriba el monto a depositar: ","ATM",JOptionPane.DEFAULT_OPTION);
         }while(cadena == null || cadena.isEmpty());
      }else if(id == 2){
         do{
            cadena = (String) JOptionPane.showInputDialog("Cantidad negativa intente de nuevo");
         }while(cadena == null || cadena.isEmpty());
      }else if(id == 3){
         do{
            cadena = (String) JOptionPane.showInputDialog("Cuanto va a retirar: ");
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

   public double validarRetiro(double retiro,double saldo){
      double n = retiro;

      if(retiro > saldo || retiro < 0){
         if(retiro < 0 ){
            ATM.mostrar(1);
         }else if(retiro > saldo){
            ATM.mostrar(2);
         }
      }else{
         if(saldo - retiro < 1000){
            int resp = ATM.confirmar();
            if(resp == 0){
               if((saldo - retiro -30.50D) < 0){
                  ATM.mostrar(3);
               }else{
                  return saldo - retiro - 30.50D;
               }
            }else{
               ATM.mostrar(4);
            }
         }else{
            return saldo - retiro;
         }
      }

      return saldo;
   }
}
