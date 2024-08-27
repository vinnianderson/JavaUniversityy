package src;

public class App {
  
    public static void main(String[] args){
    App application = new App();
    Pessoa pessoa = new Pessoa("Vinicius ", 19);
    System.out.println(pessoa);
    System.out.println("Nome: " + pessoa.nome + "\n" + "idade: " + pessoa.idade);
    Livro livro = new Livro("InterEstelar", 822);


pessoa.apresentarP();

    };
   
}
