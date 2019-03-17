import java.util.ArrayList;

public class App{
   public static void main(String[] args) {
      ArrayList<Producto> catalogo = new ArrayList<Producto>();

      catalogo.add(new Producto("Gansito",9.8,21,"Panque con chocolate",1));
      catalogo.add(new Producto("Sabritas",12,30,"Papas fritas",2));
      catalogo.add(new Producto("6 latas indio",96,40,"Latas de 400ml",3));
      catalogo.add(new Producto("Paketaxo Queso",37.90,19,"Botana 215g",4));
      catalogo.add(new Producto("Ciel mineral",22.50,65,"Mineralizada 2L",5));
      catalogo.add(new Producto("Vino tinto",125,13,"Las moras 750ml",6));
      catalogo.add(new Producto("Pan integral",34.50,28,"Wonder 567g",7));
      catalogo.add(new Producto("Servilletas",77,54,"Kleenex Class 200pzas",8));
      catalogo.add(new Producto("Queso Manchego",59.50,68,"Lala 400g",9));
      catalogo.add(new Producto("Choco Krispis",41.80,32,"Kellog's 450g",10));

      GUI gui = new GUI(catalogo);
      gui.menuPrincipal();
   }
}
