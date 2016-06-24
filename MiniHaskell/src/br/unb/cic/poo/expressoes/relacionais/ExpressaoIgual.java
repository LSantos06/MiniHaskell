package br.unb.cic.poo.expressoes.relacionais;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoBinaria;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;
import br.unb.cic.poo.visitor.Visitor;

/**
 * @author LSantos06
 * 
 * Uma expressao igual eh uma expressao binaria que 
 * realiza a comparacao entre dois valores, sendo eles inteiros ou booleanos,
 * e avalia se estes sao iguais.
 */
public class ExpressaoIgual extends ExpressaoBinaria{

	public ExpressaoIgual(Expressao subExpressao1, Expressao subExpressao2) {
		super(subExpressao1, subExpressao2);
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Se ambas as sub-expressoes sao inteiras
	 * 		return INTEIRO
	 * Se ambas as sub-expressoes sao booleanas
	 * 		return BOOLEANO
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
		else if(tipoSubExpressao1.equals(Tipo.BOOLEANO) && 
				  tipoSubExpressao2.equals(Tipo.BOOLEANO)) {
			return Tipo.BOOLEANO;
			
		}
		return Tipo.ERRO;
	}
	
	/**
	 * @author LSantos06
	 * 
	 * Se o retorno da funcao tipo() eh INTEIRO ou BOOLEANO
	 * 		return TRUE
	 * Senao
	 * 		return FALSE
	 */
	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.INTEIRO) || tipo().equals(Tipo.BOOLEANO);
	}

	/**
	 * @author LSantos06
	 * 
	 * A funcao avaliar realiza a comparacao entre as duas 
	 * sub-expressoes, retornando um valor booleano como resposta.
	 */	
	@Override
	public Valor avaliar() {
		
		if(tipo().equals(Tipo.BOOLEANO)){
			ValorBooleano valorBooleano1 = (ValorBooleano)subExpressao1.avaliar();
			ValorBooleano valorBooleano2 = (ValorBooleano)subExpressao1.avaliar();
			
			return new ValorBooleano(valorBooleano1.getValor() == valorBooleano2.getValor());
		} 
		else if(tipo().equals(Tipo.INTEIRO)){
			ValorInteiro valorInteiro1 = (ValorInteiro)subExpressao1.avaliar();
			ValorInteiro valorInteiro2 = (ValorInteiro)subExpressao2.avaliar();
			
			return new ValorBooleano(valorInteiro1.getValor() == valorInteiro2.getValor());
		}
		
		return new ValorInteiro(-1);
	}
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}
