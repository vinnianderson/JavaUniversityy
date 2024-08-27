package src;
import java.util.Scanner;
public class Pessoa{
    Scanner sc = new Scanner(System.in);
 String nome;
 int idade;
 Pessoa(String nome, int idade){
    this.nome = nome;
    this.idade = idade;
 }
 public void apresentarP(){
    System.out.println("Meu nome é " + this.nome + "eu tenho " + this.idade + " Anos");
 }
 @Override
 public String toString(){
    return "Nome " + nome + "Idadee: " + idade;
 }
}