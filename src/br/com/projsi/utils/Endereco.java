package br.com.projsi.utils;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

  private String estado;
  private String cidade;
  private String rua;
  private String numero;
  private String bairro;
  private String complemento;
  private String cep;
  private String nacionalidade;

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
  
  public String getNacionalidade() {
		return nacionalidade;
	}

  public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
  }

@Override
public String toString() {
	return "Endereco [estado=" + estado + ", cidade=" + cidade + ", rua=" + rua + ", numero=" + numero + ", bairro="
			+ bairro + ", complemento=" + complemento + ", cep=" + cep + ", nacionalidade=" + nacionalidade + "]";
}
}
