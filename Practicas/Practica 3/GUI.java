import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.lang.String;
import java.util.Arrays;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

public class GUI{
   private String resp;
   private Carro carro;
   private int indice;
   private Validar validador;
   private ArrayList <Producto> catalogo;
   private ArrayList <Carro> carritos;
   private JTable tabla1;
   private JScrollPane jsp;
   DefaultTableModel modelo;

   public GUI(ArrayList<Producto> catalogo){
      resp = null;
      carro = new Carro();
      validador = new Validar();
      this.catalogo = catalogo;
      carritos = new ArrayList<Carro>(3);
      carritos.add(new Carro(0));
      carritos.add(new Carro(1));
      carritos.add(new Carro(2));
   }

   public static void sinStock(){
      JOptionPane.showMessageDialog(null,"Stock insuficiente");
   }

   public void menuPrincipal(){
      String[] acciones = {"Administrativo","Cliente","Salir"};
      int resp;

      do{
         resp = JOptionPane.showOptionDialog(null,"Menu principal", "Carrito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, acciones, acciones[0]);
         if(resp == 0){
            menuAdministrativo();
         }
         if(resp == 1){
            menuCarritos();
         }
      }while(resp != 2);
   }

   private void menuAdministrativo(){
      String[] acciones = {"Editar producto","Dar de alta producto","Regresar"};
      int resp;
      int index;

      do{
         resp = JOptionPane.showOptionDialog(null,"Menu Administrativo", "Carrito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, acciones, acciones[0]);
         if(resp == 0){
            menuCatalogo();
            menuProducto(indice);
         }
         if(resp == 1){
            menuAlta();
         }
      }while(resp != 2);
   }

   private void menuCatalogo(){

      String temp;
      String[] elementos;
      elementos = new String[catalogo.size()+1];

      for(int i = 0;i < catalogo.size();i++){
          elementos[i] = (i + 1) + ".-" + catalogo.get(i).getNombre() + " $" + catalogo.get(i).getPrecio();
      }
      do{
         temp = (String) JOptionPane.showInputDialog(null,"Seleccione un producto","Seleccion producto",JOptionPane.DEFAULT_OPTION,null,elementos,elementos[0]);
      }while(temp == null || temp.isEmpty());
      int index = temp.indexOf('.');

      temp = temp.substring(0,index);
      indice = Integer.parseInt(temp) - 1;
   }

   private void menuProducto(int index){
      String[] acciones = {"Cambiar precio","Cambiar stock","Regresar"};
      int resp;

      do{
         resp = JOptionPane.showOptionDialog(null,catalogo.get(indice).getNombre() + "\nPrecio: " + catalogo.get(indice).getPrecio() + "\nStock: " + catalogo.get(indice).getStock(), "Carrito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, acciones, acciones[0]);
         if(resp == 0){
            menuCambio(0);
         }
         if(resp == 1){
            menuCambio(1);
         }
      }while(resp != 2);
   }

   private void menuCambio(int id){
      double precio;
      int stock;
      String temp;

      if(id == 0){
         //precio
         validador.validarCadena(1);
         temp = validador.getCadena();
         precio = Double.parseDouble(temp);
         precio = validador.validarNumero(precio);

         catalogo.get(indice).setPrecio(precio);

      }else if(id == 1){
         //Stock
         validador.validarCadena(3);
         temp = validador.getCadena();
         stock = Integer.parseInt(temp);
         stock = validador.validarNumero(stock);

         catalogo.get(indice).setStock(stock);
      }
   }

   private void menuAlta(){
      String cadena;
      String nombre;
      double precio;
      int stock;
      String descripcion;
      int id = catalogo.size() + 1;

      validador.validarCadena(4);
      nombre = validador.getCadena();

      validador.validarCadena(1);
      cadena = validador.getCadena();
      precio = Double.parseDouble(cadena);
      precio = validador.validarNumero(precio);

      validador.validarCadena(3);
      cadena = validador.getCadena();
      stock = Integer.parseInt(cadena);
      stock = validador.validarNumero(stock);

      validador.validarCadena(5);
      descripcion = validador.getCadena();

      catalogo.add(new Producto(nombre,precio,stock,descripcion,id));
      confirmar();
   }

   private void confirmar(){
      int resp;
      int n = catalogo.size();

      resp = JOptionPane.showConfirmDialog(null,"La informacion es correcta?"+ catalogo.get(n -1).toString(),"Confirmacion",JOptionPane.YES_NO_OPTION);
      if(resp == 0){
         JOptionPane.showMessageDialog(null,"'"+catalogo.get(n -1).getNombre()+"' agregado correctamente","Agregar producto",JOptionPane.DEFAULT_OPTION,null);
      }else if(resp == 1){
         menuAlta();
      }
   }

   private void menuCarritos(){
      String[] elementos = {"Carrito 1","Carrito 2","Carrito 3","Regresar"};
      String cadena;
      int resp;
      int index;

      do{
         cadena = "Carrito 1   Id:"+carritos.get(0).getId()+"   No. Porductos:"+carritos.get(0).getSize()+
                  "\nCarrito 2   Id:"+carritos.get(1).getId()+"   No. Porductos:"+carritos.get(1).getSize()+
                  "\nCarrito 3   Id:"+carritos.get(2).getId()+"   No. Porductos:"+carritos.get(2).getSize();

         resp = JOptionPane.showOptionDialog(null,cadena,"Carritos",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,elementos,elementos[0]);
         if(resp == 0){
            menuCliente(0);
         }
         if(resp == 1){
            menuCliente(1);
         }
         if(resp == 2){
            menuCliente(2);
         }
      }while(resp != 3);
   }

   private void menuCliente(int noCarro){
      String[] acciones = {"Agregar al carrito","Quitar del carrito","Cambiar cantidad","Vaciar carro","Checkout","Regresar"};
      int resp;
      int index;
      int nvoStock;

      do{
         resp = JOptionPane.showOptionDialog(null,"Menu cliente \nNo. Productos: "+carritos.get(noCarro).getSize(), "Carrito #"+(noCarro + 1), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, acciones, acciones[0]);
         if(resp == 0){
            menuCatalogo();
            carritos.get(noCarro).agregarACarro(catalogo.get(indice));
         }
         if(resp == 1){
            index = menuCarro(noCarro);
            carritos.get(noCarro).quitarDeCarro(index,catalogo.get(index));
         }
         if(resp == 2){
            index = menuCarro(noCarro);
            nvoStock = carritos.get(noCarro).cambiarCantidad(index);
            catalogo.get(noCarro).setStock(nvoStock);
         }
         if(resp == 3){
            carritos.get(noCarro).vaciarCarro();
         }
         if(resp == 4){
            menuCheckout(noCarro);
         }
      }while(resp != 5);
   }

   private int menuCarro(int noCarro){
      int index;
      String temp;
      String[] elementos;
      elementos = new String[carritos.get(noCarro).getSize()+1];

      for(int i = 0;i < carritos.get(noCarro).getSize();i++){
          elementos[i] = (i+1) + ".-" + carritos.get(noCarro).getItem(i);
      }

      temp = (String) JOptionPane.showInputDialog(null,"Seleccione un producto","Seleccion producto",JOptionPane.DEFAULT_OPTION,null,elementos,elementos[0]);

      index = temp.indexOf('.');
      temp = temp.substring(0,index);
      index = Integer.parseInt(temp) - 1;

      return index;
   }

/*
int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!",
 JOptionPane.YES_NO_OPTION);

 si = 0, no = 1;
*/

   public static int preguntarCantidad(int old){
      int cantidad;

      cantidad = Integer.parseInt( JOptionPane.showInputDialog(null,"Cantidad: "+old+"\nInserte la nueva cantidad: ","Cambio de cantidad",JOptionPane.CLOSED_OPTION) );
      return cantidad;
   }

   private void menuCheckout(int noCarro){
      int resp;
      JFrame frame = new JFrame("Checkout");
      String[] nombreColumnas = {"Uds.","Producto","Importe","Subtotal"};

      jsp = new JScrollPane();
      modelo = new DefaultTableModel(null,nombreColumnas);
      tabla1 = new JTable();

      tabla1.setModel(modelo);
      jsp.setViewportView(tabla1);
      frame.add(jsp,BorderLayout.CENTER);
      frame.setVisible(true);
      frame.pack();

      modelo = carritos.get(noCarro).checkout(modelo);

      resp = JOptionPane.showConfirmDialog(null,"El ticket es correcto?","Confirmacion",JOptionPane.YES_NO_OPTION);
      if(resp == 0){
         frame.dispose();
         JOptionPane.showMessageDialog(null,"Compra realizada");
         carritos.get(noCarro).vaciarCarro();
      }else if(resp == 1){
         frame.dispose();
         JOptionPane.showMessageDialog(null,"Regresando al menu");
      }
   }
}
