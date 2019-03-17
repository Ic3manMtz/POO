//clase Hilo

public class ElQueLlama implements Runnable{
	private Thread hilo;
	private String mensaje;
	private Llamame destino;

	public ElQueLlama(Llamame destino,String mensaje){
		this.mensaje = mensaje;
		this.destino = destino;
		hilo = new Thread(this,"El que llama");
	}
	public void start(){
		hilo.start();
	}
	public void join(){
		try{
			hilo.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
	public void run(){
		// synchronized(destino){ forma 2 de sincronizar
		destino.llamar(mensaje);
		//}
	}
	
}