
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;

public class PracticarConFicheros {
    public static void main(String[] args) {
        // Llama aquí al ejercicio que quieras probar
        PracticarConFicheros PCF = new PracticarConFicheros();
        // PCF.ejercicio1();
        //----------------------------
        // try {
        //     File F = new File("Diario.txt");
        //     if(F.createNewFile())
        //     {
        //         FileWriter FW = new FileWriter(F);
        //         FW.write("Este es un diario de prueba \n");
        //         FW.write("No se que se escribira\n");
        //         FW.close();
        //         PCF.ejercicio2(F);
        //     }
        //     else{
        //         System.err.println("No se pudo crear el archivo");
        //     }
        // } catch (Exception e) {
        // }
        //------------------------------------------------------

        //PCF.ejercicio3();

        //------------------------------------------------------

        //PCF.ejercicio4();

        //---------------------------------------------------------
        
        // PCF.ejercicio5();

        //---------------------------------------------------------
        
        // PCF.ejercicio6();

        //----------------------------------------------------------

        // PCF.ejercicio7();

        //-----------------------------------------------------------
        // try {
        //     File F = new File("AVaciar.txt");
        //     FileWriter FW = new FileWriter(F);
        //     FW.write("""
        //         According to all known laws\r
        //         of aviation,\r
        //         there is no way a bee\r
        //         should be able to fly.\r
        //         Its wings are too small to get\r
        //         its fat little body off the ground.\r
        //         """);
        //     FW.close();
        //     PCF.ejercicio8(F);
        // } catch (Exception e) {

        // }
        
        //-----------------------------------------------------------

        PCF.ejercicio9();

    }

