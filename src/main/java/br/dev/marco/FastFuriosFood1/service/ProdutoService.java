package br.dev.marco.FastFuriosFood1.service;

import br.dev.marco.FastFuriosFood1.domain.model.Produto;
import br.dev.marco.FastFuriosFood1.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto salvar (Produto produto){
        return produtoRepository.save(produto);
    }
    public void excluir(Long produtoId){
        produtoRepository.deleteById(produtoId);
    }
    
    
}
