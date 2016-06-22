package br.unb.cic.poo.expressoes;

import br.unb.cic.poo.main.AmbienteExecucao;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;

/**
 * @author LSantos06
 * 
 * Expressao REFID eh uma expressao que relaciona uma referencia
 * a um id.
 */
public class ExpressaoReferenciaIdentificador implements Expressao{

	private String id;
	
	public ExpressaoReferenciaIdentificador(String id) {
		this.id = id;
	}

	@Override
	public Tipo tipo() {
		Expressao expressao = AmbienteExecucao.getInstancia().obterVariavel(id);
		if(expressao != null) {
			return expressao.tipo();
		}
		throw new RuntimeException("Variavel: " + id + "nao declarada");
	}

	@Override
	public boolean checarTipo() {
		Expressao expressao = AmbienteExecucao.getInstancia().obterVariavel(id);
		if(expressao != null) {
			return expressao.checarTipo();
		}
		throw new RuntimeException("Variavel: " + id + "nao declarada");
	}

	@Override
	public Valor avaliar() {
		Expressao expressao = AmbienteExecucao.getInstancia().obterVariavel(id);
		if(expressao != null) {
			return expressao.avaliar();
		}
		throw new RuntimeException("Variavel: " + id + "nao declarada");
	}

}
