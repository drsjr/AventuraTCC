package br.com.projeto.aventura.modelo.abstrato;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.projeto.aventura.modelo.Posicao;

@Entity(name = "Unidade")
@Inheritance(strategy = InheritanceType.JOINED)
public class Unidade implements Serializable {

	private static final long serialVersionUID = 6358504224612539869L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idUnidade;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idUnidade")
	Posicao posicao;

	public Long getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Long idUnidade) {
		this.idUnidade = idUnidade;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
