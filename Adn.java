


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
					case 'A' :
						_COUNT_A++;
					break;
					
					case 'G' :
						_COUNT_G++;
					break;

					case 'C' :
						_COUNT_C++;
					break;
					
					case 'T' :
						_COUNT_T++;
					break;
				default:
					throw new AssertionError();
			}
		
		}

		System.out.println("Hay " + _COUNT_A + " de Adenina");
		System.out.println("Hay " + _COUNT_C + " de Citocina");
		System.out.println("Hay " + _COUNT_G + " de Guanina");
		System.out.println("Hay " + _COUNT_T + " de Tinina");

		System.out.println("-----------------------------\nEjercico de FizzBuzz\n");

		for (int i = 1; i < 100; i++) {
			String FB = "";
			if (i % 3 == 0) {
				FB += "FIZZ";
			}
			if (i % 5 == 0) {
				FB += "BUZZ";
			}
			if(FB != "")
			{
				System.out.println(FB);
			}
			else{
				System.out.println(i);
			}
		}

	}
	
}