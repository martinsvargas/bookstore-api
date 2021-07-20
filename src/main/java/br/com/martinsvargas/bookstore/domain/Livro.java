package br.com.martinsvargas.bookstore.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * Neste caso o nome da tabela não foi especificado na @Entity annotation (name = "livro") e sendo assim,
 * o framework considera o nome da Entity em minúsculo.
 *
 */
@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String nomeAutor;
	private String texto;
	
	/**
	 * No Doctrine eu declarava inversedBy, dentro de ManyToOne para apontar qual atributo
	 * em Categoria mapeia os Livros, inclusive o Livro em questão. 
	 * Aqui, utilizando o javax.persistence, eu não aponto qual atributo na classe Categoria
	 * mapeia os livros, ou seja, não existe a ideia de inversedBy. Em outras palavras, eu 
	 * não cito o atributo "livros" de Categoria em momento algum. Aqui, no lado owning side
	 * eu simplesmente aponto o nome da chave estrangeira na tabela "livro", neste caso 
	 * "categoria_id", que obviamente vai apontar para a chave estrangeira de Categoria.
	 */
	@ManyToOne
	@JoinColumn(name = "categoria_id") // Por padrão ele cria categoria_id porém, deixei declarado para fins de estudo.
	private Categoria categoria;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
