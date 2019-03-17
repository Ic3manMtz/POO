package Agenda;

import java.util.ArrayList;

public class Contacto{
   private String nombre;
   private String correo;
   private ArrayList<Grupo> grupos;

   public Contacto(String nombre,String correo){
      this.nombre = nombre;
      this.correo = correo;
      grupos = new ArrayList<>();
   }

   public void setNombre(String nombre){
      this.nombre = nombre;
   }

   public void setCorreo(String correo){
      this.correo = correo;
   }

   public String getNombre(){
      return nombre;
   }

   public String getCorreo(){
      return correo;
   }

   public void agregarGrupo(Grupo g){
      grupos.add(g);
   }

   public void salirGrupo(int index){
      grupos.remove(index);
   }

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + "\n correo=" + correo+"]";
	}

   public String getGrupos(){
      String cadena = "";

      for(int i = 0;i < grupos.size();i++){
         cadena += grupos.get(i).getNombre()+"-";
      }

      return cadena;
   }

   public ArrayList<Grupo> getGrupoArray(){
      return grupos;
   }
}
