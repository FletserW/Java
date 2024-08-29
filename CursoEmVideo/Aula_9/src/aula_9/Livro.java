/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula_9;

/**
 *
 * @author reido
 */
public class Livro implements Publicacao{
    private String titulo;
    private String autor;
    private int tolPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int tolPaginas, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.tolPaginas = tolPaginas;
        this.aberto = false;
        this.pagAtual = 0;
        this.leitor = leitor;
    }
    

    public String detalhes() {
        return "Livro{" + "titulo=" + titulo + ",\n autor=" + autor + ",\n tolPaginas=" + tolPaginas + ",\n pagAtual=" + pagAtual + ",\n aberto=" + aberto + ",\n leitor=" + leitor.getNome() + '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTolPaginas() {
        return tolPaginas;
    }

    public void setTolPaginas(int tolPaginas) {
        this.tolPaginas = tolPaginas;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    @Override
    public void abrir() {
        this.aberto = true;
    }

    @Override
    public void fechar() {
        this.aberto = false;
    }

    @Override
    public void folhar(int p) {
        if( p > this.tolPaginas){
            this.pagAtual = 0;
        }else{
        this.pagAtual = p;
        }
    }

    @Override
    public void avancarPagina() {
        this.pagAtual++;
    }

    @Override
    public void voltarPagina() {
        this.pagAtual--;
    }
    
}
