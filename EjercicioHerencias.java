
public class EjercicioHerencias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpleadoTiempoCompleto empleado = new EmpleadoTiempoCompleto("Pablo", 35, 1800.0, 1800.0);
		EmpleadoTiempoParcial becario = new EmpleadoTiempoParcial("Juan", 21, 1800.0, 350);
		EmpleadoPorHoras contartado = new EmpleadoPorHoras("Jorge", 40, 8.5, 200);
		System.out.println(empleado.toString());
		System.out.println(empleado.calcularSalario() + ": Salario Absoluto");
		System.out.println(becario.calcularSalario(12) + ": Salario con bonus");
		System.out.println(becario.toString());
		if(becario.getHorasTrabajadas()>=350){
			System.out.println("se le acabo el tiempo de practicas");
		}
		System.out.println(contartado.toString());
		
	}

}
