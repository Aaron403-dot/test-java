import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Random;

public class NotasEstadisticas {


    public static void main(String[] args) {
        NotasEstadisticas NE = new NotasEstadisticas();
        String[][] academia;
        int[] CadenaDeNotas;
        academia = NE.GenerarAlumnos(args[0]);
        CadenaDeNotas = NE.leerNotas(1, academia);
        NE.Estadisticas(CadenaDeNotas);
        NE.Histograma(CadenaDeNotas);
    }


    private String[][] GenerarAlumnos(String value)
    {
        try {
            int alumnosAgenerar;
            if (esNumero(value)) {
            alumnosAgenerar = Integer.parseInt(value);
            }else{
                return null;
            }
            String[][] caja2D = new String[alumnosAgenerar][10];
            Random r = new Random();
            for (int i = 0; i < alumnosAgenerar; i++) {
                caja2D[i][0] = i+"";
                for (int j = 0; j < 10; j++) {
                    caja2D[i][j] = r.nextInt(0, 10)+"";
                }
            }
            return caja2D;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private int[] leerNotas(int seleccion, String[][] Alumnos)
    {
        System.out.println("el alumno: " + seleccion + "ha sacado de notas");
        // Alumnos[seleccion][]
        int[] TNotas = new int[Alumnos.length];
        for (int i = 0; i < Alumnos.length; i++) {
            if (Integer.parseInt(Alumnos[seleccion][i])>=9) {
                System.out.println(Alumnos[seleccion][i] + ": Sobresaliente");                
            }
            if (Integer.parseInt(Alumnos[seleccion][i])>=5 && Integer.parseInt(Alumnos[seleccion][i])<9) {
                System.out.println(Alumnos[seleccion][i] + ": Aprobado");                
            }
            if (Integer.parseInt(Alumnos[seleccion][i])<5) {
                System.out.println(Alumnos[seleccion][i] + ": Suspendido");                
            }
            TNotas[i] = Integer.parseInt(Alumnos[seleccion][i]);
        }
        Arrays.sort(TNotas);
        return TNotas;
    }

    private void Estadisticas(int[] TNotas)
    {
        System.out.println("La nota mas alta es: " + TNotas[9]);
        System.out.println("La nota mas baja es: " + TNotas[0]);
        int Promedia;
        int suma = 0;
        for (int e : TNotas) {
            suma +=e;
        }
        Promedia = suma / TNotas.length;
        System.out.println("La promedia es de: " + Promedia);
    }

    private void Histograma(int[] TNotas)
    {
        int[] Contador = new int[10];
        for (int N : TNotas) {
            Contador[N]++;
            if (N !=0 ) {
                Contador[N-1]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("El alumno a sacado " + i + " - "+ (i+1) + ": " + GenerarAsteriscos(Contador[i]));
        }

    }

    public static boolean esNumero(String NumOLet)
    {
        //Declara la posicion del Analicis de checkeo
        ParsePosition Lugar = new ParsePosition(0);
        //saca la instalcia del formato de numero y analiza el lugar
        NumberFormat.getInstance().parse(NumOLet,Lugar);
        //Positivo si el tamaño del lugar es igual a la posicion actual del analizador
        return NumOLet.length() == Lugar.getIndex();
    }

    private String GenerarAsteriscos(int GA)
    {
        String Asteriscos = " | " + "*".repeat(GA);
        return Asteriscos;
    }
}
