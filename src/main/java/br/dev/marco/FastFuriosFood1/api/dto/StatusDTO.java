package br.dev.marco.FastFuriosFood1.api.dto;

import br.dev.marco.FastFuriosFood1.domain.model.StatusPedido;

public class StatusDTO {
    
 private StatusPedido status;

    public StatusDTO() {
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
