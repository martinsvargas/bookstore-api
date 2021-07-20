package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.martinsvargas.bookstore.domain.Categoria;

/**
 * 
 * O primeiro parâmetro do Generic Type de JpaRepository pede o T que deve ter
 * uma Entity enviada, e no segundo parâmetro estranhamente pede o tipo da 
 * chave primária da Entity enviada no primeiro parâmetro.
 *
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
