package br.unb.cic.poo.expressoes;

/**
 * @author PedroAcA
 * 
 * Uma expressao unaria eh uma expressao que 
 * relaciona somente uma sub-expressao.
 */
public abstract class ExpressaoUnaria implements Expressao{
	
	protected Expressao subExpressao;
	
	public ExpressaoUnaria(Expressao subExpressao) {
		this.subExpressao = subExpressao;
	}

	public Expressao getSubExpressao() {
		return subExpressao;
	}

}
