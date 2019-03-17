package Agenda;

import java.util.ArrayList;

public class Grupo{
   private ArrayList<Contacto> contactos;
   private String nombre;
   private static int idGrupo = 0;
   private int id;

   public Grupo(String nombre){
      this.nombre = nombre;
      this.id = idGrupo;
      idGrupo++;
   }

   public String getNombre(){
      return nombre;
   }

   public int getID(){
      return id;
   }
}
