//recurso compartido

public class Q{
	private int valor;
	private boolean bandera;

	public Q(){
		bandera = false;
		valor = 0;
	}
	public synchronized int get(){
		
		if(!bandera){
			try{
				wait();
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
			System.out.println("Consumo: " + valor);
			notify();
			bandera = false;
			return valor;

	}

	public synchronized void put(int n){
		
		if(bandera){
			try{
				wait();
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
			valor = n;
			System.out.println("Produce: " + valor);
			bandera = true;
			notify();
	}


}