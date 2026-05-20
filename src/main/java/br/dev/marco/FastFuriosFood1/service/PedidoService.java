package br.dev.marco.FastFuriosFood1.service;

import br.dev.marco.FastFuriosFood1.api.dto.ItensPedidoDTO;
import br.dev.marco.FastFuriosFood1.api.dto.PedidoDTO;
import br.dev.marco.FastFuriosFood1.domain.model.ItensPedido;
import br.dev.marco.FastFuriosFood1.domain.model.Pedido;
import br.dev.marco.FastFuriosFood1.domain.model.Produto;
import br.dev.marco.FastFuriosFood1.domain.model.StatusPedido;
import br.dev.marco.FastFuriosFood1.domain.repository.PedidoRepository;
import br.dev.marco.FastFuriosFood1.domain.repository.ProdutoRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos os pedidos
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    // Buscar pedido por ID
    public Pedido buscarOuFalhar(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Pedido não encontrado"));
    }

    // Criar pedido
    public Pedido criar(PedidoDTO dto) {

        Pedido novoPedido = new Pedido();
        List<ItensPedido> itensNovoPedido = new ArrayList<>();
        
        novoPedido.setStatus(StatusPedido.ABERTO);

        for (ItensPedidoDTO itemDTO : dto.getItens()) {

            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.BAD_REQUEST,
                                    "Produto não encontrado"));

            ItensPedido item = new ItensPedido();            
            item.setProduto(produto);
            item.setQtd(itemDTO.getQtd());
            item.setvUnit(produto.getPreco());
            itensNovoPedido.add(item);
        }
        novoPedido.setItens(itensNovoPedido);
        return pedidoRepository.save(novoPedido);
    }

    // Atualizar pedido
    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {

        Pedido existente = buscarOuFalhar(id);
        List<ItensPedido> itensPedido = new ArrayList<>();
        
        if (pedidoAtualizado.getItens() == null
                || pedidoAtualizado.getItens().isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Pedido sem itens");
        }

        existente.getItens().clear();

        
        
        for (ItensPedido item : pedidoAtualizado.getItens()) {

            if (item.getProduto() == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Produto obrigatório");
            }

            Produto produto = produtoRepository
                    .findById(item.getProduto().getId())
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.BAD_REQUEST,
                                    "Produto não encontrado"));

            item.setProduto(produto);
            item.setvUnit(produto.getPreco());
            itensPedido.add(item);
        }
            existente.setItens(itensPedido);

        return pedidoRepository.save(existente);
    }

    // Cancelar pedido
    public Pedido cancelar(Long id) {

        Pedido pedido = buscarOuFalhar(id);

        if (pedido.getStatus() == StatusPedido.ENTREGUE) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Pedido já entregue não pode ser cancelado");
        }

        pedido.setStatus(StatusPedido.CANCELADO);

        return pedidoRepository.save(pedido);
    }

    // Buscar por status
    public List<Pedido> buscarPorStatus(StatusPedido status) {
        return pedidoRepository.findByStatus(status);
    }

    // Atualizar status
    public Pedido atualizarStatus(Long id, StatusPedido novoStatus) {

        Pedido pedido = buscarOuFalhar(id);

        if (pedido.getStatus() == StatusPedido.ABERTO
                && novoStatus == StatusPedido.PRONTO) {

            pedido.setStatus(novoStatus);

        } else if (pedido.getStatus() == StatusPedido.PRONTO
                && novoStatus == StatusPedido.ENTREGUE) {

            pedido.setStatus(novoStatus);

        } else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Transição de status inválida");
        }

        return pedidoRepository.save(pedido);
    }
}