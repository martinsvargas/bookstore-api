package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.martinsvargas.bookstore.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
