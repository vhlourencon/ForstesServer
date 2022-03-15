package br.com.fortes.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity(name = "filme")
public class FilmeModel extends GenericModel {

	private String nome;
	private String descricao;
	private Integer anoDeLancamento;
	private Double valor;
	
	
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(Integer anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
