package br.dev.marco.FastFuriosFood1.domain.model;

public class Produto {
    private long id;
    private String nome;
    private double preco;
    private String ingrediente;

    public Produto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Produto(long id, String nome, double preco, String ingrediente) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.ingrediente = ingrediente;
    }
} 


