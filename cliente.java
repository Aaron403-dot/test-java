
public class cliente implements DGClientes{
    
    private String Nombre;
    private String Apellido;
    private int Edad;
    private boolean Miembro;

    public cliente(String NName,String NApellido,int NEdad,boolean NMiembro){
        Nombre = NName;
        Apellido = NApellido;
        Edad = NEdad;
        Miembro = NMiembro;
    }

    public cliente()
    {
        Nombre="Jon";
        Apellido="Doe";
        Edad=30;
        Miembro=false;
    }
    
    public String getNombre() {
        return Nombre;
    }
    public String getApellido() {
        return Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public boolean getMiembro(){
        return Miembro;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public void setMiembro(boolean miembro) {
        Miembro = miembro;
    }

    @Override
    public void ListadeCompras(String[] LCompra){
        for (String S : LCompra) {
            System.out.println(S);
        }
    }

    @Override
    public void ListadeDevoluciones(String[] LDevolicion){
        for (String S : LDevolicion) {
            System.out.println(S);
        }
    }


}
