package br.dev.marco.FastFuriosFood1.api.controller;




import br.dev.marco.FastFuriosFood1.domain.model.Pedido;
import br.dev.marco.FastFuriosFood1.domain.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // GET - Listar todos os pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    // GET - Buscar pedido por ID
    @GetMapping("/{pedidoID}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long pedidoID) {

        Optional<Pedido> pedido = pedidoRepository.findById(pedidoID);

        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        }

        return ResponseEntity.notFound().build();
    }

    // POST - Criar pedido
    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    // PUT - Atualizar pedido
    @PutMapping("/{pedidoID}")
    public ResponseEntity<Pedido> atualizar(
            @PathVariable Long pedidoID,
            @RequestBody Pedido pedido) {

        Optional<Pedido> pedidoAtual = pedidoRepository.findById(pedidoID);

        if (pedidoAtual.isPresent()) {
            pedido.setId(pedidoID);
            Pedido pedidoSalvo = pedidoRepository.save(pedido);
            return ResponseEntity.ok(pedidoSalvo);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE - Excluir pedido
    @DeleteMapping("/{pedidoID}")
    public ResponseEntity<Void> excluir(@PathVariable Long pedidoID) {

        Optional<Pedido> pedido = pedidoRepository.findById(pedidoID);

        if (pedido.isPresent()) {
            pedidoRepository.deleteById(pedidoID);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}