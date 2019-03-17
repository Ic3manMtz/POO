import javax.swing.JOptionPane;

public class ATM{
   private Cliente cliente;
   private Validar validador;
   private double deposito;
   private double retiro;
   private String cadena;

   public ATM(){
      cliente = new Cliente();
      validador = new Validar();
      deposito = 0.0D;
      retiro = 0.0D;
      cadena = null;
   }

   public void menuPrincipal(){
      String[] opciones = {"Consultar saldo","Depositar","Retirar","Salir"};
      int resp;

      do{
         resp = JOptionPane.showOptionDialog(null,"Bienvenido "+cliente.getNombre()+"\nID: "+cliente.getId(),"ATM",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);

         if(resp == 0){
            menuConsultar();
         }else if(resp == 1){
            menuDepositar();
         }else if(resp == 2){
            menuRetirar();
         }
      }while(resp != -1 && resp != 3);
   }

   private void menuConsultar(){
      JOptionPane.showMessageDialog(null,"Saldo disponible: "+cliente.getSaldo(),"ATM",JOptionPane.DEFAULT_OPTION,null);
   }

   private void menuDepositar(){
      validador.validarCadena(1);
      cadena = validador.getCadena();
      deposito = Double.parseDouble(cadena);
      deposito = validador.validarNumero(deposito);
      cliente.setSaldo(cliente.getSaldo() + deposito);
      exito();
   }

   private void menuRetirar(){

      validador.validarCadena(3);
      cadena = validador.getCadena();
      retiro = Double.parseDouble(cadena);
      cliente.setSaldo(validador.validarRetiro(retiro,cliente.getSaldo()));
      exito();
   }

   public static void mostrar(int id){
      if(id == 1){
         JOptionPane.showMessageDialog(null,"Cantidad negativa","ATM",JOptionPane.DEFAULT_OPTION,null);
      }else if(id == 2){
         JOptionPane.showMessageDialog(null,"Saldo insuficiente","ATM",JOptionPane.DEFAULT_OPTION,null);
      }else if(id == 3){
         JOptionPane.showMessageDialog(null,"Retiro cancelado saldo insuficiente","ATM",JOptionPane.DEFAULT_OPTION,null);
      }else if(id == 4){
         JOptionPane.showMessageDialog(null,"Retiro cancelado","ATM",JOptionPane.DEFAULT_OPTION,null);
      }
   }

   public static int confirmar(){
      return JOptionPane.showConfirmDialog(null, "El saldo es menor a 1000 se cobrara cargo por comision\n¿Esta seguro que desea realizar el retiro?", "ATM", JOptionPane.YES_NO_OPTION);
   }

   private void exito(){
      JOptionPane.showMessageDialog(null,"Operacion Exitosa","ATM",JOptionPane.DEFAULT_OPTION,null);
   }
}
