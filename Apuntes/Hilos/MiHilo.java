//clase MiHilo

/*

public class MiHilo extends Thread{
	private int contador;
	private MiHilo(){
		this(10,"Mi hilo");
	}
	public MiHilo(int contador,String nombre){
		super(nombre);
		this.contador = contador;
	}
	public void run(){
		try{
			for(int n = contador;n >= 0;n--){
				System.out.println(n + ":" + getName());
				Thread.sleep(3000);
			}		
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}

*/


public class MiHilo extends Object implements Runnable{
	private Thread hilo;
	private int contador;
	public MiHilo(){
		this(10,"Mi hilo");
	}
	public MiHilo(int contador, String nombre){
		hilo = new Thread(this,nombre);
		this.contador = contador;
	}
	public void start(){
		hilo.start();
	}
	public void setPriority(int p){
		hilo.setPriority(p);
	}
	public int getPriority(){
		return hilo.getPriority();
	}
	public void run(){
		try{
			for(int n = contador;n >= 0;n--){
				System.out.println(n + ":" + hilo.getName());
				hilo.sleep(3000);
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}