
import java.util.Scanner;

public class GestionProductos {
    
    public static void main(String[] args) {
        try {
            GestionProductos GP = new GestionProductos();
            String[] Nombre = new String[10];
            int[] Cantidad = new int[10];
            double[] Precio = new double[10];
            int Pointer = 0;
            int ExitCode = 1;
            Scanner Sc = new Scanner(System.in);
            while(ExitCode > 0){
                String[] caja;
                //limpiador de escaner
                Sc = new Scanner(System.in);
                System.out.println("Buenos dias que desea hacer hoy?");
                System.out.println("[1]Añadir [2]Lista [3]Buscar [4]Actualizar [5]Total [0]Salir");
                switch (Sc.next()) {
                    case "1" -> {
                        if (Pointer < 10) {
                            caja = GP.Añadir(Sc);
                            if (caja[0].equals("NoValid")) {
                                System.err.println("Wrong " + caja[0]);
                                break;
                            }else{
                                Nombre[Pointer] = caja[0];
                                Cantidad[Pointer] = Integer.parseInt(caja[1]);
                                Precio[Pointer] = Double.parseDouble(caja[2]);
                                Pointer++;
                                
                            }
                            
                        } else {
                            System.err.println("error Limite de productos alcanzado");
                        }
                    }

                    case "2" -> GP.lista(Nombre, Cantidad, Precio, Pointer);

                    case "3" -> {
                                int PosicionGuardada;
                                PosicionGuardada = GP.Buscar(Sc, Nombre);
                                if (PosicionGuardada > -1) {
                                    System.out.println("------Producto-------");
                                    System.out.println(Nombre[PosicionGuardada]);
                                    System.out.println("Cantidad: " + Cantidad[PosicionGuardada]);
                                    System.out.println("Precio: " + Precio[PosicionGuardada]);
                                    System.out.println("---------------");
                                }
                            }

                    case "4" -> {
                                int PosicionGuardada;
                                PosicionGuardada = GP.Buscar(Sc, Nombre);
                                if (PosicionGuardada>-1) {
                                    caja = GP.Modificar(Sc, Nombre[PosicionGuardada], Cantidad[PosicionGuardada], Precio[PosicionGuardada]);
                                    if (caja != null) {
                                        Nombre[PosicionGuardada] = caja[0];
                                        Cantidad[PosicionGuardada] = Integer.parseInt(caja[1]);
                                        Precio[PosicionGuardada] = Double.parseDouble(caja[2]);
                                    }
                                }
                                
                    }
                    case "5" -> {
                        double ValorTotal;
                        ValorTotal = GP.Total(Precio,Cantidad);
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

    private String[] Añadir(Scanner Sc)throws Exception{
        try {
            String NNombre;
            int NCantidad;
            double NPrecio;
            String[] caja = new String[3];
            System.out.println("Introduzca el nombre");
            NNombre = Sc.next();
            System.out.println("Introduzca la Cantidad");
            NCantidad = Sc.nextInt();
            System.out.println("Introduzca el Precio");
            NPrecio = Sc.nextDouble();
            caja[0] = NNombre;
            caja[1] = String.valueOf(NCantidad);
            caja[2] = String.valueOf(NPrecio);
            return caja;
        } catch (Exception e) {
            System.err.println("Se ha introducido un valor no valido");
            String[] Placeholder = {"NoValid","1","1"};
            return Placeholder;
        }
    }

    private void lista(String[] NWN,int[] NCP,double[] NPP,int Pointer)
    {
        for (int i = 0; i < Pointer; i++) {
            System.out.println(NWN[i]);
            System.out.println(NCP[i]);
            System.out.println(NPP[i]);
        }
    }

    private int Buscar(Scanner sc, String[] NAB)
    {
        int Posicion = 0;
        boolean existe = false;
        String Nombre;
        System.out.println("introduzca el nombre del producto a buscar");
        Nombre = sc.next();
        if(NAB == null)
        {return -1;
        }
        for (int i = 0; i < NAB.length; i++) {
            if (NAB[i] != null) {
                if (NAB[i].equals(Nombre)) {
                    Posicion = i;
                    existe = true;
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

    private String[] Modificar(Scanner sc,String VNombre,int VCantidad,double VPrecio)
    {
        try {
            String NNombre;
        int NCantidad;
        double NPrecio;
        String[] caja = new String[3];
        sc.nextLine();
        System.out.println("Introduzca un nuevo nombre (Si desea mantener el viejo dejelo en blanco)");
        NNombre = sc.nextLine();
        if(NNombre.equals("")){
            NNombre = VNombre;
        }
        System.out.println("Introduzca una nueva Cantidad (Si desea mantener el viejo dejelo en blanco)");
        NCantidad = Integer.parseInt(sc.next());
        if(NCantidad == 0){
            NCantidad = VCantidad;
        }
        System.out.println("Introduzca un nuevo Precio (Si desea mantener el viejo dejelo en blanco)");
        NPrecio = Double.parseDouble(sc.next());
        if(NPrecio == 0){
            NPrecio = VPrecio;
        }
        if (NNombre.equals(VNombre) && NPrecio == VPrecio && NCantidad == VCantidad) {
            System.out.println("No se ha hecho ninguna modificacion");
            return null;
        }else{
            caja[0] = NNombre;
            caja[1] = String.valueOf(NCantidad);
            caja[2] = String.valueOf(NPrecio);
            return caja;
        }
        } catch (Exception e) {
            return null;

        }
        
    }

    private double Total(double[] Valor, int[] cantidad){
        double VTotal = 0;
        int contador = 0;
        for (double d : Valor) {
            VTotal += d;
            if (cantidad[contador]>0) {
                VTotal *= cantidad[contador];
            }
            contador++;
        }
        return VTotal;
    }

}
