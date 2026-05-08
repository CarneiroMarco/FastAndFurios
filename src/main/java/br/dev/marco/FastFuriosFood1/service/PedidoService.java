package br.dev.marco.FastFuriosFood1.service;

import br.dev.marco.FastFuriosFood1.domain.model.ItensPedido;
import br.dev.marco.FastFuriosFood1.domain.model.Pedido;
import br.dev.marco.FastFuriosFood1.domain.model.Produto;
import br.dev.marco.FastFuriosFood1.domain.model.StatusPedido;
import br.dev.marco.FastFuriosFood1.domain.repository.PedidoRepository;
import br.dev.marco.FastFuriosFood1.domain.repository.ProdutoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

     @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido criarPedido(Pedido pedido) {

        pedido.setStatus(StatusPedido.ABERTO);
        pedido.setData(LocalDateTime.now());
        

        double total = 0;

        for (ItensPedido item : pedido.getItens()) {
            Produto produto = produtoRepository.findById(
                item.getProduto().getId()
            ).orElseThrow();

            item.setProduto(produto);
            item.setPedido(pedido);
            item.setvUnit(produto.getPreco());

            total += item.getQtd() * item.getvUnit();
        }

        pedido.setTotal(total);
        
        return pedidoRepository.save(pedido);
    }
    public Optional<Pedido> atualizaStatus(Long pedidoId, StatusPedido status){
        
        Optional<Pedido> optPedido = pedidoRepository.findById(pedidoId);
    }
}