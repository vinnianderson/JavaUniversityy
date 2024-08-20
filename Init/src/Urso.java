package src;
import java.util.Scanner;
public class Urso {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número");
        int numero = sc.nextInt();
        switch(numero){
            case 1:
            System.out.println("UM");
            break;
             case 2:
            System.out.println("DOIS");
            break;
             case 3:
             System.out.println("Tres");
            
            break;
            case 4:
            System.out.println("Quatro");
            
            break;
             case 5:
        System.out.println("Cinco");
            break;
            case 6:
            System.out.println("Seis");
            break;
            case 7:
            System.out.println("SETE");
            break;
             case 8:
            System.out.println("OITO");
            break;
            case 9:
            System.out.println("NOVE");
            break;
    

        }
        sc.close();
    }
    
}
