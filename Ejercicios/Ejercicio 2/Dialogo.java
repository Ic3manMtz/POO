import javax.swing.JOptionPane;

public class Dialogo{
	private String[] opciones = {"Cerveza","Pulque","Whiskey","Ron"};
	private String mensaje;

	public Dialogo(){
		mensaje = JOptionPane.showInputDialog("Escribe tu nombre "); 
	}

	public void insistir(){
		int resp;

		do{
			resp = JOptionPane.showConfirmDialog(null,mensaje+" quieres tomar algo?");
		}while(resp != 0);
	}

	public void felicitar(){
		JOptionPane.showMessageDialog(null,"Que bueno "+mensaje, "Ejercicio 2", JOptionPane.DEFAULT_OPTION, null);
	}

	public void elegir(){
		String seleccion;
		
		seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona lo que quieres tomar "+mensaje, "Ejercicio 2",JOptionPane.DEFAULT_OPTION,null,opciones,opciones[0]); 
        JOptionPane.showMessageDialog(null,mensaje+" estas tomando "+seleccion+" salud");
	}
}