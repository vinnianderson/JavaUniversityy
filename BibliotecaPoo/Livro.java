package BibliotecaPoo;

  public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true; // Inicialmente, o livro está disponível
    }
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getIsbn(){
        return isbn;

    }
    public int getAnoPublicacao(){
        return anoPublicacao;

    }
    public boolean isDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
}