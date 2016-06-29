package br.unb.cic.poo.expressoes;

import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.visitor.Visitor;

/**
 * @author LSantos06
 * 
 * Classe que implementa a expressao IfThenElse.
 */
public class ExpressaoIfThenElse implements Expressao{
	
	private Expressao condicao;
	private Expressao clausulaThen;
	private Expressao clausulaElse;
	
	public ExpressaoIfThenElse(Expressao condicao, Expressao clausulaThen,
			Expressao clausulaElse) {
		this.condicao = condicao;
		this.clausulaThen = clausulaThen;
		this.clausulaElse = clausulaElse;
	}
	
	public Expressao getCondicao() {
		return condicao;
	}

	public Expressao getClausulaThen() {
		return clausulaThen;
	}

	public Expressao getClausulaElse() {
		return clausulaElse;
	}

	/**
	 * @author LSantos06
	 * 
	 * Se a condicao for satisfeita
	 * 		return THEN
	 * Senao
	 * 		return ELSE
	 */
	@Override
	public Valor avaliar() {
		ValorBooleano valor = (ValorBooleano)condicao.avaliar();
		
		if(valor.getValor() == true) {
			return clausulaThen.avaliar();
		}
		else {
			return clausulaElse.avaliar();
		}
	}

	/**
	 * @author LSantos06
	 * 
	 * Se o tipo dos atributos do IfThenElse forem BOOLEANO
	 * 		return BOOLEANO
	 * Senao 
	 * 		return ERRO
	 */
	@Override
	public Tipo tipo() {
		Tipo tipoCondicao = condicao.tipo();
		
		if(tipoCondicao.equals(Tipo.BOOLEANO)) {
			if(clausulaThen.tipo().equals(clausulaElse.tipo())) {
				return clausulaThen.tipo();
			}
		}
		return Tipo.ERRO;
	}

	
	@Override
	public boolean checarTipo() {
		return !tipo().equals(Tipo.ERRO);
	} 
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
	
}
