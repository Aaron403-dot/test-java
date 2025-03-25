
public class tienda {
    
    public static void main(String[] args) {
        cliente PrimerCliente = new cliente("billy","bob",23,false);
        cliente SegundoCliente = new cliente();
        tienda Tienda = new tienda();
        System.out.println("Cliente");
        System.out.println("Nombre: " + PrimerCliente.getNombre());
        System.out.println("Apellido: " + PrimerCliente.getApellido());
        System.out.println("Edad: " + PrimerCliente.getEdad());
        System.out.println("Miembro: " + (PrimerCliente.getMiembro()? "Si":"No"));
        System.out.println("Compro: ");
        String[] ComprasC1 = Tienda.AñadirCompra();
        PrimerCliente.ListadeCompras(ComprasC1);
        System.out.println("Devolvio: ");
        String[] DevolucionesC1 = Tienda.AñadirDevoluciones("Fresas","Platanos");
        PrimerCliente.ListadeDevoluciones(DevolucionesC1);
        System.out.println("----------X-------------");
        SegundoCliente.setMiembro(true);
        SegundoCliente.setEdad(23);
        SegundoCliente.setApellido("Adams");
        SegundoCliente.setNombre("Rogers");
        System.out.println("Registro");
        System.out.println("Nombre: " + SegundoCliente.getNombre());
        System.out.println("Apellido: " + SegundoCliente.getApellido());
        System.out.println("Edad: " + SegundoCliente.getEdad());
        System.out.println("Registro Correcto");
        System.out.println("----------X-------------");
    }

    private String[] AñadirCompra(String... ComprasArgs)
    {
        String[] Compras = ComprasArgs;

        return Compras;
    }

    private String[] AñadirCompra()
    {
        String[] Compras = new String[4];
        Compras[0] = "Queso";
        Compras[1] = "Apio";
        Compras[2] = "Pan";
        Compras[3] = "Arandanos";

        return Compras;
    }

    private String[] AñadirDevoluciones(){
        String[] devoluciones = new String[4];
        devoluciones[0] = "Queso";
        devoluciones[1] = "Apio";
        devoluciones[2] = "Pan";
        devoluciones[3] = "Arandanos";

        return devoluciones;
    }

    private String[] AñadirDevoluciones(String... DevolucionesArgs){
        String[] devoluciones = DevolucionesArgs;

        return devoluciones;
    }

}
