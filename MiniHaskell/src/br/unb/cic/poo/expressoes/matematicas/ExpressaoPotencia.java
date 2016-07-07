package br.unb.cic.poo.expressoes.matematicas;


import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoBinaria;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorInteiro;
import br.unb.cic.poo.visitor.Visitor;

/**
 * @author PedroAcA
 * 
 * Uma expressao multiplicacao eh uma expressao binaria que 
 * realiza a potencia entre duas sub-expressoes inteiras.
 */
public class ExpressaoPotencia extends ExpressaoBinaria{

	public ExpressaoPotencia(Expressao subExpressao1, Expressao subExpressao2) {
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
	 * @author PedroAcA
	 * 
	 * A funcao avaliar realiza a POTENCIACAO entre as duas 
	 * sub-expressoes (subExpressao1 ^ subExpressao2).
	 */	
	@Override
	public Valor avaliar() {
		ValorInteiro valor1 = (ValorInteiro)subExpressao1.avaliar();
		ValorInteiro valor2 = (ValorInteiro)subExpressao2.avaliar();
		
		return new ValorInteiro((int) Math.pow(valor1.getValor(),valor2.getValor()));
	}
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);
	}
}
