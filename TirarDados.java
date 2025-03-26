import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TirarDados {
    
    public static void main(String[] args) {
        TirarDados TD = new TirarDados();
        List<Integer> ResultadosTiradas;
        ResultadosTiradas = TD.LanzarDados(123);
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
        int D2 = 0;
        int D3 = 0;
        int D4 = 0;
        int D5 = 0;
        int D6 = 0;
        int D7 = 0;
        int D8 = 0;
        int D9 = 0;
        int D10 = 0;
        int D11 = 0;
        int D12 = 0;
        for (int N : Lista) {
            switch (N) {
                case 2 -> D2++;
                case 3 -> D3++;
                case 4 -> D4++;
                case 5 -> D5++;
                case 6 -> D6++;
                case 7 -> D7++;
                case 8 -> D8++;
                case 9 -> D9++;
                case 10 -> D10++;
                case 11 -> D11++;
                case 12 -> D12++;
                default -> throw new AssertionError();
            }
        }
        System.out.println("Ha salido el 2: " + D2 +  GenerarAsteriscos(D2));
        System.out.println("Ha salido el 3: " + D3 +  GenerarAsteriscos(D3));
        System.out.println("Ha salido el 4: " + D4 +  GenerarAsteriscos(D4));
        System.out.println("Ha salido el 5: " + D5 +  GenerarAsteriscos(D5));
        System.out.println("Ha salido el 6: " + D6 +  GenerarAsteriscos(D6));
        System.out.println("Ha salido el 7: " + D7 +  GenerarAsteriscos(D7));
        System.out.println("Ha salido el 8: " + D8 +  GenerarAsteriscos(D8));
        System.out.println("Ha salido el 9: " + D9 +  GenerarAsteriscos(D9));
        System.out.println("Ha salido el 10: " + D10 +  GenerarAsteriscos(D10));
        System.out.println("Ha salido el 11 " + D11 +  GenerarAsteriscos(D11));
        System.out.println("Ha salido el 12: " + D12 +  GenerarAsteriscos(D12));

        Collections.sort(Lista);
        System.out.println(Lista);
    }

    private String GenerarAsteriscos(int GA)
    {
        String Asteriscos = " | ";
        for (int i = 0; i < GA; i++) {
            Asteriscos += "*";
        }
        return Asteriscos;
    }

}
