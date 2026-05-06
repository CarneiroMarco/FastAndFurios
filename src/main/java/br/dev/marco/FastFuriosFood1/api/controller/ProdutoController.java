package br.dev.marco.FastFuriosFood1.api.controller;

import br.dev.marco.FastFuriosFood1.domain.model.Produto;
import br.dev.marco.FastFuriosFood1.domain.repository.ProdutoRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produto/{produtoID}")
    public ResponseEntity<Produto> buscar(@PathVariable Long produtoID) {
        Optional<Produto> produto = produtoRepository.findById(produtoID);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();

        }
            }
    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@Valid @RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
    
    
    
    @PutMapping("/produto/{produtoID}")
public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long produtoID,
                                         @RequestBody Produto produto) {

    // Verifica se o produto existe
    if (!produtoRepository.existsById(produtoID)) {
        return ResponseEntity.notFound().build();
    }

    produto.setId(produtoID);
    produto = produtoRepository.save(produto);
    return ResponseEntity.ok(produto);
}
@DeleteMapping("/produto/{produtoID}")
public ResponseEntity<Void> excluir(@PathVariable Long produtoID) {

    // Verifica se o produto existe ou não
    if (!produtoRepository.existsById(produtoID)) {
        return ResponseEntity.notFound().build();
    }

    produtoRepository.deleteById(produtoID);
    return ResponseEntity.noContent().build();
}   
}
