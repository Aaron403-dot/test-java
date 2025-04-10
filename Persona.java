
public class Persona extends Direccion {

	private String Nombre = "";
	private int Edad = 0;
	private double Peso = 0;
	
	public Persona(String N,int E,double P,String Ca,String Ci, int CPo) {
		// TODO Auto-generated constructor stub
		super(Ca,Ci,CPo);
		Nombre = N;
		Edad = E;
		Peso = P;
	}
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public int getEdad() {
		return Edad;
	}
	public String getNombre() {
		return Nombre;
	}
	public double getPeso() {
		return Peso;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: " + getNombre() + "\nEdad: " + getEdad() +"\nPeso: "+getPeso() + super.toString();
	}
}
