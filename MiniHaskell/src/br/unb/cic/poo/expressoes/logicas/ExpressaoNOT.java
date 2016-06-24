package br.unb.cic.poo.expressoes.logicas;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoUnaria;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.visitor.Visitor;

/**
 * @author PedroAcA
 * 
 * Uma expressao and eh uma expressao binaria que 
 * realiza a operacao logica NOT em uma sub-expressao booleana.
 */
public class ExpressaoNOT extends ExpressaoUnaria {

	public ExpressaoNOT(Expressao subExpressao) {
		super(subExpressao);
	}
	
	/**
	 * @author PedroAcA
	 * 
	 * Se ambas a sub-expressao eh booleana
	 * 		return BOOLEANO
	 * Senao
	 * 		return ERRO
	 */
	@Override
	public Tipo tipo() {		
		Tipo tipoSubExpressao1 = subExpressao.tipo();
		if(tipoSubExpressao1.equals(Tipo.BOOLEANO) ) {
			return Tipo.BOOLEANO;
		}
		return Tipo.ERRO;
	}
	
	/**
	 * @author PedroAcA
	 * 
	 * Se o retorno da funcao tipo() eh BOOLEANO
	 * 		return TRUE
	 * Senao
	 * 		return FALSE
	 */
	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.BOOLEANO);
	}

	/**
	 * @author PedroAcA
	 * 
	 * A funcao avaliar realiza a operacao logica NOT na sub-expressao.
	 */	
	@Override
	public Valor avaliar() {
		ValorBooleano valor1 = (ValorBooleano)subExpressao.avaliar();
		
		return new ValorBooleano(!valor1.getValor());
	}
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}
