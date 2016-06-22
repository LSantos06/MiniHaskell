package br.unb.cic.poo.main;

import java.util.HashMap;
import java.util.Stack;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.funcoes.DeclaracaoFuncao;

/**
 * @author LSantos06
 * 
 * Um ambiente de execucao possui:
 * 		- HashMap de funcoes;
 * 		- Pilha de HashMap de expressoes;
 * 		- Uma unica instancia (Singleton).
 */
public class AmbienteExecucao {
	
	private Stack<HashMap<String, Expressao>> ambiente;
	private HashMap<String, DeclaracaoFuncao> funcoes;
	
	private static AmbienteExecucao instancia; 
	
	private AmbienteExecucao() {
		ambiente = new Stack<HashMap<String, Expressao>>();
		funcoes = new HashMap<String, DeclaracaoFuncao>();
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Obtem a instancia unica da classe.
	 */
	public static AmbienteExecucao getInstancia() {
		if(instancia == null) {
			instancia = new AmbienteExecucao();
		}
		return instancia;
	}
	
	/**
	 * @author LSantos06
	 * 
	 * @return escopo atual.
	 */
	public HashMap<String, Expressao> escopo(){
		return ambiente.peek();
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Empilha o escopo no ambiente de execucao.
	 */
	public void definirEscopo() {
		ambiente.push(new HashMap<String, Expressao>());
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Desempilha o escopo do ambiente de execucao.
	 */
	public void removerEscopo() {
		if(ambiente.size() > 0) {
			ambiente.pop();
		}
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Associa uma id a uma expressao na pilha de HashMap de expressoes.
	 */
	public void declaraVariavel(String id, Expressao expressao) {
		if(ambiente.size() == 0){
			definirEscopo();
		}
		ambiente.peek().put(id, expressao);
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Verifica se o escopo possui a variavel buscada.
	 */
	public Expressao obterVariavel(String id) {
		HashMap<String, Expressao> escopo = ambiente.peek();
		if(escopo.containsKey(id)) {
			return escopo.get(id);
		}
		return null;
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Se a variavel estiver definida
	 * 		return TRUE
	 * Senao
	 * 		return FALSE
	 */
	public boolean variavelDefinida(String id){
		return ambiente.size() > 0 && ambiente.peek().containsKey(id);
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Declaracao de uma funcao, colocando a mesma no HashMap de funcoes.
	 */
	public void declaraFuncao(DeclaracaoFuncao funcao) {
		if(funcoes == null){
			funcoes = new HashMap<String, DeclaracaoFuncao>();
		}
		funcoes.put(funcao.getNome(), funcao);
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Verifica se o escopo possui a funcao buscada.
	 */
	public DeclaracaoFuncao obterFuncao(String nome) {
		if(funcoes != null){
			return funcoes.get(nome);
		}
		return null;
	}
}
