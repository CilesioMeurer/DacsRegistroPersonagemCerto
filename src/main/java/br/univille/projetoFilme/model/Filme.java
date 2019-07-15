package br.univille.projetoFilme.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(length=1000)
	private String personagem;
	@Column(length=1000)
	private String obra;
	@Column(length=1000)
	private String genero;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPersonagem() {
		return personagem;
	}
	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}
	public String getObra() {
		return obra;
	}
	public void setObra(String obra) {
		this.obra = obra;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
