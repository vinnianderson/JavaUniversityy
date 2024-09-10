package BibliotecaPoo;

import java.util.ArrayList;
import java.util.List;

import src.Livro;

public class autor{
private String nome;
private String dataNascimento;
private List<Livro> livros;



public autor(String nome, String dataNascimento) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.livros = new ArrayList<>();
}
public String getNome(){
return nome;
}
public String dataNascimento(){
    return dataNascimento;
}
public void adicionarLivro(Livro livro){
    livros.add(livro);
}

}
