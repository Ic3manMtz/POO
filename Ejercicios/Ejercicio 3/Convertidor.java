import javax.swing.JOptionPane;

public class Convertidor{
	private double cantidad;
	private double nvaCantidad;
	private double factorDP;
	private double factorPD;
	private String factores[] = {"1.Dolares a pesos","2.Pesos a dolares","3.Salir"};

	public Convertidor(){
		cantidad = 0.0;
		nvaCantidad = 0.0;
		factorDP = 18.80;
		factorPD = 0.05;
	}

	public void menu(){
		String seleccion,opc;

		do{

		seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona la opcion de conversion", "Ejercicio 3",JOptionPane.DEFAULT_OPTION,null,factores,factores[0]); 
		opc = String.valueOf(seleccion.charAt(0));
		conversor(Integer.parseInt(opc));

		}while(!"3.Salir".equals(seleccion));
	}

	private void conversor(int opc){
		if(opc == 1){
			cantidad = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad de dolares que vas a convertir "));
			nvaCantidad = cantidad * factorDP;
			JOptionPane.showMessageDialog(null,"Monto en dolares: "+cantidad+"\nMonto en pesos: "+nvaCantidad, "Ejercicio 3", JOptionPane.DEFAULT_OPTION, null);
		}
		if(opc == 2){
			cantidad = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad de pesos que vas a convertir "));
			nvaCantidad = cantidad * factorPD;
			JOptionPane.showMessageDialog(null,"Monto en pesos: "+cantidad+"\nMonto en dolares: "+nvaCantidad, "Ejercicio 3", JOptionPane.DEFAULT_OPTION, null);			
		}
	}
}