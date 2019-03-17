import javax.swing.JOptionPane;

public class ATMGUI{
   private Cliente cliente;

   public ATMGUI(){
      cliente = new Cliente();
   }

   public void menuPrincipal(){
      String[] opciones = {"Consultar saldo","Depositar","Retirar","Salir"};
      int resp;

      do{
         resp = JOptionPane.showOptionDialog(null, "Bienvenido "+cliente.getNombre()+"\nID: "+cliente.getId(), "ATM", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[0]);
         if(resp == 0){
            menuConsultar();
         }
         if(resp == 1){
            menuDepositar();
         }
         if(resp == 2){
            menuRetirar();
         }
      }while(resp != 3);
   }

   private void menuConsultar(){
      JOptionPane.showMessageDialog(null,"Saldo disponible: "+cliente.getMonto(),"ATM",JOptionPane.DEFAULT_OPTION,null);
   }


   private void menuDepositar(){
      double deposito;
      String temp;

      do{
         temp = (String) JOptionPane.showInputDialog(null,"Escriba el monto a depositar: ","ATM",JOptionPane.CLOSED_OPTION);
      }while(temp == null);

      while(temp.isEmpty()){
         temp = (String) JOptionPane.showInputDialog("Opcion invalida intente de nuevo ");
      }
      deposito = Double.parseDouble(temp);


      while(deposito < 0){
         temp = (String) JOptionPane.showInputDialog("Cantidad negativa intente de nuevo");
         deposito = Double.parseDouble(temp);
      }

      cliente.setMonto(cliente.getMonto() + deposito);
      exito();

   }

   private void menuRetirar(){
      double retiro;
      String temp;

      temp = (String) JOptionPane.showInputDialog("Cuanto va a retirar: ");
      while(temp.isEmpty()){
         temp = (String) JOptionPane.showInputDialog("Opcion invalida intente de nuevo ");
      }
      retiro = Double.parseDouble(temp);

      if(retiro > cliente.getMonto() || retiro < 0){
         if(retiro < 0){
            JOptionPane.showMessageDialog(null,"Cantidad negativa","ATM",JOptionPane.DEFAULT_OPTION,null);
         }else if(retiro > cliente.getMonto()){
            JOptionPane.showMessageDialog(null,"Saldo insuficiente","ATM",JOptionPane.DEFAULT_OPTION,null);
         }
      }else{
         if(cliente.getMonto() - retiro < 1000){
            int resp = JOptionPane.showConfirmDialog(null, "El saldo es menor a 1000 se cobrara cargo por comision\n¿Esta seguro que desea realizar el retiro?", "ATM", JOptionPane.YES_NO_OPTION);
            if(resp == 0){
               if((cliente.getMonto() - retiro - 30.50D) < 0){
                  JOptionPane.showMessageDialog(null,"Retiro cancelado saldo insuficiente","ATM",JOptionPane.DEFAULT_OPTION,null);
               }else{
                  cliente.setMonto(cliente.getMonto() - retiro - 30.50D);
                  exito();
               }
            }else{
               JOptionPane.showMessageDialog(null,"Retiro cancelado","ATM",JOptionPane.DEFAULT_OPTION,null);
            }
         }else{
            cliente.setMonto(cliente.getMonto() - retiro);
            exito();
         }
      }

   }

   private void exito(){
      JOptionPane.showMessageDialog(null,"Operacion Exitosa","ATM",JOptionPane.DEFAULT_OPTION,null);
   }
}
