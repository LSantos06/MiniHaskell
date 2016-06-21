package br.unb.cic.poo.funcoes;

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
	private List<String> argumentos;
	private Expressao corpo;
	
	public DeclaracaoFuncao(String nome, List<String> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpo = corpo;
	}

	public String getNome() {
		return nome;
	}

	public List<String> getArgumentos() {
		return argumentos;
	}

	public Expressao getCorpo() {
		return corpo;
	}
}
