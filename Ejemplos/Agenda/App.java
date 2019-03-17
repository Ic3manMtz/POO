public class App{
	public static void main(String[] args) {
		Contacto c1 = new Contacto();
		c1.setNombre("Jorge");
		c1.setCorreo("correo@algo.com");
		c1.setTel(5544030717L);

		System.out.println(c1.toString());
	}
}