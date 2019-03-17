public class Nacimiento{
	public static void main(String[] args) {
		Alumno maria = new Alumno( "Maria Gomez" ,19,"2015630270",8.4 );

		maria.dormir();
		maria.dormir("sofa");
		maria.dormir("cama",8);

		maria.estudiar("Digitales",1);

		System.out.println("maria");

		Alumno pedro = new Alumno( "pedro",20,"awdasd",5.2 );

		System.out.println(maria.equals(pedro));

		maria.destruir();
		maria = null;

		pedro.destruir();
		pedro = null;

		System.gc();
	}
}