    private void ejercicio1()
    {
        try {
            FileWriter FW = new FileWriter("TestEJ1.txt");
            FW.write("Hola " + System.getenv("USERNAME") + ". Bienvenido");
            FW.close();
            if (new File("TestEJ1.txt").exists()) {
                System.out.println("Se a creado con exito el archivo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ejercicio2(File F)
    {
        try {
            FileWriter FW = new FileWriter(F,true);
            if(F.canWrite())
            {
                FW.write("Pues se añadiran mas lineas");
                FW.write("\n Como por ejemplo esa");
                FW.close();
            }else{
                System.err.println("Algo a salido mal");
            }
            
        } catch (Exception e) {

        }
    }
    
     // Ejercicio 3: Eliminar archivo de prueba
    // Crea un archivo que se llame borrar.txt que contenga al menos una frase de texto
    // Elimina el archivo que acabas de crear.
    private void ejercicio3() {
        try {
            File F = new File("borrar.txt");
            if(F.createNewFile())
            {
                FileWriter FW = new FileWriter(F);
                FW.write("se que puedes leer mi mente \n maiu maiu maiu maiu maiu maiu maiu maiu maiu maiu maiu");
                FW.close();
                if(F.delete())
                {
                    System.out.println("Se a borrado correctamente");
                }else{
                    System.err.println("Algo a salido horriblemente mal");
                }

            }else{
                System.err.println("No se a podido ni crear el archivo");
            }
            
        } catch (Exception e) {
        }
    }

    // Ejercicio 4: Menú interactivo para manejar ficheros
    /*
    Mostrar un menú con las opciones:
        1.Crear archivo
        2.Escribir texto
        3.Añadir más texto
        4.Ver contenido
        5.Eliminar archivo
    Usar switch y try-catch para manejar errores.
    En la opción 1: simplemente crea el archivo.
    En la opción 2: escribe texto en él.
    En la opción 3: cuidado, no quieres reescribir el archivo, quieres añadir texto.
    En la opción 4: lectura de archivo (hasNextLine...)
    En la opción 5: eliminar archivo. 
    */
    private void ejercicio4() {
        try {
            Scanner scanner = new Scanner(System.in);
            String FileName = "PlaceHolder.txt";
            boolean Locker = true;
            while(Locker) {
            System.out.println("1. Crear archivo\n2. Escribir texto\n3. Añadir texto\n4. Ver contenido\n5. Eliminar archivo\n 0. Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine(); // limpiar buffer
            int opcionConfirmada;
            if (esNumero(opcion)) {
                opcionConfirmada = Integer.parseInt(opcion);
            } else {
                opcionConfirmada = 7;
            }
            
            switch (opcionConfirmada) {
                case 1 -> {
                    System.out.println("Escriba el nombre del archivo");
                    FileName = scanner.next()+".txt";
                    scanner.nextLine();
                    File F = new File(FileName);

                    if (F.exists()) {
                        System.out.println("el archivo ya existe por ende solo se escogera como activo");
                        break;
                    }

                    if (F.createNewFile()) {
                        System.out.println("Se a podido crear con exito el archivo");
                    }
                    else{
                        System.err.println("Algo a salido mal");
                    }
                    }
                case 2 -> {
                    if(!FileName.equals("PlaceHolder.txt")){
                        FileWriter FW = new FileWriter(FileName);
                        System.out.println("Se va a escribir un Texto para el archivo");
                        System.out.println("(Advertencia se sobreescribira el archivo si ya hay texto deje el siguiente input en blanco si desea cancelar)");
                        String InputString = scanner.nextLine();
                        if (InputString.equals(" ")) {
                            break;
                        }else{
                            FW.write(InputString + "\n");
                            FW.close();
                        }
                    }else{
                        System.err.println("cree primero el archivo Por favor");
                    }
                    }
                case 3 -> {
                    if(!FileName.equals("PlaceHolder.txt")){
                        FileWriter FW = new FileWriter(FileName,true);
                        System.out.println("Se va a añadir un Texto para el archivo");
                        String InputString = scanner.nextLine();
                        if (InputString.equals(" ")) {
                            break;
                        }else{
                            FW.write(InputString + "\n");
                            FW.close();
                        }
                    }else{
                        System.err.println("cree primero el archivo Por favor");
                    }   }
                case 4 -> {
                    if(!FileName.equals("PlaceHolder.txt")){
                        File F = new File(FileName);
                        Scanner FR = new Scanner(F);
                        while (FR.hasNextLine()) {
                            System.out.println(FR.nextLine());
                        }
                    }else{
                        System.err.println("cree primero el archivo Por favor");
                    }   }
                case 5 -> {
                        if(!FileName.equals("PlaceHolder.txt")){
                            File F = new File(FileName);
                            
                            if(F.delete()){
                                System.out.println("se a borrad exitosamente");
                            }else{
                                System.err.println("algo salio mal");
                            }
                        }else{
                            System.err.println("cree primero el archivo Por favor");
                        }   }

                case 0 -> {Locker=false;}
            
                default -> System.out.println("Instroduzca una opcion valida");
                }
            }
            

    } catch (Exception e) {
    } 
    }

    // Ejercicio 5: Copiar contenido de un archivo a otro
    private void ejercicio5() {
        try {
            File F = new File("Original.txt");
            if (F.createNewFile()) {
                FileWriter FW = new FileWriter(F);
                FW.write("Se tiene cosas copiables");
                FW.close();
                File FC = new File("Clon.txt");
                if (FC.createNewFile()) {
                    FileWriter FWC = new FileWriter(FC);
                    Scanner FR = new Scanner(F);
                    FWC.write(FR.nextLine());
                    FWC.close();
                    FR.close();
                }else{
                    System.err.println("No se pudo crear el archivo");
                }

            } else {
                System.err.println("No se pudo crear el archivo");
            }
        } catch (Exception e) {
        }
        
    }

    // Ejercicio 6: Crear archivo con varios nombres (nombre1, nombre2, nombre3)
    private void ejercicio6(){
        try{
        File F = new File("LoopTest.txt");
        FileWriter FW = new FileWriter(F);
        String[] ListaNombre = {"Hola","Mundo","Planeta","Universo","Cosmo","galaxia"};
        for (int i = 0; i < ListaNombre.length; i++) {
            FW.write(ListaNombre[i]+"\n");
        }
        FW.close();
        Scanner sc = new Scanner(F);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
        }catch(Exception e)
        {
            System.err.println(e.getLocalizedMessage());
        }

    }

    // Ejercicio 7: Leer archivo línea por línea con número de línea
    // ejemplo: Linea X: texto_de_la_línea
    private void ejercicio7() {
        try {
            File F = new File("LoopTest.txt");
            Scanner sc = new Scanner(F);
            int Index = 1;
            while(sc.hasNextLine()){
                // sc.
                System.out.println("Linea numero "+Index+": "+sc.nextLine());
                Index++;
            }   
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        

    }

    // Ejercicio 8: Borrar contenido del archivo pero sin eliminar el archivo
    private void ejercicio8(File F) {
        try {
            FileWriter FW = new FileWriter(F);
            FW.write("");
            FW.close();
        } catch (Exception e) {

        }
    }

    // Ejercicio 9: Contador de líneas
    private void ejercicio9() {
        try {
            File F = new File("LoopTest.txt");
            Scanner sc = new Scanner(F);
            int Index = 0;
            while(sc.hasNextLine()){
                Index++;
                sc.nextLine();
            }   
            System.out.println("Tiene actualmente " + Index + " lineas");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
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