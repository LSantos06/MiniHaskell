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
	/**Construtor default para o caso de precisar instanciar o objeto
	 *mas nao ter nome, argumentos e corpo.Inicia a lista de argumentos da funcao como uma lista vazia
	 * @author PedroAcA
	 */
	public DeclaracaoFuncao() {
		this.argumentos = new ArrayList<ArgumentoFormal>();
	}
	/** Construtor para o caso deter nome, argumentos e corpo ao instanciar o objeto.
	 * @author PedroAcA
	 * @param nome Nome da Funcao
	 * @param argumentos Lista de argumentos necessarios para a funcao
	 * @param corpo Corpo da funcao
	 */
	public DeclaracaoFuncao(String nome, List<ArgumentoFormal> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpo = corpo;
	}

	/** Obtem o nome da funcao declarada
	 *  @author PedroAcA
	 * @return nome Nome da funcao
	 */
	public String getNome() {
		return nome;
	}

	/** Obtem a lista de argumentos necessarios para a funcao.
	 *  @author PedroAcA
	 * @return argumentos Lista de argumentos necessarios para a funcao 
	 */
	public List<ArgumentoFormal> getArgumentos() {
		return argumentos;
	}
	
	/**Obtem o corpo da funcao
	 *  @author PedroAcA
	 * @return corpo Corpo da funcao declarada
	 */
	public Expressao getCorpo() {
		return corpo;
	}
	
	/** Inicia o nome da funcao
	 *  @author PedroAcA
	 * @param nome Nome da funcao 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**Carrega a lista de argumentos necessarios para a funcao 
	 * @author PedroAcA
	 * @param  argumentos Lista de argumentos formais a ser adicionada  
	 */	
	public void setArgumentos(List<ArgumentoFormal> argumentos) {
		this.argumentos = argumentos;
	}
	
	/** Adiciona à lista de argumentos um dos argumentos definidos para a funcao 
	 * @author PedroAcA
	 * @param argumento Argumento formal a ser adicionado 
	 */
	public void setArgumento(ArgumentoFormal argumento) {
		this.argumentos.add(argumento);
	}
	
	/** Inicia o corpo da funcao
	 *  @author PedroAcA
	 * @param corpo Corpo da funcao 
	 */
	public void setCorpo(Expressao corpo) {
		this.corpo = corpo;
	}


}