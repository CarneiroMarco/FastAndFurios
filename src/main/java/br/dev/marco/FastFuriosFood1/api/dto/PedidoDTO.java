
package br.dev.marco.FastFuriosFood1.api.dto;

import java.util.List;

public class PedidoDTO {
    
 private String nome;
    private String telefone;
    private List<ItensPedidoDTO> itens;

    public PedidoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ItensPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItensPedidoDTO> itens) {
        this.itens = itens;
    }
}
