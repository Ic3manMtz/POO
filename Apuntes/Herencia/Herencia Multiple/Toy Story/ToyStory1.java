//clase ToyStory1

public class ToyStory1{
	public static void main(String[] args) {
		ToyStory ts1 = new ToyStory("ToyStory",1.21);

		System.out.println(ts1.toString());

		ts1.jugar("Lejano Oeste");
		ts1.jugar(3);
		ts1.dejarJugar();
		ts1.desarmar("ojo");
		ts1.actuar();
		ts1.enojar();
		ts1.cuidarUniverso();
		ts1.lastimar(1);
		System.out.println("con " + ts1.lanzarObjetos() + " pelotitas");
		ts1.destruir();
		ts1.volar();
	}
}