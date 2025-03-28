import java.io.Console;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GestionDeVotacies {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionDeVotacies GDV = new GestionDeVotacies();
        Politico[] politicos = new Politico[3];
        GDV.menu(sc,politicos);

    }

    private void menu(Scanner sc,Politico[] politicos)
    {
        try {
            int ExitCode=0;
            boolean Validando=false;
            while (ExitCode > -1) {
                System.out.println("Buenos Dias Bienvenido a la Aplicacion Politica\n");
                System.out.println("Introduzca que desea hacer");
                System.out.println("[1]VOTAR [2]CONTAR [3]VALIDAR [4]GANADOR [5]POLITICOS [Q]SALIR [A]ADMIN");
                System.out.println("-----------------------------------------------------------------------------------");
                switch (sc.nextLine().toLowerCase()) {
                    case "1":
                            if (Validando) {
                                int eleccion = Votar(sc, politicos);
                                if (eleccion == -1) {
                                    break;
                                }else{
                                    politicos[eleccion].setVotos(
                                        politicos[eleccion].getVotos()+1
                                    );
                                }
                            }else{
                                System.out.println("actualmente se estan validando los votos");
                            }
                                
                        break;
                    case "2":
                               Contar(politicos); 
                        break;
                    case "3":
                                System.out.println("Esta a punto de empezar el calculo de validacion de los votos desea seguir");
                                System.out.println("Escriba \"Si\" si desea continuar escriba cualquier otra cosa si no");
                                if (sc.nextLine().equalsIgnoreCase("si")) {
                                    Validando = true;
                                    Calcular(politicos);
                                }
                        break;
                    case "4":
                                politicos[0].setGanadorª(Ganador(politicos));
                        break;
                    case "5":
                                presentacion(politicos);
                        break;
                    case "q":
                            ExitCode--;
                        break;
                    case "a":
                                
                        break;
                
                    default:
                        System.out.println("Valor no valido Introduzca un valor valido");
                        break;
                }

            }

        } catch (Exception e) {

        }
    }

    private int Votar(Scanner sc,Politico[] p)
    {
        try {
            int voto = 0;
            String validador = "";
            boolean lock=true;
            System.out.println("A quien deseas votar:");
            //loop que muestra los nombre de los candidatos check de complecion
            for (int i = 0; i < p.length; i++) {
                System.out.print("["+i+"]"+p[i].getNombre()+" ");
                if(!EleccionExceptions(p[i]).isBlank())
                {
                    throw new NoEleccionsException(EleccionExceptions(p[i]));
                }
            }
            //while de seleccion de numero de candidato null vote es 0 
            while (lock) {
                validador = sc.nextLine();
                if (!esNumero(validador)) {
                    System.err.println("Introduza un numero de los mostrados para votar por el politico");
                }else
                {
                    voto = Integer.parseInt(validador);
                    if (voto == 0) {
                        return -1;
                    }
                    if (voto>p.length || voto<0) {
                        System.err.println("Introduza un numero de los mostrados para votar por el politico");
                    }
                    else{
                        lock=false;
                    }
                }
            }

            return voto;

        } catch (NullPointerException e) {
            System.err.println("Actualmente no esta dsiponible esta funcion disculpe las molestias");
            System.err.println(e.getMessage());
            return -1;
        } catch (NoEleccionsException e){
            System.err.println(e.getMessage());
            return -1;
        }

    }

    private void Contar(Politico[] politicos){
        for (int i = 0; i < politicos.length; i++) {
            System.out.println(politicos[i].getNombre() + ": " + politicos[i].getVotos());
        }
        for (int i = 0; i < politicos.length; i++) {
            System.out.println(politicos[i].getVotos());
        }

    }

private void Calcular(Politico[] politicos){

    int total = 0;

    double porcentaje = 0.0;

    politicos = comparador(politicos);

    System.out.println(politicos[0].getNombre() + ": Tiene mas votos");
    System.out.println(politicos[2].getNombre() + ": Tiene menos votos");
    for (Politico p : politicos) {
        total =+ p.getVotos();
    }
    for (Politico p : politicos) {
        porcentaje = (p.getVotos()/total)*100;  
        System.out.println(p.getNombre() + " tiene actualmente: " + porcentaje + "% de votos"); 
    }
}

