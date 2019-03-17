import javax.swing.JOptionPane;

public class Interaccion{
  private String resp;

  public Interaccion(){
    resp = null;
  }

  public static int preguntar(int opc){
    if(opc == 0){
      return Integer.parseInt(JOptionPane.showInputDialog("Escribe coordenada x "));
    }
    if(opc == 1){
      return Integer.parseInt(JOptionPane.showInputDialog("Escribe coordenada y "));
    }
    return 0;
  }

  public static void mostrar(double d){
    JOptionPane.showMessageDialog(null,"Distancia entre p1 y p2: "+d, "Ejercicio 4", JOptionPane.DEFAULT_OPTION, null);
  }

  public static void mostrar(Punto p){
    JOptionPane.showMessageDialog(null,"Punto 3: "+p.imprimir(), "Ejercicio 4", JOptionPane.DEFAULT_OPTION, null);

  }
}
