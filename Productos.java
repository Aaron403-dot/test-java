public class Productos {
    private int Cantidad;
    private double Precio;
    private String Nombre;
    private ETiposDeProductos Tipo;

    public Productos()
    {

    }

    public Productos(int Quantity,double Price,String Name){
        Cantidad = Quantity;
        Precio = Price;
        Nombre = Name;
    }

    public Productos(int Quantity,double Price,String Name,ETiposDeProductos Type){
        Cantidad = Quantity;
        Precio = Price;
        Nombre = Name;
        Tipo = Type;
    }

    public void setTipo(ETiposDeProductos tipo) {
        Tipo = tipo;
    }
    
    public void setPrecio(double precio) {
        Precio = precio;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    
    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
    
    public int getCantidad() {
        return Cantidad;
    }
    
    public String getNombre() {
        return Nombre;
    }
    
    public double getPrecio() {
        return Precio;
    }
    
    public ETiposDeProductos getTipo() {
        return Tipo;
    }
    
}
