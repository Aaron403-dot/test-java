
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;

public class GestionProductosAlt {
    
    public static void main(String[] args) {
        try {
            GestionProductosAlt GP = new GestionProductosAlt();
            Productos[] Producto = new Productos[10];
            Productos caja;
            int Pointer = 0;
            int ExitCode = 1;
            Scanner Sc = new Scanner(System.in);
            while(ExitCode > 0){
                //limpiador de escaner
                Sc = new Scanner(System.in);
                System.out.println("Buenos dias que desea hacer hoy?");
                System.out.println("[1]Añadir [2]Lista [3]Buscar [4]Actualizar [5]Total [0]Salir");
                switch (Sc.next()) {
                    case "1" -> {
                        if (Pointer < 10) {
                            Producto[Pointer] = GP.Añadir(Sc);
                            if (Producto[Pointer].getNombre().equals("NoValid")) {
                                System.err.println("Wrong " + Producto[Pointer].getNombre());
                                break;
                            }else{
                                // Nombre[Pointer] = caja[0];
                                // Cantidad[Pointer] = Integer.parseInt(caja[1]);
                                // Precio[Pointer] = Double.parseDouble(caja[2]);
                                Pointer++;
                                
                            }
                            
                        } else {
                            System.err.println("error Limite de productos alcanzado");
                        }

                    }

                    case "2" -> GP.lista(Producto);

                    case "3" -> {
                                int PosicionGuardada;
                                PosicionGuardada = GP.Buscar(Sc, Producto);
                                if (PosicionGuardada > -1) {
                                    System.out.println("------Producto-------");
                                    System.out.println(Producto[PosicionGuardada].getNombre());
                                    System.out.println("Cantidad: " + Producto[PosicionGuardada].getCantidad());
                                    System.out.println("Precio: " + Producto[PosicionGuardada].getPrecio());
                                    System.out.println("---------------");
                                }
                            }

                    case "4" -> {
                                int PosicionGuardada;
                                PosicionGuardada = GP.Buscar(Sc, Producto);
                                if (PosicionGuardada>-1) {
                                    caja = GP.Modificar(Sc, Producto[PosicionGuardada]);
                                    if (caja != null) {
                                        Producto[PosicionGuardada] = caja;
                                    }
                                }
                                
                    }
                    case "5" -> {
                        double ValorTotal;
                        ValorTotal = GP.Total(Producto);
                        System.out.println("El Valor total es de: " + ValorTotal);
                    }
                    default -> {ExitCode = 0;
                    Sc.close();
                    System.out.println("Adios");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Excepcion: " + e.getMessage());

        }
    }

    private Productos Añadir(Scanner Sc)throws Exception{
        try {

            String NNombre;
            int NCantidad;
            double NPrecio;
            Productos Caja;
            System.out.println("Introduzca el nombre");
            NNombre = Sc.next();
            System.out.println("Introduzca la Cantidad");
            NCantidad = Sc.nextInt();
            System.out.println("Introduzca el Precio");
            NPrecio = Sc.nextDouble();
            // caja[0] = NNombre;
            // caja[1] = String.valueOf(NCantidad);
            // caja[2] = String.valueOf(NPrecio);
            Caja = new Productos(NCantidad,NPrecio,NNombre);
            return Caja;


        } catch (Exception e) {
            System.err.println("Se ha introducido un valor no valido");
            Productos Placeholder = new Productos(1,1,"NoValid");
            return Placeholder;
        }
    }

    private void lista(Productos[] Product)
    {
        /*for (int i = 0; i < Pointer; i++) {
            System.out.println(NWN[i]);
            System.out.println(NCP[i]);
            System.out.println(NPP[i]);
        }*/

        for (Productos P : Product) {
            if (P!=null) {
                System.out.println("---------------");
                System.out.println("Nombre: " + P.getNombre());
                System.out.println("Cantidad: "+  P.getCantidad());
                System.out.println("Precio: " + P.getPrecio());
                System.out.println("---------------");
            } 
        }
    }

    private int Buscar(Scanner sc, Productos[] NAB)
    {
        int Posicion = 0;
        boolean existe = false;
        String Nombre;
        System.out.println("introduzca el nombre del producto a buscar");
        Nombre = sc.next();
        if(NAB == null)
        {
            return -1;
        }
        // for (int i = 0; i < NAB.length; i++) {
        //     if (NAB[i] != null) {
        //         if (NAB[i].equals(Nombre)) {
        //             Posicion = i;
        //             existe = true;
        //         }
        //     }
        // }
        for (int i =0 ;i < NAB.length;i++) {
            if (NAB[i]!=null) {
                if (NAB[i].getNombre().equalsIgnoreCase(Nombre)) {
                    existe = true;
                    Posicion=i;
                    
                }
            }
        }
        if(existe){
            return Posicion;
        }
        else{
            System.err.println("el objeto " + Nombre + " No existe");
            return -1;
        }
        
    }

    private Productos Modificar(Scanner sc,Productos Producto)
    {
        try {
        String NNombre;
        String NCantidad;
        String NPrecio;
        Productos caja;
        sc.nextLine();
        System.out.println("Introduzca un nuevo nombre (Si desea mantener el viejo dejelo en blanco)");
        NNombre = sc.nextLine();
        if(NNombre.equals("")){
            NNombre = Producto.getNombre();
        }
        System.out.println("Introduzca una nueva Cantidad (Si desea mantener el viejo dejelo en blanco)");
        NCantidad = sc.nextLine();
        if(NCantidad == "0" || !esNumero(NCantidad)){
            NCantidad = Producto.getCantidad()+"";
        }
        System.out.println("Introduzca un nuevo Precio (Si desea mantener el viejo dejelo en blanco)");
        NPrecio = sc.nextLine();
        if(NPrecio == "0"|| !esNumero(NPrecio)){
            NPrecio = Producto.getPrecio()+"";
        }
        if (NNombre.equals(Producto.getNombre()) && NPrecio.equals(Producto.getPrecio()+"") && NCantidad.equals(Producto.getCantidad()+"")) {
            System.out.println("No se ha hecho ninguna modificacion");
            return null;
        }else{
            caja = new Productos(Integer.parseInt(NCantidad), Double.parseDouble(NPrecio.replace(',', '.')), NNombre);
            return caja;
        }
        } catch (Exception e) {
            return null;

        }
        
    }

    private double Total(Productos[] Producto){
        double VTotal = 0;
        for (Productos p : Producto) {
            if (p!=null) {
                VTotal += p.getPrecio() * p.getCantidad();
            }
        }
        return VTotal;
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
