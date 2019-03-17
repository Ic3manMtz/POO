public class ComunicacionDeHilo{
	public static void main(String[] args) {
		Q recurso = new Q();

		Productor productor = new Productor(recurso);
		Consumidor consumidor = new Consumidor(recurso);

		productor.start();	productor.setPriority(2);
		consumidor.start(); consumidor.setPriority(10);
	}
}