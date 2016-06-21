package br.unb.cic.mh;

/**
 * @author PedroAcA
 * 
 * Uma expressao and eh uma expressao binaria que 
 * realiza a operacao logica and entre duas sub-expressoes booleanas.
 */
public class ExpressaoNOT extends ExpressaoUnaria {

	public ExpressaoNOT(Expressao subExpressao1) {
		super(subExpressao1);
	}
	
	/**
	 * @author PedroAcA
	 * 
	 * Se ambas as sub-expressoes sao booleanas
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
	 * A funcao avaliar realiza a operacao logica AND entre as duas 
	 * sub-expressoes.
	 */	
	@Override
	public Valor avaliar() {
		ValorBooleano valor1 = (ValorBooleano)subExpressao1.avaliar();
		
		return new ValorBooleano(!valor1.getValor());
	}
}
