package br.unb.cic.poo.funcoes;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.poo.expressoes.Expressao;

/**
 * @author LSantos06
 * 
 * Classe que representa a declaracao de uma funcao na linguagem.
 * Uma funcao possui:
 * 		- Nome;
 * 		- Argumentos;
 * 		- Corpo.
 */
public class DeclaracaoFuncao {
	
	private String nome;
	private List<ArgumentoFormal> argumentos;
	private Expressao corpo;
	
	/**
	 * @author PedroAcA
	 * 
	 * Construtor default.
	 * 
	 * Inicia a lista de argumentos da funcao como uma lista vazia. 
	 */
	public DeclaracaoFuncao() {
		this.argumentos = new ArrayList<ArgumentoFormal>();
	}
	
	/** 
	 * @author PedroAcA
	 * 
	 * Construtor que seta o nome, lista de argumentos e o corpo.
	 * 
	 * @param nome Nome da Funcao.
	 * @param argumentos Lista de argumentos da funcao.
	 * @param corpo Corpo da funcao.
	 */
	public DeclaracaoFuncao(String nome, List<ArgumentoFormal> argumentos, Expressao corpo) {
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
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setArgumentos(List<ArgumentoFormal> argumentos) {
		this.argumentos = argumentos;
	}
	
	/**
	 * @author PedroAcA
	 * 
	 * Adiciona um argumento a lista de argumentos da funcao.
	 */
	public void setArgumento(ArgumentoFormal argumento) {
		this.argumentos.add(argumento);
	}
	
	public void setCorpo(Expressao corpo) {
		this.corpo = corpo;
	}

}