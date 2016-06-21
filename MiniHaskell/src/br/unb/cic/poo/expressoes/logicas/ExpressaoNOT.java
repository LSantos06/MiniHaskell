package br.unb.cic.poo.expressoes.logicas;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoUnaria;
import br.unb.cic.poo.expressoes.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorBooleano;

/**
 * @author PedroAcA
 * 
 * Uma expressao and eh uma expressao binaria que 
 * realiza a operacao logica NOT em uma sub-expressao booleana.
 */
public class ExpressaoNOT extends ExpressaoUnaria {

	public ExpressaoNOT(Expressao subExpressao1) {
		super(subExpressao1);
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
		Tipo tipoSubExpressao1 = subExpressao1.tipo();
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
		ValorBooleano valor1 = (ValorBooleano)subExpressao1.avaliar();
		
		return new ValorBooleano(!valor1.getValor());
	}
}
