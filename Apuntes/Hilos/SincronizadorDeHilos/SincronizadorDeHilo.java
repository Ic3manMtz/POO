//clase principal

public class SincronizadorDeHilo{
	public static void main(String[] args) {
		Llamame destino = new Llamame();
		ElQueLlama hola = new ElQueLlama(destino,"Hola");
		ElQueLlama mundo = new ElQueLlama(destino,"mundo");
		ElQueLlama java = new ElQueLlama(destino,"java");

		hola.start();
		mundo.start();
		java.start();

//		try{
			hola.join();
			mundo.join();
			java.join();
//		}catch(InterruptedException ie){
//			ie.printStackTrace();
//		}
	}
}