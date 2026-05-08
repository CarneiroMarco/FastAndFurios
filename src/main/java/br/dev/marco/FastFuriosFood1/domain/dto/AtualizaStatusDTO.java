
package br.dev.marco.FastFuriosFood1.domain.dto;

import br.dev.marco.FastFuriosFood1.domain.model.StatusPedido;
import jakarta.validation.constraints.NotNull;


public record AtualizaStatusDTO(@NotNull(message = "Status é obrigatório")
StatusPedido status
) {}
