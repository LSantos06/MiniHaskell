package br.unb.cic.poo.expressoes;

/**
 * @author LSantos06
 * 
 * Uma expressao binaria eh uma expressao que 
 * relaciona duas sub-expressoes.
 */
public abstract class ExpressaoBinaria implements Expressao{
	
	protected Expressao subExpressao1;
	protected Expressao subExpressao2;
	
	public ExpressaoBinaria(Expressao subExpressao1, Expressao subExpressao2) {
		this.subExpressao1 = subExpressao1;
		this.subExpressao2 = subExpressao2;
	}

	public Expressao getSubExpressao1() {
		return subExpressao1;
	}

	public Expressao getSubExpressao2() {
		return subExpressao2;
	}
	
}
