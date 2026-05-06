package FastFuriousFood.service;

import br.dev.marco.FastFuriosFood1.domain.model.ItensPedido;
import br.dev.marco.FastFuriosFood1.domain.model.Pedido;
import br.dev.marco.FastFuriosFood1.domain.model.Produto;
import br.dev.marco.FastFuriosFood1.domain.repository.PedidoRepository;
import br.dev.marco.FastFuriosFood1.domain.repository.ProdutoRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido criarPedido(List<ItensPedido> itens) {

        Pedido pedido = new Pedido();
        pedido.setData(LocalDateTime.now());

        double total = 0;

        for (ItensPedido item : itens) {
            Produto produto = produtoRepository.findById(
                item.getProduto().getId()
            ).orElseThrow();

            item.setProduto(produto);
            item.setPedido(pedido);
            item.setvUnit(produto.getPreco());

            total += item.getQtd() * item.getvUnit();
        }

        pedido.setTotal(total);
        pedido.setItens(itens);

        return pedidoRepository.save(pedido);
    }
}