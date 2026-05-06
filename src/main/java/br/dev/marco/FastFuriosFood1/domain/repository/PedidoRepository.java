
package br.dev.marco.FastFuriosFood1.domain.repository;

import br.dev.marco.FastFuriosFood1.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
