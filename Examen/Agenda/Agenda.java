package Agenda;

import java.io.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class Agenda{

	private static ArrayList<Contacto> contactos = null;
	private static ArrayList<Grupo> grupos = null;
	private static Contacto contactoSelected = null;
	private static GUI mensajes = null;
	private static String regex = "[0-9.]*";
	private static String regex2 = "^[1-9][0-9]*$";

	public Agenda(){
		// Componentes gráficos
		mensajes = new GUI();
		// Grupos
		grupos = new ArrayList<>();
		grupos.add(new Grupo("video_juegos"));
      grupos.add(new Grupo("Lectura"));
		// Contactos
		contactos = new ArrayList<>();
		contactos.add(new Contacto("Luis","Vegeta.Dbz@gmail.com"));
		contactos.add(new Contacto("Maria","marimar@hotmail.com"));
		contactos.add(new Contacto("Paola","Cumbia.mix@yahoo.com.x"));
		contactos.add(new Contacto("Mariana","Poo.agregacio@gmail.com"));
		contactos.add(new Contacto("Samanta","corona@ipn.mx"));
		contactos.add(new Contacto("Rocio","tequila@gmail.com"));
		contactos.add(new Contacto("Raul","composicion@gmail.com"));
		contactos.add(new Contacto("Claudia","Nube.brillante@gmail.com"));
		contactos.add(new Contacto("Carmen","pozole.caliente@ipn.mx"));
		contactos.add(new Contacto("Ruben","navegante@gmail.com"));

		contactos.get(1).agregarGrupo(grupos.get(0));
		contactos.get(2).agregarGrupo(grupos.get(1));
		contactos.get(3).agregarGrupo(grupos.get(0));
		contactos.get(5).agregarGrupo(grupos.get(0));
		contactos.get(5).agregarGrupo(grupos.get(1));
		contactos.get(6).agregarGrupo(grupos.get(1));
		contactos.get(8).agregarGrupo(grupos.get(0));
		contactos.get(9).agregarGrupo(grupos.get(0));
		contactos.get(9).agregarGrupo(grupos.get(1));
	}

	public static void main(String[] args) {
		// Variables
		String rcv = "", nombre = "", correo = "";
		System.out.println(" # Cargando");
		new Agenda();
		int opcion = 0;
		do{
			opcion = mensajes.menuMain();
			switch(opcion){
				case 1:
					// Crear contacto
					nombre = mensajes.input("Introduzca el nombre");
					correo = mensajes.input("Introduzca el correo");
					contactos.add(new Contacto(nombre, correo));
					break;
				case 2:
					// Elegir contacto
					menuElegirContacto();
					break;
				case 3:
					mensajes.show("Bye.");
					System.out.println(" # Bye");
					break;
			}
		}while(opcion != 3);
	}

	public static void menuElegirContacto(){
		int opcion = 0;
		Object opciones[] = new Object[contactos.size()];
		for(int i = 0; i < contactos.size(); i++){
			if(i < 10)
				opciones[i] = "0"+i+".- "+contactos.get(i).getNombre()+" - "+contactos.get(i).getCorreo();
			else
				opciones[i] = i+".- "+contactos.get(i).getNombre()+" - "+contactos.get(i).getCorreo();
		}
		opcion = mensajes.submenuCustom(opciones, "Elige un contacto");
		contactoSelected = contactos.get(opcion);
		submenuContacto();
	}

	public static void submenuContacto(){
		int opcion = 0;
		opcion = mensajes.menuContacto(contactoSelected.toString()+"\n"+contactoSelected.getGrupos());
		System.out.println(" # "+opcion);
		switch(opcion){
			case 1:
				submenuGrupo();
				break;
			case 2:
				break;
		}
	}

	public static void submenuGrupo(){
		System.out.println(" # submenuGrupo");
		int opcionParent = 0, opcion;
		ArrayList<Grupo> temp = null;
		ArrayList<Grupo> noncont = new ArrayList<>();
		Object opciones[] = null;
		opcionParent = mensajes.menuGrupo();
		do{
			switch(opcionParent){
				case 1:
					// Salirse
					temp = contactoSelected.getGrupoArray();
					if(temp.size() != 0){
						opciones = new Object[temp.size()];
						for(int i = 0; i < temp.size(); i++){
							if(i < 10)
								opciones[i] = "0"+i+".- "+temp.get(i).getNombre();
							else
								opciones[i] = i+".- "+temp.get(i).getNombre();
						}
						opcion = mensajes.submenuCustom(opciones, "Elige un grupo para salirte");
						contactoSelected.salirGrupo(opcion);
					}else{
						mensajes.show("No estas ningun grupos");
					}
					submenuContacto();
					break;
				case 2:
					// Unirse
					temp = contactoSelected.getGrupoArray();
					if(temp.size() == grupos.size())
						mensajes.show("Ya estas en todos los grupos");
					else{
						for(Grupo g : grupos){
							if(!temp.contains(g)){
								noncont.add(g);
							}
						}
					}
					opciones = new Object[noncont.size()];
					for(int i = 0; i < noncont.size(); i++){
						if(i < 10)
							opciones[i] = "0"+i+".- "+noncont.get(i).getNombre();
						else
							opciones[i] = i+".- "+noncont.get(i).getNombre();
					}
					opcion = mensajes.submenuCustom(opciones, "Elige un grupo para unirte");
					contactoSelected.agregarGrupo(noncont.get(opcion));
					submenuContacto();
					break;
			}
		}while(opcionParent != -1);
	}
}
