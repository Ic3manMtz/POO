public class EstudiaYTrabaja extends Alumno implements ITrabajador{
	
	// como las interfaces no pueden tener atributos se los asignamos en esta clase.
	private double sueldo;
	private String numeroSeguro;
	private String rfc;
	private double extra;

	public EstudiaYTrabaja(){
		this(" ",0," ",0.0,0.0," "," ");
	}

	public EstudiaYTrabaja(String nombre,int edad,String boleta,double promedio,double sueldo,String numeroSeguro,String rfc){
		super(nombre,edad,boleta,promedio);
		this.sueldo = sueldo;
		this.numeroSeguro = numeroSeguro;
		this.rfc = rfc;
		extra = 0.0;
	}

	public EstudiaYTrabaja(EstudiaYTrabaja eyt){
		super(eyt);
		sueldo = eyt.sueldo;
		numeroSeguro = eyt.numeroSeguro;
		rfc = eyt.rfc;
	}

	public void destruir(){
		super.destruir();
		numeroSeguro = null;
		rfc = null;
		System.gc();
	}

	public String toString(){
		return super.toString() + " Sueldo: " + sueldo + "\n" + " numeroSeguro: " + numeroSeguro + "\n" + " rfc: " + rfc + "\n";
	}

	public boolean equals(Object obj){
		if( obj == null || !( obj instanceof EstudiaYTrabaja ) ){
			return false;
		}
		EstudiaYTrabaja eyt = (EstudiaYTrabaja)obj;

		return super.equals(eyt) && sueldo == eyt.sueldo && numeroSeguro.equals(eyt.numeroSeguro) && rfc.equals(eyt.rfc);
	}

	public void trabajar(){
		System.out.println("Trabajando ");
	}

	public void trabajar(int horasExtra){
		trabajar();
		System.out.println("horas extra: " + horasExtra);
		extra = ((sueldo / 30) / 8) * (horasExtra * 1.73);
	}

	public double cobrar(){
		return sueldo + extra;
	}
}