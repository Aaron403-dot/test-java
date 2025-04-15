
public class EmpleadoTiempoCompleto extends Empleado {
	
	private double bonoAnual;
	
	public EmpleadoTiempoCompleto(String nombre, int edad, double salario,double bonoanual) {
		super(nombre, edad, salario);
		bonoAnual = bonoanual;
		// TODO Auto-generated constructor stub
	}


	public double getBonoAnual() {
		return bonoAnual;
	}

	public void setBonoAnual(double bonoAnual) {
		this.bonoAnual = bonoAnual;
	}
	
	public double calcularSalario(){
		double cambioADia = getSalario() / 40;
		double cambioAHora = cambioADia / 8;
		double totalConBonus = bonoAnual + getSalario();
		System.out.println("de normal cobra:" );
		System.out.println(cambioAHora + " Por horas");
		System.out.println(cambioADia + " Por Dia");
		return totalConBonus;
	}
	
	@Override
	public String toString() {
		return "EmpleadoTiempoCompleto [bonoAnual=" + bonoAnual + ", getNombre()=" + getNombre() + ", getEdad()="
				+ getEdad() + ", getSalario()=" + getSalario() + "]";
	}
	
	
	
}
