
package br.dev.marco.FastFuriosFood1.domain.repository;
import br.dev.marco.FastFuriosFood1.domain.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>  {
    List<Produto> findByNome(String nome);
    List<Produto> findByNomeContaining (String nome);
    
}
