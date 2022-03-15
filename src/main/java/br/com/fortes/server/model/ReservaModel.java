package br.com.fortes.server.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity(name = "reserva")
public class ReservaModel extends GenericModel {

	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_filme")
	private FilmeModel filme;

	private Date dataDeLocacao; 
	private Date dataDeEntrega; 
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FilmeModel getFilme() {
		return filme;
	}

	public void setFilme(FilmeModel filme) {
		this.filme = filme;
	}

	public Date getDataDeLocacao() {
		return dataDeLocacao;
	}

	public void setDataDeLocacao(Date dataDeLocacao) {
		this.dataDeLocacao = dataDeLocacao;
	}

	public Date getDataDeEntrega() {
		return dataDeEntrega;
	}

	public void setDataDeEntrega(Date dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	

}
