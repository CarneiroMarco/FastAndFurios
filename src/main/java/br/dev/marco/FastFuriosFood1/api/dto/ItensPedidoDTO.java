package br.dev.marco.FastFuriosFood1.api.dto;


public class ItensPedidoDTO {
    private Long produtoId;
    private int qtd;
    private String obs;

    public ItensPedidoDTO() {
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
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

}
