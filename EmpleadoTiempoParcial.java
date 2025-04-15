
public class EmpleadoTiempoParcial extends Empleado {
	
	private int horasTrabajadas;
	
	public EmpleadoTiempoParcial(String nombre, int edad, double salario, int horastabajadas) {
		super(nombre, edad, salario);
		horasTrabajadas = horastabajadas;
		// TODO Auto-generated constructor stub
	}


	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public double calcularSalario(int horasExtras){
		double cambioADia = getSalario() / 40;
		double cambioAHora = cambioADia / 8;
		double totalConExtra = getSalario();
		System.out.println("de normal cobra:" );
		System.out.println(cambioADia/8 + " Por horas");
		System.out.println(cambioADia + " Por Dia");
		if(horasExtras>0){
			totalConExtra += cambioAHora * horasExtras;
		}
		return totalConExtra;
	}

	@Override
	public String toString() {
		return "EmpleadoTiempoParcial [horasTrabajadas=" + horasTrabajadas + ", getNombre()=" + getNombre()
				+ ", getEdad()=" + getEdad() + ", getSalario()=" + getSalario() + "]";
	}
	
	
	
}
