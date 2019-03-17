//clase principal CreadorDeHilo

public class CreadorDeHilo{
	public static void main(String [] args){
		int c = 10;

		Thread principal = Thread.currentThread();
		System.out.println(principal.getName());
		principal.setName("Principal");

		MiHilo hilo1 = new MiHilo(c,"Hilo 1");
		MiHilo hilo2 = new MiHilo(c,"Hilo 2");
		MiHilo hilo3 = new MiHilo(c,"Hilo 3");

		//setDaemon();

		hilo1.start();		hilo1.setPriority(2);
		hilo2.start();		hilo2.setPriority(4);
		hilo3.start();		hilo3.setPriority(8);
		
		try{
			for(int n = c;n >= 0;n--){
				System.out.println(n + ":" + principal.getName());
				principal.sleep(1000 * c * 3);
			}
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}
