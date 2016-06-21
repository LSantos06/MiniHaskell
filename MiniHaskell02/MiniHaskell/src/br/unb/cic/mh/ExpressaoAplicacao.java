package br.unb.cic.mh;

import java.util.List;

public class ExpressaoAplicacao implements Expressao {

	private String nome; 
	private List<Expressao> parametros;
	
	public ExpressaoAplicacao(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.parametros = argumentos;
	}

	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Valor avaliar() {
		DeclFuncao f = AmbienteExecucao.instance().obterDeclaracaoFuncao(nome);
		
		if(f == null) {
			throw new RuntimeException("Funcao " + nome + " nao declarada");
		}
		AmbienteExecucao.instance().definirEscopo();
	
		//faz as associacoes entre argumentos formais 
		//e parametros da chamada da funcao. 
		definirAmbiente(f);
		
		Valor resultado = f.getCorpo().avaliar();
		
		AmbienteExecucao.instance().removerEscopo();
		
		return resultado;
	}

	/*
	 * associar no contexto de execucao os argumentos 
	 * formais da funcao "f" aos parametros 
	 * passados na aplicacao de funcao.
	 * 
	 *  
	 *  TODO: o que fazer quando o numero de argumentos 
	 *  formais nao for igual a quantidade de parametros 
	 *  passados na chamada a funcao. 
	 */
	private void definirAmbiente(DeclFuncao f) {
		List<ArgumentoFormal> argumentosFormais = f.getArgumentos();
		for(int i = 0; i < argumentosFormais.size(); i++) {
			ArgumentoFormal arg = argumentosFormais.get(i);
			Expressao exp = parametros.get(i);
			AmbienteExecucao.instance().associarExpressao(arg.getId(), exp);
		}
//Uma das possiveis alternaticas usando foreach
//		for(ArgumentoFormal arg: f.getArgumentos()) {
//			Expressao exp = parametros.get(contador);
//			AmbienteExecucao.instance().associarExpressao(arg.getId(), exp);
//			contador++;
//		}		
	}
}
