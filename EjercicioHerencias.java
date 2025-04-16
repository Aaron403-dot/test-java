import java.util.ArrayList;
import java.util.Collections;

public class EjercicioHerencias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpleadoTiempoCompleto empleado = new EmpleadoTiempoCompleto("Pablo", 35, 1800.0, 1800.0);
		EmpleadoTiempoParcial becario = new EmpleadoTiempoParcial("Juan", 21, 1800.0, 350);
		EmpleadoPorHoras contartado = new EmpleadoPorHoras("Jorge", 40, 8.5, 200);
		EmpleadoTiempoCompleto empleado2 = new EmpleadoTiempoCompleto("Paolo", 75, 1800.0, 1800.0);
		EmpleadoTiempoParcial becario2 = new EmpleadoTiempoParcial("Raquel", 27, 1800.0, 350);
		EmpleadoPorHoras contartado2 = new EmpleadoPorHoras("Maria", 19, 8.5, 200);
		ArrayList<Empleado> Empresa = new ArrayList<>();
		Empresa.add(becario2);
		Empresa.add(contartado2);
		Empresa.add(empleado2);
		Empresa.add(becario);
		Empresa.add(contartado);
		Empresa.add(empleado);
		int suma = 0;
		for (Empleado empleado3 : Empresa) {
			suma += empleado3.getEdad();
		}
		int media = suma / Empresa.size();
		Empresa.sort((e1,e2) -> e1.compareTo(e2));
		System.out.println("La media de la edad es de: " + media);
		System.out.println(empleado.toString());
		System.out.println(empleado.calcularSalario() + ": Salario Absoluto");
		System.out.println(becario.calcularSalario(12) + ": Salario con bonus");
		System.out.println(becario.toString());
		if(becario.getHorasTrabajadas()>=350){
			System.out.println("se le acabo el tiempo de practicas");
		}
		
		System.out.println(contartado.toString());
		for (Empleado empleado3 : Empresa) {
			System.out.println("Nombre: " + empleado3.getNombre());
			System.out.println("Edad: " + empleado3.getEdad());
		}
	}

}
