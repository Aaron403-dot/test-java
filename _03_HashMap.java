import java.lang.reflect.Array;
import java.text.ListFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class _03_HashMap {

    public static void main(String[] args) {
        _03_HashMap map = new _03_HashMap();
        map.Diccionario();
        map.CuentaCaracteres();
        map.AgrupaNombres();
        map.Nombre_TelefonoMail();
    }
    


    private void Nombre_TelefonoMail() {
        TreeMap<String,String> NombreContacto = new TreeMap<>();
        ArrayList<String> Email = new ArrayList<>();
        Email.add("reanukeebs@spiff.uk");
        Email.add("Yorksire@spiff.uk");
        Email.add("RodTowar@spiff.uk");
        Email.add("Spiffco@spiff.uk");
        Email.add("Keebs@spiff.uk");
        ArrayList<Integer> Telefono = new ArrayList<>();
        Telefono.add(123456789);
        Telefono.add(987654321);
        Telefono.add(456789123);
        Telefono.add(789123456);
        Telefono.add(321654987);
        int index = 0;
        String[] Nombre = {"Juan", "Pedro", "Maria", "Jose", "Ana"};
        for(String n: Nombre){
            String emmail = Email.get(index);
            int telefono = Telefono.get(index);
            NombreContacto.put(n, "Telefono: " + telefono + ", Email: " + emmail);
            index++;
        }
        System.out.println(NombreContacto.reversed());
        String Buscar = "Juan";
        if(NombreContacto.containsKey(Buscar)){
            System.out.println("El elemento existe en el diccionario");
            System.out.println("El elemento es: " + NombreContacto.get(Buscar));
        }else{
            System.out.println("El elemento no existe en el diccionario");
        }
    }


    private void AgrupaNombres(){
        String[] nombres = {"Juan", "Pedro", "Maria", "Jose", "Ana", "Pedro", "Juan", "Maria"};
        HashMap<Character, String> nombresSeparados = new HashMap<>();
        for(String n: nombres){

            if(nombresSeparados.containsKey(n.charAt(0))){

                String nombre = nombresSeparados.get(n.charAt(0));

                if(nombresSeparados.get(n.charAt(0)).contains(n))
                {
                    System.out.println("El nombre ya existe en el HashMap");
                }
                else
                {
                nombresSeparados.put(n.charAt(0), nombre + ", " + n);
                }
                
            }
            else{
                nombresSeparados.put(n.charAt(0), n);
            }
        }
        System.out.println(nombresSeparados);
        System.out.println("Ahora a invertirlo");
        // No se si esto es a lo que se refiere el ejercicio, pero lo que hace es invertir el HashMap
        TreeMap<Character, String> nombresSeparadosInvertidos = new TreeMap<>();
        String[] nombresSeparadosArray = new String[nombresSeparados.size()];
        char[] letras = new char[nombresSeparados.size()];
        int index = 0;
        for (Character c : nombresSeparados.keySet()) {
            nombresSeparadosArray[index] = nombresSeparados.get(c);
            letras[index] = c;
            nombresSeparadosInvertidos.put(c, nombresSeparados.get(c));
            index++;    
        }
        System.out.println(nombresSeparadosInvertidos.reversed());
    }


    private void CuentaCaracteres()
    {
        String frase = "me estoy peleando con HashMap y hashmap esta perdiendo la pelea";
        int NumerodeEspacios = 0;
        HashMap<Integer, Character> mapa = new HashMap<>();
        for(int i = 0; i < frase.length(); i++){
            char letra = frase.charAt(i);
            if (letra != ' '){
                mapa.put(i, letra);
            }
            else{
                NumerodeEspacios++;
            }
        }
        System.out.println("La frase tiene " + NumerodeEspacios + " espacios");
        System.out.println(mapa);
    }





    /*----------------------------------------DICCIONARIO------------------------------------------------------ */

    private void Diccionario(){
        HashMap<String, String> diccioario = new HashMap<>();
        // No esperen las RAE aqui, es un diccionario de ejemplo
        diccioario.put("perro", "animal cuadripedo que ladra");
        diccioario.put("gato", "animal cuadripedo que maulla");
        diccioario.put("pajaro", "animal que vuela y canta");
        diccioario.put("pez", "animal que nada y vive en el agua");
        diccioario.put("elefante", "animal grande y de trompa larga");
        System.out.println(Consulta(diccioario));
        Existe(diccioario);
        Descatalogar(diccioario);
    }

    private String Consulta(HashMap<String, String> diccioario){
        return diccioario.get("perro");
    }

    private void Existe(HashMap<String, String> diccioario)
    {
        String Buscar = "Gusalupagus";
        if(diccioario.containsKey(Buscar)){
            System.out.println("El elemento existe en el diccionario");
        }else{
            System.out.println("El elemento no existe en el diccionario");
        }
    }

    public void Descatalogar(HashMap<String, String> diccioario){
        diccioario.remove("perro");
        System.out.println(diccioario);
    }

    /*------------------------------------------------------------------------------ */

}