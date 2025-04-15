
public class EmpleadoPorHoras extends Empleado {
	
	private double eurosHora;
	private int horasMensuales;
	
	public EmpleadoPorHoras(String nombre, int edad,double euroshora,int horasmensuales) {
		super(nombre, edad, 1);
		// TODO Auto-generated constructor stub
		eurosHora = euroshora;
		horasMensuales = horasmensuales;
		setSalario(calcularSalario());
	}

	public double getEurosHora() {
		return eurosHora;
	}

	public void setEurosHora(double eurosHora) {
		this.eurosHora = eurosHora;
	}

	public int getHorasMensuales() {
		return horasMensuales;
	}

	public void setHorasMensuales(int horasMensuales) {
		this.horasMensuales = horasMensuales;
	}

	public double calcularSalario(){
		double salarioHorasMes = eurosHora * horasMensuales;
		System.out.println(eurosHora + ": por horas");
		System.out.println(horasMensuales + ": cuanto suele trabajar mensualmente");
		return salarioHorasMes;
		
	}
	
	@Override
	public String toString() {
		return "EmpleadoPorHoras [eurosHora=" + eurosHora + ", horasMensuales=" + horasMensuales + ", getNombre()="
				+ getNombre() + ", getEdad()=" + getEdad() + ", getSalario()=" + getSalario() + "]";
	}
	
	
	
}
