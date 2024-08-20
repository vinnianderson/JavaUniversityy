package src;
import java.util.Scanner;

public class Hipopotamo {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   System.out.println("Digite a potência de A");
    double a = sc.nextDouble();
    System.out.println("Digite a potência de B");
    double b = sc.nextDouble();
    double resultado = Math.pow(a, b);
    System.out.println(resultado);
    System.out.println("************************************************");

  }
}