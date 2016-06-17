package br.unb.cic.mh;

/**
 * @author LSantos06
 * 
 * Uma expressao soma eh uma expressao binaria que 
 * realiza a soma entre duas sub-expressoes inteiras.
 */
public class ExpressaoSoma extends ExpressaoBinaria {

	public ExpressaoSoma(Expressao subExpressao1, Expressao subExpressao2) {
		super(subExpressao1, subExpressao2);
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Se ambas as sub-expressoes sao inteiras
	 * 		return INTEIRO
	 * Senao
	 * 		return ERRO
	 */
	@Override
	public Tipo tipo() {		
		Tipo tipoSubExpressao1 = subExpressao1.tipo();
		Tipo tipoSubExpressao2 = subExpressao2.tipo();
		
		if(tipoSubExpressao1.equals(Tipo.INTEIRO) && 
		   tipoSubExpressao2.equals(Tipo.INTEIRO)) {
			return Tipo.INTEIRO;
		}
		return Tipo.ERRO;
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Se o retorno da funcao tipo() eh INTEIRO
	 * 		return TRUE
	 * Senao
	 * 		return FALSE
	 */
	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.INTEIRO);
	}

	/**
	 * @author LSantos06
	 * 
	 * A funcao avaliar realiza a SOMA entre as duas 
	 * sub-expressoes.
	 */	
	@Override
	public Valor avaliar() {
		ValorInteiro valor1 = (ValorInteiro)subExpressao1.avaliar();
		ValorInteiro valor2 = (ValorInteiro)subExpressao2.avaliar();
		
		return new ValorInteiro(valor1.getValor() + valor2.getValor());
	}
}
