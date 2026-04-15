package br.dev.marco.FastFuriosFood1.domain.model;

public class ItensPedido {
    private long id;
    private String tipoProduto;
    private int qtd;
    private double unit;

    public ItensPedido() {
    }

    public ItensPedido(long id, String tipoProduto, int qtd, double unit) {
        this.id = id;
        this.tipoProduto = tipoProduto;
        this.qtd = qtd;
        this.unit = unit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
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
        return this.id == other.id;
    }
}