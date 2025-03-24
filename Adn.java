
import java.util.Scanner;




public class Adn{
	
	//Adverecnia solo puede haber un main por projecto en pocas palabras no hagais estas practicas de normal

	public static void main(String[] args){
		
		int _COUNT_A=0;
		int _COUNT_G=0;
		int _COUNT_C=0;
		int _COUNT_T=0;

		String ADN = "ATCGATTGAGCTCTAGCG";
		if (ADN.length() % 3 == 0 && ADN.startsWith("ATG") && ADN.endsWith("TGA")) {
			System.out.println("es una proteina");
		}
		else{
			System.out.println("no es una proteina");
		}

		for (int i = 0; i < ADN.length(); i++) {
			/*if (ADN.charAt(i) == 'A') {
			 	_COUNT_A++;
			 }
			 if (ADN.charAt(i) == 'G') {
			 	_COUNT_G++;
			 }
			 if (ADN.charAt(i) == 'C') {
			 	_COUNT_C++;
			 }
			 if (ADN.charAt(i) == 'T') {
				_COUNT_T++;
			}*/

			switch (ADN.charAt(i)) {
					case 'A' -> _COUNT_A++;
					
					case 'G' -> _COUNT_G++;

					case 'C' -> _COUNT_C++;
					
					case 'T' -> _COUNT_T++;
				
				default -> throw new AssertionError();
			}
		
		}

		AdnEJ2();

		System.out.println("Hay " + _COUNT_A + " de Adenina");
		System.out.println("Hay " + _COUNT_C + " de Citocina");
		System.out.println("Hay " + _COUNT_G + " de Guanina");
		System.out.println("Hay " + _COUNT_T + " de Tinina");

		System.out.println("-----------------------------\nEjercico de FizzBuzz\n");

		for (int i = 1; i <= 100; i++) {
			String FB = "";
			if (i % 3 == 0) {
				FB += "FIZZ";
			}
			if (i % 5 == 0) {
				FB += "BUZZ";
			}
			if(!"".equals(FB))
			{
				System.out.println(FB);
			}
			else{
				System.out.println(i);
			}
		}

		EjercicioPrint01();
		EjercicioPrint02();
		EjercicioPrint03();
		System.out.println("----------Ejercios de variable--------");
		System.out.println("------------Avanzado-------------");
		ejercicoAvanzadoVar();
		System.out.println("----------- medio ----------------");
		EjerccioIntermedio();

	}
	
	public static void EjercicioPrint01(){
		System.out.println("Hello world");
	}

	public static void EjercicioPrint02(){
		System.out.println("Estoy aprendiendo a programar\ny lo voy a conseguir.");
	}

	public static void EjercicioPrint03(){
		System.out.print("Estoy aprendiendo a programar ");
		System.out.print("y lo voy a conseguir.");

	}

	public static void AdnEJ2() {

		String ADN1 = "ATGCGATACGCTTGA";
		String ADN2 = "ATGCGATACGTGA";
		String ADN3 = "ATTAATATGTACTGA";

		System.out.println(calculoAdn(ADN1));
		System.out.println(calculoAdn(ADN2));
		System.out.println(calculoAdn(ADN3));


	}

	public static String calculoAdn(String Adn){

		String Positivo;

		if (Adn.length() % 3 == 0 && Adn.startsWith("ATG") && Adn.endsWith("TGA")) {
			System.out.println("es una proteina");
			Positivo = Adn;
			return "la cadena \"" + Positivo + "\" es una proteina";
		}
		else{
			System.out.println("no es una proteina");
			return "la cadena \"" + Adn + "\" no es una proteina";
		}

		
	}

	public static void ejercicoAvanzadoVar(){
            try (Scanner _In_numero = new Scanner(System.in)) {
                System.out.println("Introduzca un numero double [es decir un numero con decimal]");
                String _varNumDec = _In_numero.nextLine();
                double _DVNumDec =  Double.parseDouble(_varNumDec);
                System.out.println(_DVNumDec);
                int _IDVNumDec = (int)_DVNumDec;
                System.out.println(_IDVNumDec + "\n------------\nparte 2 ej avanzado");
                
                //aun que de base no se puede hacer se puede hacer una micro operacion que trare true como 1 y false como 0 ya que aun que boolean deberia ser 1 o 0 se le suele tratar como u valor distinto
                boolean _added = true;
                int _Numeric = 1;
                _Numeric += _added ? 1 : 0;
                System.out.println(_Numeric);
                
                //convercion de double a byte
                System.out.println("Numero double: " + _DVNumDec);
                byte _bVNumDec = (byte)_DVNumDec;
                System.out.println("Numero byte: " +_bVNumDec);
                //Conversion float a int
                
                float FNumber = 123.23f;
                System.out.println("Valor del número float: " + FNumber);
                System.out.println("Valor del número redondeado: " + Math.round(FNumber));
                int INumber = (int) Math.round(FNumber);
                System.out.println("Valor del número convertido a int: " + INumber);
                
                //Conversor de temperatura
                System.out.println("Introduzca una temperatura (En Celcius):");
                String TempCels = _In_numero.nextLine();
                
                double DoubleCel =  Double.parseDouble(TempCels);
                System.out.println("Celsius: " + DoubleCel);
                // (°C × 9/5) + 32
                System.out.println("Fahrenheit: " + (DoubleCel * 9/5)+32);
                
                System.out.println("Kelvin: " + (DoubleCel + 273.15));
            }
			catch(Exception e){
				System.out.println("Introduzca un input valido");
			}
	}

	public static void EjerccioIntermedio(){
		System.out.println("EJERCICIO 1:");
			int IPVariable1 = 24;
			double DPVaribale2 = 23.4;
			System.out.println(IPVariable1 + DPVaribale2);
		System.out.println("EJERCICIO 2:");
			String SPVariable3 = "igual tienes que hacer alguna transformaciónes a :";
			SPVariable3 += IPVariable1+"";
			System.out.println(SPVariable3);
		System.out.println("EJERCICIO 3:");
			char CPVariable4 = 'Q';
			System.out.println(IPVariable1 + CPVariable4);
		System.out.println("EJERCICIO 4:");
			byte BPVariable5 = 127;
			byte RBPVariable5 = BPVariable5++;
			System.out.println(RBPVariable5);
			System.out.println("no añade nada por que el limite de byte es 127");
		System.out.println("EJERCICIO 5:");
			long LPVariable = Long.MAX_VALUE;
			System.out.println( (int) LPVariable);
			System.out.println("Overflow = -1");
		}

}