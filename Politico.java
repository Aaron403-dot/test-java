public class Politico implements PromesasPoliticas{
    
    private String Nombre;
    private AfiliacionPolitica AfiliacionPolitica;
    private String Genero;
    private boolean Ganadorª;
    private int votos;

    public Politico()
    {

    }

    public Politico(String N,AfiliacionPolitica AFP,String GEN,boolean G)
    {
        Nombre = N;
        AfiliacionPolitica = AFP;
        Genero = GEN;
        Ganadorª = G;
    }

    public Politico(String N,AfiliacionPolitica AFP,String GEN)
    {
        Nombre = N;
        AfiliacionPolitica = AFP;
        Genero = GEN;
    }

    public AfiliacionPolitica getAfiliacionPolitica() {
        return AfiliacionPolitica;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public boolean getGanadorª(){
        return Ganadorª;
    }

    public int getVotos() {
        return votos;
    }

    public void setAfiliacionPolitica(AfiliacionPolitica afiliacionPolitica) {
        AfiliacionPolitica = afiliacionPolitica;
    }

    public void setGanadorª(boolean ganadorª) {
        Ganadorª = ganadorª;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public String Inmigracion(AfiliacionPolitica AFP)
    {
        switch (AFP.toString()) {
            case "Centro" -> {
                return "Mantedre una Inmigracion Legal";
            }
            case "Derecha"-> {
                return "Reducire la Inmigracion";
            }
            case "Izquierda"-> {
                return "Facilitare la Inmigracion legal";
            }
            case "Ultra_derecha"-> {
                return "Solo entraran Gente de la nacion";
            }
            case "Ultra_Izquierda"-> {
                return "Facilitare la Inmigracion";
            }
            default ->{return "Mantedre una Inmigracion Legal";}
        }
    }
    @Override
    public String Economia(AfiliacionPolitica AFP)
    {
        switch (AFP.toString()) {
            case "Centro" -> {
                return "Estabilizare la economia";
            }
            case "Derecha"-> {
                return "Apollare a la pequeña empresa";
            }
            case "Izquierda"-> {
                return "Facilitare ayudas a las personas divergentes";
            }
            case "Ultra_derecha"-> {
                return "Obviamente tenemos que apollar a las MEGA corporaciones";
            }
            case "Ultra_Izquierda"-> {
                return "Facilitare ayudas a las personas";
            }
            default ->{return "Estabilizare la economia";}
        }
    }
    @Override
    public String Social(AfiliacionPolitica AFP)
    {
        switch (AFP.toString()) {
            case "Centro" -> {
                return "Todos los ciudadanos\\as tienen derechos y los merecen";
            }
            case "Derecha"-> {
                return "la familia nuclear es lo primero";
            }
            case "Izquierda"-> {
                return "todos merecemos los mismos derechos";
            }
            case "Ultra_derecha"-> {
                return "todos somos iguales pero hay gente mas igual que otra";
            }
            case "Ultra_Izquierda"-> {
                return "Nadie en absoluto deberia estar por encima de nadie";
            }
            default ->{return "Todos los ciudadanos\\as tienen derechos y los merecen";}
        }
    }
    @Override
    public String Sanidad(AfiliacionPolitica AFP)
    {
        switch (AFP.toString()) {
            case "Centro" -> {
                return "hay que buscar que la sanidad sea mejor cada dia";
            }
            case "Derecha"-> {
                return "habra que recortar en sanidad";
            }
            case "Izquierda"-> {
                return "tenemos que promover la sanidad fisica y mental";
            }
            case "Ultra_derecha"-> {
                return "tenemos que privatizar la sanidad";
            }
            case "Ultra_Izquierda"-> {
                return "La existencia de los hospitales privados es una barbarie en una sociedad civilizada";
            }
            default ->{return "hay que buscar que la sanidad sea mejor cada dia";}
        }
    }

}
