package br.unb.cic.poo.funcoes;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.poo.valores.Tipo; 
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.visitor.Visitor;
import br.unb.cic.poo.main.AmbienteExecucao;
import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.main.*;
 
/**
 * @author PedroAcA
 * 
 * Classe que representa a chamada de uma funcao na linguagem.
 * Uma chamda de funcao possui:
 * 		- Nome;
 * 		- Parametros;
 */
public class AvaliadorExpressoes implements Expressao {

	private String nome; 
	private List<Expressao> parametros;
	
	/**
	 * @author PedroAcA  
	 * 
	 * Construtor default.
	 * 
	 * Inicia a lista de parametros como uma lista vazia.
	 */
	public AvaliadorExpressoes() {
		this.parametros = new ArrayList<Expressao>();
	}
	
	/**
	 * @author PedroAcA
	 * 
	 * Construtor que seta o nome e a lista de argumentos.
	 * 
	 * @param nome Nome da funcao.
	 * @param argumentos Lista de argumentos da funcao.
	 */
	public AvaliadorExpressoes(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.parametros = argumentos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Expressao> getParametros() {
		return parametros;
	}

	public void setParametros(List<Expressao> parametros) {
		this.parametros = parametros;
	}
	
	/**
	 * @author PedroAcA
	 * 
	 * Adiciona um parametro a lista de parametros da funcao.
	 */
	public void setParametro(Expressao parametro) {
		this.parametros.add(parametro);
	}
	
	/** 
	 * @author PedroAcA
	 * 
	 * Compara cada elemento da funcao declarada e ve se eles sao diferentes. 
	 * Se forem diferentes
	 * 		return ERRO 
	 * Senao 
	 * 		return FUNCAO
	 */
	@Override
	public Tipo tipo() {
		DeclaracaoFuncao funcao = AmbienteExecucao.getInstancia().obterFuncao(nome);
		ArgumentoFormal argumento;
		
		for (Expressao e: parametros){
			argumento = funcao.getArgumentos().get(parametros.indexOf(e));
			
			if(!e.tipo().equals(argumento.getTipo())){
				System.out.println("Erro no parametro" + argumento.getId() + ". Esperava tipo" + argumento.getTipo()+ 
						"mas tipo atual " + e.tipo());
				return Tipo.ERRO;
			}
		}
		return Tipo.FUNCAO;
	}
	
	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.FUNCAO);
	}

	/** 
	 * @author PedroAcA
	 * 
	 * Analisa o valor da funcao e retornar um dos tipos definidos como valores: inteiro,
	 * booleano, lista.
	 * 
	 * @throws RunTimeException caso nao tenha sido declarado nenhuma funcao com aquele nome.
	 * @throws RunTimeException caso a lista de parametros da funcao chamada seja menor do que a lista 
	 * de argumentos declarados. 
	 * @throws RunTimeException caso a lista de parametros da funcao chamada seja maior do que a lista 
	 * de argumentos declarados. 
	 * @throws RunTimeException caso haja um erro de tipo.
	 * 
	 * @return Resultado da avaliacao definida.
	 */
	@Override
	public Valor avaliar() {
		DeclaracaoFuncao funcao = AmbienteExecucao.getInstancia().obterFuncao(nome);
		
		if(funcao == null) {
			throw new RuntimeException("Funcao " + nome + " nao declarada");
		}else if (funcao.getArgumentos().size() > parametros.size()){
			throw new RuntimeException("Funcao " + nome + " tem menos parametros dos que os declarados");
		}else if (funcao.getArgumentos().size() < parametros.size()){
			throw new RuntimeException("Funcao " + nome + " tem mais parametros dos que os declarados");
		}else if (!checarTipo()){
			throw new RuntimeException("Tipo da funcao" + nome + "nao equivale ao que foi declarado");
		}
		AmbienteExecucao.getInstancia().definirEscopo();
	
		//faz as associacoes entre argumentos formais 
		//e parametros da chamada da funcao. 
		definirAmbiente(funcao);
		
		Valor resultado = funcao.getCorpo().avaliar();
		
		AmbienteExecucao.getInstancia().removerEscopo();
		
		return resultado;
	}

	/*
	 * associar no contexto de execucao os argumentos 
	 * formais da funcao "f" aos parametros 
	 * passados na aplicacao de funcao.
	 * 
	 */
	/** 
	 * @author PedroAcA
	 * 
	 * Associa a variavel declarada na funcao ao valor passado na chamada da mesma.
	 * 	
	 * @param funcao declarada que tem o mesmo nome da funcao chamada.
	 */
	private void definirAmbiente(DeclaracaoFuncao funcao) {
		List<ArgumentoFormal> argumentosFormais = funcao.getArgumentos();
		
		for(ArgumentoFormal arg: argumentosFormais) {
			/*  PedroAcA
			 * Como a lista de argumentos formais e a lista de argumentos passados para a funcao
			 * tem que estar "alinhandos", entao os indices das 2 listas serao iguais
			 * */
			Expressao exp = parametros.get(argumentosFormais.indexOf(arg));
			AmbienteExecucao.getInstancia().declaraVariavel(arg.getId(), exp);
	//		contador++;
		}
		
//		for(int i = 0; i < argumentosFormais.size(); i++) {
//			ArgumentoFormal arg = argumentosFormais.get(i);
//			Expressao exp = parametros.get(i);
//			AmbienteExecucao.getInstancia().declaraVariavel(arg.getId(), exp);
//		}
//Uma das possiveis alternaticas usando foreach
//		for(ArgumentoFormal arg: f.getArgumentos()) {
//			Expressao exp = parametros.get(contador);
//			AmbienteExecucao.instance().associarExpressao(arg.getId(), exp);
//			contador++;
//		}		
	}
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}