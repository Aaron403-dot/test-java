import java.util.EmptyStackException;

public class Empleado {
	
	private String Nombre;
	private int Edad;
	private double Salario;
	
	public Empleado(String nombre, int edad, double salario) {
		if(salario>0){
			Salario = salario;
			Nombre = nombre;
			Edad = edad;
		}
		else {
			System.err.println("no se puede generar un empleado sin salario");
			throw new EmptyStackException();
		}
	}


	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public double getSalario() {
		return Salario;
	}

	public void setSalario(double salario) {
		Salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [Nombre=" + Nombre + ", Edad=" + Edad + ", Salario=" + Salario + "]";
	}
	
	
	
}
