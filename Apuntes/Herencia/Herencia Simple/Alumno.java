public class Alumno extends Persona{
	private String boleta;
	private double promedio;

	public Alumno(){
		this( "",0,"",0.0 );
	}

	public Alumno( String nombre,int edad,String boleta,double promedio ){
		super(nombre,edad);
		this.boleta = boleta;
		this.promedio = promedio;
	}

	public Alumno( Alumno al ){
		super(al);
		this.boleta = boleta;
		this.promedio = promedio;
	}

	public void destruir(){
		super.destruir();
		boleta = null;
		System.gc();
	}

	public void setAlumno( String nombre,int edad,String boleta,double promedio ){
		setPersona(nombre,edad);
		this.boleta = boleta;
		this.promedio = promedio;
	}

	public String toString(){
		return super.toString() + " Boleta";
	}

	public boolean equals( Object obj ){
		if ( obj == null || !(obj instanceof Alumno) ){
			return false;
		}
		Alumno al = (Alumno)obj;
		return super.equals(al) && boleta.equals(al.boleta) && promedio == al.promedio;
	}

	public void dormir( String donde,int horas ){
		dormir(donde);
		System.out.println(" horas : " + horas);
	}

	public void estudiar(){
		System.out.println(" Estudiando ");
	}

	public void estudiar( String ua ){
		estudiar();
		System.out.println(" de : " + ua);
	}

	public void estudiar( String ua,int horas ){
		estudiar(ua);
		System.out.println(" horas :" + horas);
	}
}