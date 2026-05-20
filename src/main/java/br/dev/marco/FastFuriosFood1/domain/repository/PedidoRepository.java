
package br.dev.marco.FastFuriosFood1.domain.repository;

import br.dev.marco.FastFuriosFood1.domain.model.Pedido;
import br.dev.marco.FastFuriosFood1.domain.model.StatusPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    List<Pedido> findByStatus(StatusPedido status);
}
