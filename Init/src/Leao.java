package src;

import java.util.Scanner;

public class Leao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual é a sua idade ");
        int idade = sc.nextInt();
        if (idade >= 18) {
            System.out.println("Pode ser preso");
        } else {
            System.out.println("Não pode ser preso");
        }
    
    if(idade <= 12){
        System.out.println("Você é uma criança");
    } else{
        System.out.println("Você é adolescente");

    }
           sc.close();
}
};

