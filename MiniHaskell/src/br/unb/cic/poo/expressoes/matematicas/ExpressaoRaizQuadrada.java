package br.unb.cic.poo.expressoes.matematicas;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoUnaria;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorInteiro;
import br.unb.cic.poo.visitor.Visitor;

/**
 * @author LSantos06
 * 
 * Uma expressao multiplicacao eh uma expressao unaria que 
 * calcula a raiz quadrada de um inteiro.
 */
public class ExpressaoRaizQuadrada extends ExpressaoUnaria {

	public ExpressaoRaizQuadrada(Expressao subExpressao1) {
		super(subExpressao1);
	}
	
	/**
	 * @author PedroAcA
	 * 
	 * Se o expoente eh inteiro
	 * 		return INTEIRO
	 * Senao
	 * 		return ERRO
	 */
	@Override
	public Tipo tipo() {		
		Tipo tipoSubExpressao1 = subExpressao.tipo();
		
		if(tipoSubExpressao1.equals(Tipo.INTEIRO)) {
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
	 * A funcao avaliar realiza a RAIZ QUADRADA entre  a 
	 * sub-expressao fornecida sqrt(subExpressao).
	 */	
	@Override
	public Valor avaliar() {
		ValorInteiro valor1 = (ValorInteiro)subExpressao.avaliar();
		
		return new ValorInteiro((int) Math.sqrt(valor1.getValor()));
	}

	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);
	}
}
