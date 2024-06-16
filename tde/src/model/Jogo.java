package model;

public class Jogo {

    private int id;
    private String desenvolvedor;
    private String nome;
    private int ano;
    private String categoria;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Jogo(int id, String desenvolvedor, String nome, int ano, String categoria, double preco) {
        this.id = id;
        this.desenvolvedor = desenvolvedor;
        this.nome = nome;
        this.ano = ano;
        this.categoria = categoria;
        this.preco = preco;
    }
}
