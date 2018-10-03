package br.com.projsi.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue
	private Long id;
	private Date data;
	private Date dataEntrega;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Livro livro;
	
	public Emprestimo() {
	}
	
	public Emprestimo(Long id, Date data, Date dataEntrega, Usuario usuario, Livro livro) {
		this.id = id;
		this.data = data;
		this.dataEntrega = dataEntrega;
		this.usuario = usuario;
		this.livro = livro;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public String[] getLinhaEmprestimo() {
		return new String[] { String.valueOf(getId()), String.valueOf(getData()), String.valueOf(getDataEntrega()), String.valueOf(getUsuario().getId()), String.valueOf(getLivro().getId()),};
	}
}
