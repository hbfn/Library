package br.com.projsi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.projsi.utils.Contato;
import br.com.projsi.utils.Endereco;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String salario;
	private String cargo;
	private String nome;
	private String sexo;
	private String tipoDocumento;
	private String numeroDocumento;
	private boolean status;
	private Date nascimento;
	private Endereco endereco;
	private Contato contato;

	public Funcionario() {
		this.contato = new Contato();
		this.endereco = new Endereco();
	}
	
	public Funcionario(String nome, Date nascimento,  Endereco endereco, Contato contato, boolean status, String cargo, String salario) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.contato = contato;
		this.status = true;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	
	public String getSalario() {
		return salario;
	}
	
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", salario=" + salario + ", cargo="
				+ cargo + ", nome=" + nome + ", sexo=" + sexo + ", tipoDocumento=" + tipoDocumento
				+ ", numeroDocumento=" + numeroDocumento + ", status=" + status + ", nascimento=" + nascimento
				+ ", endereco=" + endereco + ", contato=" + contato + "]";
	}
	
	public String[] getLinhaFuncionario() {
		return new String[] { String.valueOf(getId()), getNome(), getSexo(), getCargo(), getSalario(), String.valueOf(getNascimento()), getEndereco().getNacionalidade(), getTipoDocumento(), getNumeroDocumento(), getContato().getContato(), getContato().getContato2(),
				String.valueOf(getStatus()), getEndereco().getCidade(), getEndereco().getBairro(), getEndereco().getRua(), getEndereco().getCep(), getEndereco().getNumero(), getEndereco().getComplemento(), getEndereco().getEstado(),};
	}
}
