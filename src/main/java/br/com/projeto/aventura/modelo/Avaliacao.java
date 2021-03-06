package br.com.projeto.aventura.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "Avaliacao")
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 5278827789832873873L;

	@EmbeddedId
	AvaliacaoChave avaliacaoChave;

	@Column(name = "estrelas", unique = false, nullable = false)
	private Integer estrelas;

	@Column(name = "descricao", unique = false, nullable = false, length = 50)
	private String descricao;

	public AvaliacaoChave getAvaliacaoChave() {
		return avaliacaoChave;
	}

	public void setAvaliacaoChave(AvaliacaoChave avaliacaoChave) {
		this.avaliacaoChave = avaliacaoChave;
	}

	public Integer getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(Integer estrelas) {
		this.estrelas = estrelas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
