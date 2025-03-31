import java.io.Console;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;

public class GestionDeVotacies {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionDeVotacies GDV = new GestionDeVotacies();
        Politico[] politicos = new Politico[3];
        String Password = "";
        if (args.length > 0) {
            Password = args[0];
        }
        GDV.menu(sc,politicos,Password);

    }

    private void menu(Scanner sc,Politico[] politicos,String Password)
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
                            if (!Validando) {
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
                                if (sc.nextLine().equalsIgnoreCase("si") && politicos[0] != null) {
                                    Validando = true;
                                    Calcular(politicos);
                                }
                                else{
                                    if(politicos[0] == null)
                                    {
                                        System.err.print("no hay candidatos posibles");
                                    }
                                }
                        break;
                    case "4":
                        if(EleccionExceptions(politicos[0]).isBlank()){
                            politicos[0].setGanadorª(Ganador(politicos));
                        break;
                        }
                        else{
                            System.err.println("Actualmente no hay nadie que pueda ser elegido");
                            break;
                        }
                    case "5":
                                presentacion(politicos);
                        break;
                    case "q":
                            ExitCode--;
                        break;
                    case "a":
                                politicos = AdminTools(sc, politicos,Password);
                        break;
                
                    default:
                        System.out.println("Valor no valido Introduzca un valor valido");
                        break;
                }

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
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
                if(!EleccionExceptions(p[i]).isBlank())
                {
                    throw new NoEleccionsException(EleccionExceptions(p[i]));
                }else
                {
                    System.out.print("["+i+"]"+p[i].getNombre()+" ");
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
        try {
                for (int i = 0; i < politicos.length; i++) {
                    if(!EleccionExceptions(politicos[i]).isBlank())
                    {
                        throw new NoEleccionsException(EleccionExceptions(politicos[i]));
                    }else{
                        System.out.println(politicos[i].getNombre() + ": " + politicos[i].getVotos());
                    }
                }
        } catch (NoEleccionsException e) {
            System.err.println(e.getMessage());
        }

    }

private void Calcular(Politico[] politicos){

    int total = 0;

    double porcentaje = 0.000000000000;

    politicos = comparador(politicos);

    System.out.println(politicos[0].getNombre() + ": Tiene mas votos");
    System.out.println(politicos[2].getNombre() + ": Tiene menos votos");
    for (Politico p : politicos) {
        total += p.getVotos();
    }
    for (Politico p : politicos) {
        if (p.getVotos()>0) {
            porcentaje = p.getVotos()*100/total; 
        }
        System.out.println(p.getNombre() + " tiene actualmente: " + porcentaje + "% de votos"); 
        porcentaje = 0.0;
    }
}

