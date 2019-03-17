//clase ToyStory
import java.util.Random;

public class ToyStory extends Object implements IAl,IAndy,ISid,ILotzo,IAmigo,IZurg{
	private String nombre;
	private double duracion;
	private int ahorro;

	public ToyStory(){
		this(" ",0.0);
	}

	public ToyStory(String nombre,double duracion){
		this.nombre = nombre;
		this.duracion = duracion;
		ahorro = 0;
	}

	public ToyStory(ToyStory ts){
		nombre = ts.nombre;
		duracion = ts.duracion;
	}

	public void destructor(){
		nombre = null;
		System.gc();
	}

	public String toString(){
		return " Nombre de la pelicula: " + nombre + "\n" + " Duracion de la pelicula: " + duracion + "\n";
	}

	public boolean equals(Object obj){
		if( obj == null || !( obj instanceof ToyStory ) ){
			return false;
		}

		ToyStory ts = (ToyStory)obj;

		return nombre.equals(ts.nombre) && duracion == ts.duracion;
	}

	public void coleccionar(){
		System.out.println("¡Dedo tener todo listo para japon! \n");
	}

	public void hablar(String oracion){
		System.out.println("--" + oracion + "\n");
	}

	public void vender(){
		System.out.println("¡Bienvenidos a Al's Toy Barn! \n");
	}

	public void jugar(String tema){
		System.out.println("Ahora jugare que estoy al " + tema + "\n");
	}

	public void destruir(){
		System.out.println("Ahora destruire mis juguetes antes que se rebelen ¡jajajajajaja! \n");
	}

	public void lastimar( int selector ){
		String soy = "";
		if( selector==1 ) {
			soy = IZurg.QUIEN_SOY;
		}
		System.out.println( soy + ": ¡Los destruire a todos! \n");
	}

	public void jugar(int horas){
		System.out.println("Jugare por: " + horas + "hrs" +"\n");
	}

	public String dictar(){
		return "Todo es alegria en Sunnyside \n ";
	}

	public void abrazar(String aQuien){
		System.out.println("Abrazando a " + aQuien + "\n" );
	}

	public void apoyar(){
		System.out.println("Apoyando :D \n");
	}

	public void ayudar(){
		System.out.println("Ayudando :v \n");
	}

	public void montarACaballo(){
		System.out.println("Montando a Tiro Al Blanco \n");
	}

	public void dejarJugar(){
		System.out.println("Te estoy permitiendo jugar conmigo por que somos amigos \n");
	}

	public void cuidarUniverso(){
		System.out.println("Aaaaal infinito y maaaas allaaaaa \n");
	}

	public void volar(){
		System.out.println("Estoy cayendo con estilo \n");
	}

	public void desarmar(String pieza){
		System.out.println("Ooooo se me cayo mi " + pieza + "\n");
	}

	public void enojar(){
		System.out.println("Maldita sea, eso no es buena idea \n");
	}

	public int lanzarObjetos(){
		Random rand = new Random();
		int  n = rand.nextInt(50) + 1;

		return n;
	}

	public void ahorrar(int monedas){
		ahorro += monedas;
	}

	public void actuar(){
		System.out.println("Ahora soy alguien que no soy yo jajaja \n");
	}


}