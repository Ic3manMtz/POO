/*
clase recurso compartido
*/
public class Llamame{
//	public synchronized 
public	void llamar(String mensaje){  //forma 1 de sincronizar
		try{
			System.out.print("[" + mensaje);
			Thread.sleep(1000);
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println("]");
	}
}