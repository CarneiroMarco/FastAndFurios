

package br.dev.marco.FastFuriosFood1.api.controller;

import br.dev.marco.FastFuriosFood1.domain.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProdutoController {
    
    List<Produto> listaProdutos;
    
    @GetMapping("/produtos")
    public List<Produto> listar() {

        listaProdutos = new ArrayList<Produto>();

        listaProdutos.add(new Produto(1, "X-Burguer", 15.90, "Pão, carne, queijo"));
        listaProdutos.add(new Produto(2, "Batata Frita", 10.00, "Batata, sal"));
        listaProdutos.add(new Produto(3, "Refrigerante", 6.50, "Bebida gaseificada"));

        return listaProdutos;
    }
}
