package br.unb.cic.poo.expressoes;

/**
 * @author PedroAcA
 * 
 * Uma expressao unaria eh uma expressao que 
 * relaciona somente uma sub-expressao.
 */
public abstract class ExpressaoUnaria implements Expressao{
	
	protected Expressao subExpressao1;
	
	public ExpressaoUnaria(Expressao subExpressao1) {
		this.subExpressao1 = subExpressao1;
	}
}
