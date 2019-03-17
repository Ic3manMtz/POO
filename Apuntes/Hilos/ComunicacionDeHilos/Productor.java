public class Productor implements Runnable{
	private Thread hilo;
	private Q q;

	public Productor(Q q){
		this.q = q;
		hilo = new Thread(this,"Productor");
	}

	public void start(){
		hilo.start();
	}

	public void run(){
		int n = 0;

		while(true){
			q.put(n);
			n++;
			if(n == 10){
				break;
			}
		}
	}

	public void setPriority(int p){
		hilo.setPriority(p);
	}

}