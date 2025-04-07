import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class B_BucleArrayList {

    public static void main(String[] args) {
        B_BucleArrayList bucle = new B_BucleArrayList();

        // ------------------------------------------
        // ArrayList<Integer> lista = new ArrayList<>();
        // lista.add(1);
        // lista.add(24);
        // lista.add(0);
        // lista.add(1,64);
        // lista.add(3,999);
        // System.out.println(bucle.ejercicio1(lista)? "Ordenado" : "No ordenado");
        // bucle.ejercicio1_5(lista);
        // ---------------------------------------

        // ArrayList<String> palindormoArrayList = new ArrayList<>();
        // palindormoArrayList.add("a");
        // palindormoArrayList.add("b");
        // palindormoArrayList.add("b");
        // palindormoArrayList.add("a");
        // bucle.ejercicio2(palindormoArrayList);

        // ----------------------------------------
        // ArrayList<Integer> MayoryMenor = new ArrayList<>();
        // MayoryMenor.add(54);
        // MayoryMenor.add(34);
        // MayoryMenor.add(4);
        // MayoryMenor.add(7);
        // MayoryMenor.add(21);
        // MayoryMenor.add(394);
        // MayoryMenor.add(-4);
        // MayoryMenor.add(0);

        // bucle.ejercicio3(MayoryMenor);
        // -------------------------------------------

        // int[][] matriz1 = {
        //         {89, 4, 27},
        //         {66, 98, 123},
        //         {122, 56, 64}
        // };
        // int[][] matriz2 = {
        //         {32, 34, 1},
        //         {9, 0, 4},
        //         {9, 1, 1}
        // };

        // bucle.ejercicio4(matriz1, matriz2);
        // bucle.ejercicio5(matriz1);
        //---------------------------------------


        // ArrayList<Integer> duplo= new ArrayList<>();
        // duplo.add(1);
        // duplo.add(2);
        // duplo.add(3);
        // duplo.add(1);
        // duplo.add(2);
        // duplo.add(2);
        // duplo.add(2);
        // bucle.ejercicio6(duplo);

        //---------------------------------------------

        // ArrayList<Integer> ceros = new ArrayList<>();
        // ceros.add(0);
        // ceros.add(1);
        // ceros.add(0);
        // ceros.add(0);
        // ceros.add(2);
        // ceros.add(0);
        // ceros.add(3);
        // ceros.add(0);
        // ceros.add(0);

        // bucle.ejercicio7(ceros);
        //-------------------------------------------

        // ArrayList<Integer> Promedio= new ArrayList<>();
        // Promedio.add(134);
        // Promedio.add(52);
        // Promedio.add(35);
        // Promedio.add(84);
        // Promedio.add(65);
        // Promedio.add(68);
        // Promedio.add(17);

        // bucle.ejercicio8(Promedio);

        //--------------------------------------------

        // ArrayList<Integer> sumaDigitos = new ArrayList<>();
        // sumaDigitos.add(123);
        // sumaDigitos.add(456);
        // sumaDigitos.add(789);
        // sumaDigitos.add(789);
        // sumaDigitos.add(786428549);
        // bucle.ejercicio9(sumaDigitos);

        //----------------------------------------------

        //bucle.ejercicio10();

    }

    // 1. Comprobar si un array está ordenado de forma ascendente
    private boolean ejercicio1(ArrayList<Integer> lista) {
        // El método tiene que recibir un array de int
        // devuelve true si están ordenados ascendentemente
        int anterior = 0;
        for (int i : lista) {
            if(anterior == 0){
                anterior = i;
            }
            else if (anterior > i){
                return false;
            } else {
                anterior = i;
            }
        }
        return true;
    }

    // ordenar de forma ascendente un array de enteros
    private boolean ejercicio1_5(ArrayList<Integer> lista)
    {
        int tamaño = lista.size();
        int i, j, temp;
        for (i = 0; i < tamaño - 1; i++) {
            for (j = 0; j < tamaño - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    // Intercambiar lista[j] y lista[j+1]
                    temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
        System.out.println("Array ordenado: " + lista);
        return true;
    }

    // 2. Comprobar si un array es palíndromo
    private void ejercicio2(ArrayList<String> palindromoArrayList) {
        boolean palindroCheck = true;
        for(int i=0; i<palindromoArrayList.size();i++){
            if(palindromoArrayList.size()%2 == 0){
                if(!palindromoArrayList.get(i).equals(palindromoArrayList.get(palindromoArrayList.size()-i-1))){
                    System.out.println("es impsible que sea un palindromo");
                    palindroCheck = false;
                    return;
                }
            }
            else{
                System.out.println("es impsible que sea un palindromo");
                palindroCheck = false;
                return;
            }
        }
        if(palindroCheck){
            System.out.println("es un palindromo");
        }
    }

    // 3. Buscar el valor máximo y mínimo en un array
    private void ejercicio3(ArrayList<Integer> lista) {
        // No puedes utilizar los métodos de Arrays
        int Mayor =0;
        int Menor = 0;
        int temp = 0;
        for(int i:lista){
            if(i>Mayor){
                Mayor = i;
            }
            if(i<Menor || temp == 0){
                Menor = i;
                temp++;
            }
        }
        System.out.println("El mayor es: " + Mayor);
        System.out.println("El menor es: " + Menor);
    }

    // 4. Sumar dos matrices 3x3
    private void ejercicio4(int [][] matriz1, int[][] matriz2) {
        // Crea una matriz con la suma de ambas
        int[][] suma = new int[3][3];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j=0 ; j<matriz1[i].length; j++){
                suma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        System.out.println("La suma de las matrices es: ");
        for(int i = 0; i < suma.length; i++) {
            for (int j=0 ; j<suma[i].length; j++){
                System.out.print(suma[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 5. Transponer una matriz 3x3
    private void ejercicio5(int[][] matriz) {
        // cambiar filas por columnas
        int[][] temp = new int[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j=0 ; j<matriz[i].length; j++){
                temp[j][i] = matriz[i][j];
            }
        }
        for(int i = 0; i < temp.length; i++) {
            for (int j=0 ; j<temp[i].length; j++){
                System.out.print(temp[i][j] + ".");
            }
            System.out.println();
        }
    }

    // 6. Eliminar duplicados de un ArrayList
    private void ejercicio6(ArrayList<Integer> lista) {
        // Deja solo una copia de cada valor
        HashSet<Integer> set = new HashSet<>(lista);
        System.out.println("Lista sin duplicados: " + set);
    }

    // 7. Eliminar ceros consecutivos duplicados
    private void ejercicio7(ArrayList<Integer> lista) {
        // Elimina los ceros consecutivos dejando uno solo
        System.out.println("Lista original: " + lista);
        boolean ceros = false;
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i)== 0 && !ceros ){
                ceros = true;
            }else if(lista.get(i) == 0 && ceros){
                lista.remove(i);
            }
        }
        System.out.println("Lista sin ceros consecutivos: " + lista);
    }

    // 8. Contar elementos mayores al promedio
    private void ejercicio8(ArrayList<Integer> lista) {
        // calcula el promedio de los números que hay en un array
        // muestra los números que son superiores a ese promedio
        int promedio = 0;
        int suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma += lista.get(i);
        }
        promedio = suma / lista.size();
        System.out.println("El promedio es: " + promedio);
        System.out.println("Los números mayores al promedio son: "); 
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > promedio) {
                System.out.println(lista.get(i));
            }
        }


    }

    // 9. Sumar los dígitos de cada número en un ArrayList<Integer>
    private void ejercicio9(ArrayList<Integer> lista) {
        // Implementa aquí tu solución
        int suma = 0;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i)>0){
                while(lista.get(i)>0){
                    suma += lista.get(i)%10;
                    lista.set(i, lista.get(i)/10);
                }
            }
        }
        System.out.println(suma);

    }

    // 10. Simular tablero 3x3 con letras aleatorias
    private void ejercicio10() {
        // Implementa aquí tu solución
        char[][] TableroLetrasRandom = new char[3][3];
        char[] letras = String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        Random R = new Random();
        for(int i = 0; i<TableroLetrasRandom.length;i++){
            for(int j=0; j<TableroLetrasRandom[i].length; j++){
                TableroLetrasRandom[i][j] = letras[R.nextInt(letras.length)];
            }
        }
        for(int i = 0; i<TableroLetrasRandom.length;i++){
            for(int j=0; j<TableroLetrasRandom[i].length; j++){
                System.out.print(TableroLetrasRandom[i][j] + " ");
            }
            System.out.println();
        }

    }
    



}