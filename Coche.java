
public class Coche {
	
	private int Ventanas=4;
	private int Ruedas=4;
	private int Velocidad=0;
	private boolean Circulando=false;
	private boolean Arrancado=false;
	
	public Coche(int R, int Ven) {
		// TODO Auto-generated constructor stub
		Ruedas=R;
		Ventanas=Ven;
	}
	
	public int getRuedas() {
		return Ruedas;
	}
	public int getVelocidad() {
		return Velocidad;
	}
	public int getVentanas() {
		return Ventanas;
	}
	public boolean getArrancado(){
		return Arrancado;
	}
	public boolean getCirculando(){
		return Circulando;
	}
	
	public void Arrancar(){
		Arrancado = true;
	}
	
	public void Frenar(){
		Velocidad = 0;
		Arrancado = false;
	}
	
	public void Acelerar(){
		if (Arrancado) {
			Velocidad+=5;
			System.out.println("el coche esta llendo a " + Velocidad);
			Circulando = true;
		}
	}
	public void Decelerar(){
		if (Arrancado) {
			Velocidad-=5;
			if (Velocidad == 0) {
				Circulando = false;
			}else {
				System.out.println("el coche esta llendo a " + Velocidad);
			}
			
			
		}
	}
	
	
}
