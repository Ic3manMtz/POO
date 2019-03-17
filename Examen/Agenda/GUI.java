package Agenda;

import java.io.*;
import javax.swing.*;

public class GUI{	
	public int menuMain(){
		int select = 0;
		Object opciones[] = {"01.- Crear un contacto", "02.- Elegir un contacto", "03.- Salir"};
		String input = String.valueOf(JOptionPane.showInputDialog(null, "Bienvenido. Escoge una opcion del menu:", "Agenda",
		 	JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0])).substring(0, 2);
		if(input.equals("nu")) select = 3;
		else select = Integer.valueOf(input);
		return select;
	}

	public int submenuCustom(Object[] opciones, String msg){
		int select = 0;
		String input = String.valueOf(JOptionPane.showInputDialog(null, msg, "Agenda",
		 	JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0])).substring(0, 2);
		if(input.equals("nu")) select = -1;
		else select = Integer.valueOf(input);
		return select;
	}

	public int menuContacto(String info){
		int select = 0;
		Object opciones[] = {"01.- Administrar grupo", "02.- Regresar al menu"};
		String input = String.valueOf(JOptionPane.showInputDialog(null, "Submenu de contactos\n\nInformacion: "+info, "Agenda",
		 	JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0])).substring(0, 2);
		if(input.equals("nu")) select = 2;
		else select = Integer.valueOf(input);
		return select;
	}

	public int menuGrupo(){
		int select = 0;
		Object opciones[] = {"01.- Salirse de un grupo", "02.- Unirse a un grupo"};
		String input = String.valueOf(JOptionPane.showInputDialog(null, "Menu de administrativo\n\nEscoge una opcion:", "Agenda",
		 	JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0])).substring(0, 2);
		if(input.equals("nu")) select = -1;
		else select = Integer.valueOf(input);
		return select;
	}


	public void show(String msg){
		JOptionPane.showMessageDialog(null, msg, "Agenda", JOptionPane.INFORMATION_MESSAGE);
		return;
	}

	public String input(String msg){
		String s;
		do{
			s = String.valueOf(JOptionPane.showInputDialog(null, msg, "Agenda",
		 		JOptionPane.INFORMATION_MESSAGE));
		}while(s.trim().isEmpty());

		return s;
	}

	public int confirm(String msg){
		int reply = JOptionPane.showConfirmDialog(null, msg, "Agenda", JOptionPane.YES_NO_OPTION);
		return reply;
	}
}