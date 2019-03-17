import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
	private ArrayList <Sayajin> sayajines;
	private Scanner sc;
	
	public Menu(){
		sayajines = new ArrayList<>();
		//int ki,int base,String nombre,int fase
		sayajines.add(new Sayajin(5000,5000,"Goku",0));
		sayajines.add(new Sayajin(4800,4800,"Vegeta",0));
		sayajines.add(new Sayajin(4000,4000,"Gohan",0));
		sc = new Scanner(System.in);
	}

	//sc.nextLine()

    public void menuPrincipal(){
    	String resp;
    	int opc;

        do{        
		System.out.println("\tMenu de sayajines disponibles\n");
		System.out.println("1."+sayajines.get(0).toString());
		System.out.println("2."+sayajines.get(1).toString());
		System.out.println("3."+sayajines.get(2).toString());
		System.out.println("4.Salir");
		
		resp = sc.nextLine();
		opc = Integer.parseInt(resp);
		
		if(opc != 4){ menuSecundario(opc); }

        }while(!"4".equals(resp));

    }

    public void menuSecundario(int opc){
    	String resp;

        do{        
		System.out.println("\n\tMenu de acciones disponibles para "+sayajines.get(opc-1).getNombre()+"\n");
		System.out.println("1.Transformar");
		System.out.println("2.Fusion");
		System.out.println("3.Salir");
		resp = sc.nextLine();

		if("1".equals(resp)){ menuTransformacion(opc); }
		if("2".equals(resp)){ menuFusion(opc); }		
        }while(!"3".equals(resp));   	
    }

	// toString nombre + "   Fase-" + fase + "   Nivel de Poder: " + base;

    public void menuTransformacion(int opc){
    	String resp;

    	System.out.println("\nTu Sayajin " + sayajines.get(opc-1).toString());
    	System.out.println("\nA que nivel va a transformar su Sayajin? ");
    	System.out.println("(Fases disponibles 0,1,2,3,4)");
    	resp = sc.nextLine();

    	System.out.println("El poder actual de tu Sayajin...."+sayajines.get(opc-1).getBase());
    	System.out.println(".....transformando.....");
    	sayajines.get(opc-1).transformar(Integer.parseInt(resp));
    	sayajines.get(opc-1).visor();
    }

    public void menuFusion(int opc){
    	Sayajin potara;
    	String resp;
    	int s;

    	potara = new Sayajin();

    	if(opc == 1){
    		System.out.println("\tTu Sayajin actual es: "+sayajines.get(opc-1).getNombre());
    		System.out.println("\nElije al Sayajin con el lo quieres fusionar:");
    		System.out.println("1."+sayajines.get(1).getNombre());
    		System.out.println("2."+sayajines.get(2).getNombre());
    		resp = sc.nextLine();
    		s = Integer.parseInt(resp);

    		potara = sayajines.get(opc-1).fusionar(sayajines.get(s));
    		System.out.println("Fusion "+potara.toString());
    	}

    	if(opc == 2){
    		System.out.println("\tTu Sayajin actual es: "+sayajines.get(opc-1).getNombre());
    		System.out.println("Elije al Sayajin con el lo quieres fusionar:");
    		System.out.println("1."+sayajines.get(0).getNombre());
    		System.out.println("2."+sayajines.get(2).getNombre());
    		resp = sc.nextLine();
    		s = Integer.parseInt(resp);

    		potara = sayajines.get(opc-1).fusionar(sayajines.get(s));
    		System.out.println("Fusion "+potara.toString());
    	}

    	if(opc == 3){
    		System.out.println("\tTu Sayajin actual es: "+sayajines.get(opc-1).getNombre());
    		System.out.println("Elije al Sayajin con el lo quieres fusionar:");
    		System.out.println("1."+sayajines.get(0).getNombre());
    		System.out.println("2."+sayajines.get(1).getNombre());
    		resp = sc.nextLine();
    		s = Integer.parseInt(resp);

    		potara = sayajines.get(opc-1).fusionar(sayajines.get(s));
    		System.out.println("Fusion "+potara.toString());
    	}
    }
}