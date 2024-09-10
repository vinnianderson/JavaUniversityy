package src;
import java.util.Scanner;
public class Pessoa{
    Scanner sc = new Scanner(System.in);
  private String nome;
 private int idade;
 Pessoa(String nome, int idade){
    this.nome = nome;
    this.idade = idade;
 }
 public String getNome(){
   return nome;
 }
 public void setNome(String Nome){
   this.nome = nome;
 }
 public int getIdade(){
   return idade;
 }
 public void setIdade(int idade){
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