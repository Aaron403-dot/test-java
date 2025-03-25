import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TirarDados {
    
    public static void main(String[] args) {
        TirarDados TD = new TirarDados();
        List<Integer> ResultadosTiradas = new ArrayList<>();
        ResultadosTiradas = TD.LanzarDados(23);
        TD.RegistrarResultados(ResultadosTiradas);
        TD.AnalizarResultados(ResultadosTiradas);

    }

    private List LanzarDados(int NTiradas){
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
        String D2Asterisk = "";
        int D3 = 0;
        String D3Asterisk = "";
        int D4 = 0;
        String D4Asterisk = "";
        int D5 = 0;
        String D5Asterisk = "";
        int D6 = 0;
        String D6Asterisk = "";
        int D7 = 0;
        String D7Asterisk = "";
        int D8 = 0;
        String D8Asterisk = "";
        int D9 = 0;
        String D9Asterisk = "";
        int D10 = 0;
        String D10Asterisk = "";
        int D11 = 0;
        String D11Asterisk = "";
        int D12 = 0;
        String D12Asterisk = "";
        for (int N : Lista) {
            switch (N) {
                case 2 -> {D2++; D2Asterisk += "*";}
                case 3 -> {D3++; D3Asterisk += "*";}
                case 4 -> {D4++; D4Asterisk += "*";}
                case 5 -> {D5++; D5Asterisk += "*";}
                case 6 -> {D6++; D6Asterisk += "*";}
                case 7 -> {D7++; D7Asterisk += "*";}
                case 8 -> {D8++; D8Asterisk += "*";}
                case 9 -> {D9++; D9Asterisk += "*";}
                case 10 -> {D10++; D10Asterisk += "*";}
                case 11 -> {D11++; D11Asterisk += "*";}
                case 12 -> {D12++; D12Asterisk += "*";}
                default -> throw new AssertionError();
            }
        }
        System.out.println("Ha salido el 2: " + D2 + " " + D2Asterisk);
        System.out.println("Ha salido el 3: " + D3 + " " + D3Asterisk);
        System.out.println("Ha salido el 4: " + D4 + " " + D4Asterisk);
        System.out.println("Ha salido el 5: " + D5 + " " + D5Asterisk);
        System.out.println("Ha salido el 6: " + D6 + " " + D6Asterisk);
        System.out.println("Ha salido el 7: " + D7 + " " + D7Asterisk);
        System.out.println("Ha salido el 8: " + D8 + " " + D8Asterisk);
        System.out.println("Ha salido el 9: " + D9 + " " + D9Asterisk);
        System.out.println("Ha salido el 10: " + D10 + " " + D10Asterisk);
        System.out.println("Ha salido el 11 " + D11 + " " + D11Asterisk);
        System.out.println("Ha salido el 12: " + D12 + " " + D12Asterisk);

        Collections.sort(Lista);
        System.out.println(Lista);
        
    }

}
