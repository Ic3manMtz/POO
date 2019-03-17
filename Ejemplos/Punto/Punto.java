public class Punto{
	private int x;
	private int y;

	public double distancia(Punto p2){
		return Math.sqrt( ((p2.x - x)*(p2.x - x)) + ((p2.y - y)*(p2.y - y)) );
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
}
