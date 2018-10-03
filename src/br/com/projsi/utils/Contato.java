package br.com.projsi.utils;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {
	
	private String Contato;
	private String Contato2;

	public String getContato() {
		return Contato;
	}

	public void setContato(String contato1) {
		Contato = contato1;
	}

	public String getContato2() {
		return Contato2;
	}

	public void setContato2(String contato2) {
		Contato2 = contato2;
	}

	@Override
	public String toString() {
		return "Contato [Contato=" + Contato + ", Contato2=" + Contato2 + "]";
	}
}
