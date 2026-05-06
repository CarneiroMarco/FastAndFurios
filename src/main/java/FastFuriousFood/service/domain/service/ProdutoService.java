package FastFuriousFood.service.domain.service;

import br.dev.marco.FastFuriosFood1.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto salvar (Produto produto){
        Produto produtoExistente = produtoRepository.
    }
}
