public class App{
	public static void main(String[] args) {
		Punto p1 = new Punto(Interaccion.preguntar(0),Interaccion.preguntar(1));
		Punto p2 = new Punto();
		Interaccion.mostrar(p1.distancia(p2));
		Punto p3 = new Punto(p1);
		Interaccion.mostrar(p3);
	}
}
