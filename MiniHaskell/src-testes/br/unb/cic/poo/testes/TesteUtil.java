package br.unb.cic.poo.testes;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoReferenciaIdentificador;
import br.unb.cic.poo.expressoes.matematicas.ExpressaoMultiplicacao;
import br.unb.cic.poo.expressoes.matematicas.ExpressaoPotencia;
import br.unb.cic.poo.expressoes.matematicas.ExpressaoSoma;
import br.unb.cic.poo.expressoes.matematicas.ExpressaoRaizQuadrada;
import br.unb.cic.poo.valores.ValorInteiro;

public abstract class TesteUtil {
	/**
	 * @author LSantos06 
	 *
	 * Funcoes para facilitar os testes.
	 */
	public ExpressaoSoma soma(Expressao expressao1, Expressao expressao2){
		return new ExpressaoSoma(expressao1, expressao2);
	}
	
	public ExpressaoMultiplicacao multiplicacao(Expressao expressao1, Expressao expressao2){
		return new ExpressaoMultiplicacao(expressao1, expressao2);
	}
	public ExpressaoRaizQuadrada raiz(Expressao expressao){
		return new ExpressaoRaizQuadrada(expressao);
	}
	public ExpressaoPotencia potencia(Expressao expressao1, Expressao expressao2){
		return new ExpressaoPotencia(expressao1, expressao2);
	}
	
	public ValorInteiro inteiro(Integer valor){
		return new ValorInteiro(valor);
	}
	
	public ExpressaoReferenciaIdentificador refId(String id){
		return new ExpressaoReferenciaIdentificador(id);
	}
}