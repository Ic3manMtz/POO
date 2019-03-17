public class Punto{
	private int x;
	private int y;

	public Punto(){
		x = 10;
		y = 10;
	}

	public Punto(int x,int y){
		this.x = x;
		this.y = y;
	}

	public Punto(Punto p){
		x = p.x;
		y = p.y;
	}

	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public void setY(int y){
		this.y = y;
	}

	public double distancia(Punto p2){
		return Math.sqrt( ((p2.x - x)*(p2.x - x)) + ((p2.y - y)*(p2.y - y)) );
	}

	public String imprimir(){
		return "[" + x + "," + y + "]";
	}
}
