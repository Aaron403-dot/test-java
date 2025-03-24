
public class basicodejava {

    public static int intfinito=0;


    public static void main(String[] args) {
        System.out.println("Hola mundo");
        System.out.println(limite());
    }

    public static int limite(){
        
        try{
            while (intfinito != Integer.MAX_VALUE) {
                intfinito+=1;
            }
        }
        catch(Exception a){

        }
        return intfinito;
    }


}