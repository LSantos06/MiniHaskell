package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoSubtracao {

	@Test
	public void testSubtracaoSimples() {
		ValorInteiro v20  = new ValorInteiro(20);
		ValorInteiro v10 = new ValorInteiro(10);
		
		ExpressaoSubtracao subtracao = new ExpressaoSubtracao(v20, v10);
		
		ValorInteiro res = (ValorInteiro)subtracao.avaliar();
		
		Assert.assertEquals(new Integer(10), res.getValor());
	}
	
	@Test
	public void testSubtracaoNegativa() {
		ValorInteiro v5  = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		ExpressaoSubtracao subtracao = new ExpressaoSubtracao(v5, v10);
		
		ValorInteiro res = (ValorInteiro)subtracao.avaliar();
		
		Assert.assertEquals(new Integer(-5), res.getValor());
	}
	
	@Test
	public void testSubtracaoComplexa() {
		ValorInteiro v5  = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v20 = new ValorInteiro(20);
		
		ExpressaoSubtracao subtracao1 = new ExpressaoSubtracao(v5, v10);
		ExpressaoSubtracao subtracao2 = new ExpressaoSubtracao(subtracao1, v20);
		
		ValorInteiro res = (ValorInteiro)subtracao2.avaliar();
		
		Assert.assertEquals(new ValorInteiro(-25), res);
	}

}
