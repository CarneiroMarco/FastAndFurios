package br.dev.marco.FastFuriosFood1.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;


@Entity
public class ItensPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
@JoinColumn(name = "pedido_id")
private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    
    private int qtd;
    
    private String obs;
    
    private double vUnit;

    public ItensPedido() {
    }

    public ItensPedido(Long id, Pedido pedido, Produto produto, int qtd, String obs, double vUnit) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.qtd = qtd;
        this.obs = obs;
        this.vUnit = vUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public double getvUnit() {
        return vUnit;
    }

    public void setvUnit(double vUnit) {
        this.vUnit = vUnit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItensPedido other = (ItensPedido) obj;
        return Objects.equals(this.id, other.id);
    }

   
}