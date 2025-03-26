import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TirarDados {
    
    public static void main(String[] args) {
        TirarDados TD = new TirarDados();
        List<Integer> ResultadosTiradas;
        ResultadosTiradas = TD.LanzarDados(9999999);
        TD.RegistrarResultados(ResultadosTiradas);
        TD.AnalizarResultados(ResultadosTiradas);

    }

    private List<Integer> LanzarDados(int NTiradas){
        List<Integer> ListaDados = new ArrayList<>();
        Random Dado = new Random();
        for (int i = 0; i < NTiradas; i++) {
            ListaDados.add(Dado.nextInt(1,6) + Dado.nextInt(1,6));
        }
        return ListaDados;
    }

    private void RegistrarResultados(List<Integer> Lista){
        for (int N : Lista) {
            System.out.println("hay: " + N);
        }
    }
    
    private void AnalizarResultados(List<Integer> Lista){
        int[] Contador = new int[13];


        for (int N : Lista) {
            Contador[N]++;
        }

        for (int i = 2; i <= 12; i++) {
            System.err.println("Ha salido el " + i + ": " + Contador[i]/* + GenerarAsteriscos(Contador[i])*/);
        }

       /*Collections.sort(Lista);
        System.out.println(Lista);*/
    }

    private String GenerarAsteriscos(int GA)
    {
        String Asteriscos = " | " + "*".repeat(GA);
        return Asteriscos;
    }

}