private boolean Ganador(Politico[] politicos)
{
    Calcular(politicos);
    if (politicos[0].getVotos() > politicos[1].getVotos()) {
        System.out.println("Y el nuevo presidente es: " + politicos[0].getNombre());
        return true;
    }
    else{
        System.out.println("parece que habra que habra que hacer un recuento");
        return false;
    }
}


private void presentacion(Politico[] politicos)
{
    for (Politico politico : politicos) {
        System.out.println("--------------");
        System.out.println("Nombre: " + politico.getNombre());
        System.out.println("Genero: " + politico.getGenero());
        System.out.println("Afiliacion: " + politico.getAfiliacionPolitica());
        System.out.println(politico.getAfiliacionPolitica().toString());
        System.out.println("--------------");
    }
}


/*----------------------------------Admin tools------------------------------------------------------ */


private Politico[] AdminTools(Scanner sc,Politico[] politicos)
{
    String PasswordString = "MeatLoversPizza";
    int tracker=0;
    Console console = System.console();
    if (console == null) {
        System.err.println("Error desconcido");
        return politicos;
    }
    System.out.println("Introduza la contraseña");
    String Password = String.valueOf(console.readPassword("Introduzca una contraseña"));
    if(PasswordString.equals(Password))
    {
        System.out.println("Bienvenido al menu de Administrador");
        System.out.println("Que desea hacer");
        System.out.println("[A]ñadir [M]odificar alterar-[V]otos [R]eset");
        sc = new Scanner(System.in);
        switch (sc.nextLine().toUpperCase()) {
            case "A":
                    if (tracker<3) {
                        politicos[tracker] = Generar(sc);
                        tracker++;
                        break;
                    }
                    System.out.println("cupo actualmente lleno mejor modificar");
                    break;
            case "M": 
                    System.out.println("que politico desea modificar");
                    politicos = Modificar(politicos, sc);
                    
                break;
        
            default:
                    System.err.println("Inserte un valor valido");
                break;
        }
    }



return politicos;
}

private Politico[] Modificar(Politico[] politicos, Scanner sc)
{
    presentacion(politicos);
    int posicion = 0;
    String validador = "";
    Politico AModificar;
    System.out.println("desde el 1 al 3 abiendo que 1 es el superior de todos los mostrados escoja cual modificar");
    validador = sc.nextLine();
    if(esNumero(validador))
    {

    }


    return politicos;
}


private Politico Generar(Scanner sc)
{
    Politico NPolitico = new Politico("Jon Doe", AfiliacionPolitica.Izquierda, "Hombre");

    return NPolitico;
}



    /*--------------------------Separador de funciones internas---------------------------------------------------------------- */
    private String EleccionExceptions(Politico p)
    {   
        try {
            if (p.getNombre().equals("") || p.getNombre()==null || p.getGenero().equals("")) {
                return "Actualmente todavia no tenemos suficientes Candidatos, disculpe las molestias";
            }
            if (p.getGanadorª()) {
                return "Actualmente ya se escogio al presidente, disculpe las molestias";
            }
            return "";
        } catch (NullPointerException e) {
            return "Actualmente todavia no tenemos suficientes Candidatos, disculpe las molestias";
        }
        
    }

    public Politico[] comparador(Politico[] politicos)
    {
        Politico[] sortpolitico = new Politico[politicos.length];
        Politico left = null;
        Politico right = null;
        for (int i = 0; i < politicos.length; i++) {
            if (politicos[i].getVotos() > left.getVotos() || left == null) {
                left = politicos[i];
                sortpolitico[i] = left;
            }
            else{
                if (politicos[i].getVotos() < right.getVotos() || right == null) {
                    right = politicos[i];
                    sortpolitico[i] = right;
                }
            }
        }

        return sortpolitico;
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
}
