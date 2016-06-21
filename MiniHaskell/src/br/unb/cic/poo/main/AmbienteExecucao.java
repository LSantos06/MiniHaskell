package br.unb.cic.poo.main;

import java.util.HashMap;
import java.util.Stack;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.funcoes.DeclaracaoFuncao;

public class AmbienteExecucao {
	
	private Stack<HashMap<String, Expressao>> ambiente;
	private HashMap<String, DeclaracaoFuncao> funcoes;
	
	private static AmbienteExecucao instancia; 
	
	private AmbienteExecucao() {
		ambiente = new Stack<HashMap<String, Expressao>>();
		funcoes = new HashMap<String, DeclaracaoFuncao>();
	}
	
	public static AmbienteExecucao getInstance() {
		if(instancia == null) {
			instancia = new AmbienteExecucao();
		}
		return instancia;
	}
	
	public void declaraVariavel(String nome, Expressao expressao) {
		ambiente.peek().put(nome, expressao);
	}
	
	public void declaraFuncao(DeclaracaoFuncao funcao) {
		funcoes.put(funcao.getNome(), funcao);
	}
	
	public Expressao consultaReferencia(String nome) {
		int topo = ambiente.size()-1;
		for(int i = topo; i >= 0; i--) {
			if(ambiente.get(i).containsKey(nome)) {
				return ambiente.get(i).get(nome);
			}
		}
		return null;
	}
	
	public DeclaracaoFuncao consultaFuncao(String nome) {
		return funcoes.get(nome);
	}
 	
	public void push() {
		ambiente.push(new HashMap<String, Expressao>());
	}
	
	public void pop() {
		ambiente.pop();
	}

}
