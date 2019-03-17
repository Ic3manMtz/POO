import java.util.Arrays;

public class Sayajin{
	private int ki;
	private int base;
	private String nombre;
	private int fase;

	public Sayajin(){
		this(0,0,"",0);
	}

	public Sayajin(int ki,int base,String nombre,int fase){
		this.ki = ki;
		this.base = base;
		this.nombre = nombre;
		this.fase = fase;
	}

	public String getNombre(){ return nombre; }
	public void setNombre(String nombre){ this.nombre = nombre; }

	public int getKi(){ return ki; }
	public void setKi(int ki){ this.ki = ki; }

	public int getBase(){ return base; }
	public void setBase(int base){ this.base = base; } 

	public int getFase(){ return fase; }
	public void setFase(int fase){ this.fase = fase; }

	@Override
	public String toString(){
		return nombre+"......Fase-"+fase+"\tKi-"+ki+"\t\tNivel base de poder:"+base;
	}

	public void visor(){
		System.out.println("El poder de pelea de tu Sayajin es......." + ki);
	}

	public void transformar(int fase){
		this.fase = fase;

		if(fase == 0){ ki = base; }
		if(fase == 1){ ki = base * 50; }
		if(fase == 2){ ki = base * 100; }
		if(fase == 3){ ki = base * 400; }
		if(fase == 4){ ki = base * 4000; }
	}

	public Sayajin fusionar(Sayajin s){
		Sayajin nvo = new Sayajin();

		nvo.setFase( fase + s.getFase() );
		nvo.setBase( base + s.getBase() );
		nvo.setKi( ki + s.getKi() );
		nvo.setNombre( nombre.substring(0,(nombre.length()/2)) + s.getNombre().substring( (s.getNombre().length()/2),(s.getNombre().length()) ) );

		return nvo;
	}
}