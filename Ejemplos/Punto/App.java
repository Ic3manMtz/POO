public class App{
	public static void main(String[] args) {
		Punto p1 = new Punto();
		p1.setX(5);
		p1.setY(3);
		System.out.println("["+p1.getX()+","+p1.getY()+"]");
		Punto p2 = new Punto();
		System.out.println("Distancia entre p1 y p2 "+p1.distancia(p2));
	}
}