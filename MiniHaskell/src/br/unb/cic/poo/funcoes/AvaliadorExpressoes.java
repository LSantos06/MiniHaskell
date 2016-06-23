package br.unb.cic.poo.funcoes;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.valores.Tipo; 
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.main.AmbienteExecucao;
 
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
	/**Construtor default para o caso de precisar instanciar o objeto
	 *mas nao ter nome e parametros.Inicia a lista de parametros
	 * @author PedroAcA
	 */
	public AvaliadorExpressoes() {
		this.parametros = new ArrayList<Expressao>();
	}
	
	/**Construtor para o caso deter nome e parametros ao instanciar o objeto.
	 * @author PedroAcA
	 * @param nome Nome da funcao chamada
	 * @param argumentos Lista de argumentos passados na chamada
	 */
	public AvaliadorExpressoes(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.parametros = argumentos;
	}
	
	/** Obtem o nome da Funcao
	 * 
	 * @return nome da funcao
	 */
	public String getNome() {
		return nome;
	}
	
	/** Inicia o nome da Funcao
	 * 
	 * @param nome Nome da funcao
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/** Obtem lista de Parametros da Funcao
	 * 
	 * @return Lista de Parametros da Funcao
	 */
	public List<Expressao> getParametros() {
		return parametros;
	}

	/**Inicia lista de Parametros da Funcao
	 * 
	 * @param parametros Lista de Parametros da Funcao
	 */
	public void setParametros(List<Expressao> parametros) {
		this.parametros = parametros;
	}
	
	/**Adiciona um parametro à lista de Parametros da Funcao
	 * 
	 * @param parametro Parametro a ser adicionado na Lista de Parametros da Funcao
	 */
	public void setParametro(Expressao parametro) {
		this.parametros.add(parametro);
	}
	
	/** 
	 * 
	 */
	@Override
	public Tipo tipo() {
		DeclaracaoFuncao f = AmbienteExecucao.getInstancia().obterFuncao(nome);
		ArgumentoFormal A;
		for (Expressao e: parametros){
			/*/compara cada elemento da funcao 
			 * declarada e ve se eles sao diferentes. 
			 * Se forem diferentes, retona erro. 
			 * Se todos forem iguais, retorna que a funcao eh bem tipada	
			 * */
			A = f.getArgumentos().get(parametros.indexOf(e));
			if(!e.tipo().equals(A.getTipo())){
				System.out.println("Erro no parametro" + A.getId() + ". Esperava tipo" + A.getTipo()+ 
						"mas tipo atual " + e.tipo());
				return Tipo.ERRO;
			}
		}
		return Tipo.Funcao;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.Funcao);
	}

	
	/** Vai analisar o valor da funcao e retornar um dos tipos definidos como valores: inteiro,
	 * booleano, lista
	 * @author PedroAcA
	 * @throws RunTimeException caso nao tenha sido declarado nenhuma funcao com aquele nome
	 * @throws RunTimeException caso a lista de parametros da funcao chamada seja menor do que a lista 
	 * de argumentos declarados 
	 * @throws RunTimeException cao a lista de parametros da funcao chamada seja maior do que a lista 
	 * de argumentos declarados 
	 * return Resultado da avaliacao definida
	 */
	@Override
	public Valor avaliar() {
		DeclaracaoFuncao f = AmbienteExecucao.getInstancia().obterFuncao(nome);
		
		if(f == null) {
			throw new RuntimeException("Funcao " + nome + " nao declarada");
		}else if (f.getArgumentos().size() > parametros.size()){
			throw new RuntimeException("Funcao " + nome + " tem menos parametros dos que os declarados");
		}else if (f.getArgumentos().size() < parametros.size()){
			throw new RuntimeException("Funcao " + nome + " tem mais parametros dos que os declarados");
		}else if (!checarTipo()){// ha um erro de tipo
			throw new RuntimeException("Tipo da funcao" + nome + "nao equivale ao que foi declarado");
		}
		AmbienteExecucao.getInstancia().definirEscopo();
	
		//faz as associacoes entre argumentos formais 
		//e parametros da chamada da funcao. 
		definirAmbiente(f);
		
		Valor resultado = f.getCorpo().avaliar();
		
		AmbienteExecucao.getInstancia().removerEscopo();
		
		return resultado;
	}

	/*
	 * associar no contexto de execucao os argumentos 
	 * formais da funcao "f" aos parametros 
	 * passados na aplicacao de funcao.
	 * 
	 */
	/** Associa a variavel declarada na funcao ao valor passado na chamada da mesma 
	 * @author PedroAcA
	 * 	
	 * @param f funcao declarada que tem o mesmo nome da funcao chamada
	 */
	private void definirAmbiente(DeclaracaoFuncao f) {
		List<ArgumentoFormal> argumentosFormais = f.getArgumentos();
		
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
}