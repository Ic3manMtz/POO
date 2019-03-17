public class Consumidor implements Runnable{
	private Thread hilo;
	private Q q;

	public Consumidor(Q q){
		this.q = q;
		hilo = new Thread(this,"Consumidor");
	}

	public void start(){
		hilo.start();
	}

	public void run(){
		int n = 0;

		while(true){
			n++;
			q.get();
			if(n == 10){
				break;
			}
		}
	}

	public void setPriority(int p){
		hilo.setPriority(p);
	}
}