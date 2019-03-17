
public class Persona extends Object{
	private String nombre;
	private int edad;

	public Persona(){
		this( " ",0 );
	}

	public Persona ( String nombre,int edad ){
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona ( Persona p ){
		this( p.nombre,p.edad );
	}

	public void destruir(){
		nombre = null;
		System.gc();
	}

	public void setPersona( String nombre,int edad ){
		this.nombre = nombre;
		this.edad = edad;
	}

	public String toString(){
		return "Nombre: " + nombre + " Edad: " + edad + "\n";
	}

	public boolean equals( Object obj ){
		if ( obj == null || !( obj instanceof Persona ) ){
			return false;
		}

		Persona p =(Persona)obj;
		return nombre.equals( p.nombre ) && edad == p.edad;
	}

	public void dormir(){
		System.out.println("zzzzzz");
	}

	public void dormir( String donde ){
		System.out.println("Durmiendo en: " + donde);
	}
}