private boolean Ganador(Politico[] politicos)
{
    try {
        if(!EleccionExceptions(politicos[0]).isBlank())
        {
            throw new NoEleccionsException(EleccionExceptions(politicos[0]));
        }
        else{
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
        
        
    } catch (NoEleccionsException e) {
        System.err.println(e.getMessage());
        return false;
    }
}


private void presentacion(Politico[] politicos)
{
    try {
        for (Politico politico : politicos) {
            if(!EleccionExceptions(politico).isBlank())
                    {
                        throw new NoEleccionsException(EleccionExceptions(politico));
                    }else{
                        System.out.println("--------------");
                        System.out.println("Nombre: " + politico.getNombre());
                        System.out.println("Genero: " + politico.getGenero());
                        System.out.println("Afiliacion: " + politico.getAfiliacionPolitica());
                        System.out.println(politico.getAfiliacionPolitica().toString());
                        System.out.println("--------------");
                    }
            
        }
    } catch (NoEleccionsException e) {
        System.err.println(e.getMessage());
    }
}


/*----------------------------------Admin tools------------------------------------------------------ */


private Politico[] AdminTools(Scanner sc,Politico[] politicos, String Password)
{
    String PasswordString = "MeatLoversPizza";
    int tracker=0;
    Politico[] NPoliticos = politicos;
    for (Politico p : politicos) {
        if (p!=null) {
            tracker++;
        }
    }
    boolean lock = true;
    // Console console = System.console();
    // if (console == null) {
    //     System.err.println("Error desconcido");
    //     return politicos;
    // }
    
    sc = new Scanner(System.in);
    //String Password = LeerPassword("Introduza la contraseña");
    // String Password = console.readPassword().toString();
    if(PasswordString.equals(Password))
    {
        
        while (lock) {
            System.out.println("Bienvenido al menu de Administrador");
            System.out.println("Que desea hacer");
            System.out.println("[A]ñadir [M]odificar alterar-[V]otos [R]eset [G]uardar [Salir]");
            sc = new Scanner(System.in);
            switch (sc.nextLine().toUpperCase()) {
                case "A":
                        if (tracker<3) {
                            NPoliticos[tracker] = Generar(sc);
                            if (politicos[tracker] != null) {
                                tracker++;
                            }
                            break;
                        }
                        System.out.println("cupo actualmente lleno mejor modificar");
                        break;
                case "M": 
                        System.out.println("que politico desea modificar");
                        NPoliticos = Modificar(NPoliticos, sc);
                        
                    break;

                case "V":
                        System.out.println("Seleccione que politico deberia tener los votos");
                        politicos = CambiarVotos(sc, NPoliticos);

                break;

                case "R":
                        System.out.println("se va a reiniciar el ganador de las elecciones esta seguro");
                        System.out.println("[S]I [N]O o ponga cualquier otro caracter");
                        if (sc.nextLine().equals("S")) {
                            System.out.println("Estas seguro esta accion no se puede deshacer");
                            System.out.println("Escriba [BORRAR] para confirmar");
                            if (sc.nextLine().toUpperCase().equals("BORRAR")) {
                                for (Politico p : NPoliticos) {
                                    p.setGanadorª(false);
                                }
                                System.out.println("Se a realizado con exito el reinicio");
                                break;
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            break;
                        }

                case "G": 
                    lock = false;
                break;
                        
                case "SALIR":
                    return politicos;                    
                default:
                        System.err.println("Inserte un valor valido");
                    break;
            }
        }
    }

return NPoliticos;
}

/*---------------------------Cambio votos---------------------------------------------*/
private Politico[] CambiarVotos(Scanner sc, Politico[] Politicos)
{
    boolean lock = true;
    presentacion(Politicos);
    String validador;
    int posicion = 0;
    System.out.println("desde el 1 al " + Politicos.length + " abiendo que 1 es el superior de todos los mostrados escoja cual modificar [0] Salir y Cancelar");
    while (lock) {
        validador = sc.nextLine();
        if(esNumero(validador))
        {
            switch (Integer.parseInt(validador)) {
                case 1 -> {
                    posicion = 0;
                    lock = false;
                }
                case 2 -> {
                    posicion = 1;
                    lock = false;
                }
                case 3 -> {
                    posicion = 2;
                    lock = false;
                }
                case 0 -> {
                    posicion = -1;
                    lock = false;
                }
            
                default -> System.err.println("Introduzca un numero valido");
            }
        }
    }
    
    lock = true;

    if (posicion == -1) {
        return Politicos;
    }

    if (Politicos[posicion] == null) {
        System.out.println("No hay politico en la posicion " + posicion + " desea Introducir un nuevo politico");
        System.out.println("[S]i [N]o");
        while (lock) {
            switch (sc.nextLine().toUpperCase()) {
                case "S":
                    Politicos[posicion] = Generar(sc);
                    System.out.println("se ha generado correctamente el politico");
                    lock = false;
                    break;
                    
                case "N":
                    System.out.println("no se va a generar ningun politico");
                    lock = false;
                    return Politicos;
                default:
                    System.err.println("Introduzca un valor Valido");
                    break;
            }
        }
    }
    while (lock) {
        System.out.println("Escriba cuantos votos debe tener");
        validador = sc.nextLine();
        if (esNumero(validador) && Integer.parseInt(validador)>= 0) {
            Politicos[posicion].setVotos(Integer.parseInt(validador));
            lock = false;
        }
        else
        {
            System.err.println("Introduzca un numero valido");
        }
    }
    return Politicos;
}




/*-----------------------------------Generar Politicos-----------------------------------------------------*/
private Politico Generar(Scanner sc)
{
    try {
        String PNombre;
        AfiliacionPolitica AP = AfiliacionPolitica.Centro;
        String PGenero;
        Politico NPolitico = new Politico("Jon Doe", AfiliacionPolitica.Izquierda, "HOMBRE");
        System.out.println("Introduzca el nombre del Politico (En caso de no poner un nuevo nombre se pondra el nombre Placeholder): ");
        PNombre = sc.nextLine();
        if (!PNombre.equals("")) {
            NPolitico.setNombre(PNombre);
        }
        boolean LockChoice = true;
        while (LockChoice) {
            String Validator;
            System.out.println("Defina cual es la afiliacion politica del candidato");
            System.out.println("[0] Ultra Izquierda [1] Izquierda [2] Centro [3] Derecha [4] Ultra Derecha");
            Validator = sc.nextLine();
            if (esNumero(Validator)) {
                switch (Integer.parseInt(Validator)) {
                    case 0:
                        AP = AfiliacionPolitica.Ultra_Izquierda;
                        LockChoice = false;
                        break;
                    case 1:
                        AP = AfiliacionPolitica.Izquierda;
                        LockChoice = false;
                        break;
                    case 2:
                        AP = AfiliacionPolitica.Centro;
                        LockChoice = false;
                        break;
                    case 3:
                        AP = AfiliacionPolitica.Derecha;
                        LockChoice = false;
                        break;
                    case 4:
                        AP = AfiliacionPolitica.Ultra_Derecha;
                        LockChoice = false;
                        break;
                    default:
                        System.err.println("Introduzca un Valor valido");
                        break;
                }

            }
            else
            {
                System.err.println("Introduzca un Valor Valido");
            }
        }
        NPolitico.setAfiliacionPolitica(AP);
        System.out.println("Introduzca el genero del politico");
        PGenero = sc.nextLine().toUpperCase();
        NPolitico.setGenero(PGenero);
        return NPolitico;
    } catch (Exception e) {

        System.err.println(e.getMessage());
        return null;

    }
}



/*-------------------------------Modifica politico----------------------------------------- */

private Politico ModificarPolitico(Scanner sc, Politico VP)
{
    try {
        String PNombre;
        AfiliacionPolitica AP = AfiliacionPolitica.Centro;
        String PGenero;
        Politico NPolitico = VP;
        System.out.println("Introduzca el nombre del Politico (En caso de no poner un nuevo nombre se pondra el nombre Placeholder): ");
        PNombre = sc.nextLine();
        
        if (!PNombre.equals("")) {
            NPolitico.setNombre(PNombre);
        }
        
        boolean LockChoice = true;
        while (LockChoice) {
            String Validator;
            System.out.println("Defina cual es la afiliacion politica del candidato");
            System.out.println("[0] Ultra Izquierda [1] Izquierda [2] Centro [3] Derecha [4] Ultra Derecha [7]NO CAMBIAR");
            Validator = sc.nextLine();
            if (esNumero(Validator)) {
                switch (Integer.parseInt(Validator)) {
                    case 0:
                        AP = AfiliacionPolitica.Ultra_Izquierda;
                        LockChoice = false;
                        break;
                    case 1:
                        AP = AfiliacionPolitica.Izquierda;
                        LockChoice = false;
                        break;
                    case 2:
                        AP = AfiliacionPolitica.Centro;
                        LockChoice = false;
                        break;
                    case 3:
                        AP = AfiliacionPolitica.Derecha;
                        LockChoice = false;
                        break;
                    case 4:
                        AP = AfiliacionPolitica.Ultra_Derecha;
                        LockChoice = false;
                        break;
                    case 7:
                        AP = NPolitico.getAfiliacionPolitica();
                        LockChoice = false;
                        break;
                    default:
                        System.err.println("Introduzca un Valor valido");
                        break;
                }

            }
            else
            {
                System.err.println("Introduzca un Valor Valido");
            }
        }
        NPolitico.setAfiliacionPolitica(AP);
        System.out.println("Introduzca el genero del politico (Deje en blanco para dejar el anterior)");
        PGenero = sc.nextLine().toUpperCase();
        if (!PGenero.equals("") || PGenero.equals(VP.getGenero())) {
            NPolitico.setGenero(PGenero);
        }

        return NPolitico;
    } catch (Exception e) {

        System.err.println(e.getMessage());
        return VP;

    }
}

private Politico[] Modificar(Politico[] politicos, Scanner sc)
{
    presentacion(politicos);
    int posicion = 0;
    String validador = "";
    Politico AModificar;
    String NPNombre;
    AfiliacionPolitica NAP = AfiliacionPolitica.Centro;
    String NPGenero;

    boolean lock = true;
    System.out.println("desde el 1 al 3 abiendo que 1 es el superior de todos los mostrados escoja cual modificar [0] Salir y Cancelar");
    while (lock) {
        validador = sc.nextLine();
        if(esNumero(validador))
        {
            switch (Integer.parseInt(validador)) {
                case 1 -> {
                    posicion = 0;
                    lock = false;
                }
                case 2 -> {
                    posicion = 1;
                    lock = false;
                }
                case 3 -> {
                    posicion = 2;
                    lock = false;
                }
                case 0 -> {
                    posicion = -1;
                    lock = false;
                }
            
                default -> System.err.println("Introduzca un numero valido");
            }
        }
    }

    lock = true;

    if (posicion == -1) {
        return politicos;
    }

    if (politicos[posicion] == null) {
        System.out.println("No hay politico en la posicion " + posicion + " desea Introducir un nuevo politico");
        System.out.println("[S]i [N]o");
        while (lock) {
            switch (sc.nextLine().toUpperCase()) {
                case "S":
                    politicos[posicion] = Generar(sc);
                    System.out.println("se ha generado correctamente el politico");
                    lock = false;
                    return politicos;
                    
                case "N":
                    System.out.println("no se va a generar ningun politico");
                    lock = false;
                    return politicos;
                default:
                    System.err.println("Introduzca un valor Valido");
                    break;
            }
        }

    }

    AModificar = politicos[posicion];
    
    politicos[posicion] = ModificarPolitico(sc, AModificar);
    
    return politicos;
}



    /*--------------------------Separador de funciones internas---------------------------------------------------------------- */
    private String EleccionExceptions(Politico p)
    {   
        try {
            if (p==null) {
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

    private Politico[] comparador(Politico[] politicos)
    {
        // Politico[] sortpolitico = new Politico[politicos.length];
        // // Politico left = null;
        // // Politico right = null;
        Politico placeholder;
        // for (int i = 0; i < politicos.length; i++) {
        //     // if (politicos[i].getVotos() > left.getVotos() && left == null) {
        //     //     left = politicos[i];
        //     //     sortpolitico[i] = left;
        //     // }
        //     // else{
        //     //     if (politicos[i].getVotos() < right.getVotos() && right == null) {
        //     //         right = politicos[i];
        //     //         sortpolitico[i] = right;
        //     //     }
        //     // }
               

            
        // }

        for (int i = 0; i < politicos.length - 1; i++) {
            for (int j = 0; j < politicos.length - 1 - i; j++) {
                if (politicos[j].getVotos() < politicos[j + 1].getVotos()) {
                    // Intercambiar array[j] y array[j + 1]
                    placeholder = politicos[j];
                    politicos[j] = politicos[j + 1];
                    politicos[j + 1] = placeholder;
                }
            }
        }
        return politicos;
    }

    private static boolean esNumero(String NumOLet)
    {
        //Declara la posicion del Analicis de checkeo
        ParsePosition Lugar = new ParsePosition(0);
        //saca la instalcia del formato de numero y analiza el lugar
        NumberFormat.getInstance().parse(NumOLet,Lugar);
        //Positivo si el tamaño del lugar es igual a la posicion actual del analizador
        return NumOLet.length() == Lugar.getIndex();
    }


}
