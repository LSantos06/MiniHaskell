package br.unb.cic.poo.funcoes;

import br.unb.cic.poo.valores.Tipo;

/**
 * @author LSantos06
 * 
 * Argumento formal eh usado para representar os argumentos de
 * funcoes na linguagem, estes possuem:
 * 		- ID;
 * 		- Tipo.
 */
public class ArgumentoFormal {
	private String id;
	private Tipo tipo;
	
	public ArgumentoFormal(String id, Tipo tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	public String getId() {
		return id;
	}
	
	public Tipo getTipo() {
		return tipo;
	} 
}
