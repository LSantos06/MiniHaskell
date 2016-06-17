package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoMultiplicacao {

	@Test
	public void testMultiplicacaoSimples() {
		ValorInteiro v20  = new ValorInteiro(20);
		ValorInteiro v10 = new ValorInteiro(10);
		
		ExpressaoMultiplicacao multiplicacao = new ExpressaoMultiplicacao(v20, v10);
		
		ValorInteiro res = (ValorInteiro)multiplicacao.avaliar();
		
		Assert.assertEquals(new Integer(200), res.getValor());
	}
	
	@Test
	public void testMultiplicacaoComplexa() {
		ValorInteiro v100  = new ValorInteiro(100);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5  = new ValorInteiro(5);
		
		ExpressaoMultiplicacao multiplicacao1 = new ExpressaoMultiplicacao(v100, v10);
		ExpressaoMultiplicacao multiplicacao2 = new ExpressaoMultiplicacao(multiplicacao1, v5);
		
		ValorInteiro res = (ValorInteiro)multiplicacao2.avaliar();
		
		Assert.assertEquals(new Integer(5000), res.getValor());
	}

}
