package br.com.fortes.server.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Service;

@Table
@Entity(name = "filme")
@Service
public class FilmeModel extends GenericModel {

	private String nome;
	private String descricao;
	private String imagem;
	private String categoria;
	private Integer duracao;
	private Double preco;
	private Integer anoDeLancamento;
	private Integer avaliacao;
	private boolean alugado; 
	private String dataDevolucao;
	
	
	



	










	public String getDataDevolucao() {
		return dataDevolucao;
	}










	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}










	public FilmeModel() {
		
	}


	
	

	




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

	

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}










	public boolean isAlugado() {
		return alugado;
	}










	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}



	
	
	

}
