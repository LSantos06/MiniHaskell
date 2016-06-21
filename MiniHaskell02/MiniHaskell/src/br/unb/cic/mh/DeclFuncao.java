package br.unb.cic.mh;

import java.util.List;

/**
 * Classe usada para representar declaracoes de 
 * funcoes. 
 * 
 * @author rbonifacio
 */
public class DeclFuncao {

	private String nome;
	private List<ArgumentoFormal> argumentos;
	private Expressao corpo;
	
	public DeclFuncao(String nome, List<ArgumentoFormal> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpo = corpo; 
	}
	
	public String getNome() {
		return nome;
	}
	public List<ArgumentoFormal> getArgumentos() {
		return argumentos;
	}
	public Expressao getCorpo() {
		return corpo;
	}
	
	
}

class ArgumentoFormal {
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