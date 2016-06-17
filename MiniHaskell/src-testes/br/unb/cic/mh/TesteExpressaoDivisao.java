package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoDivisao {

	@Test
	public void testDivisaoSimples() {
		ValorInteiro v20  = new ValorInteiro(20);
		ValorInteiro v10 = new ValorInteiro(10);
		
		ExpressaoDivisao divisao = new ExpressaoDivisao(v20, v10);
		
		ValorInteiro res = (ValorInteiro)divisao.avaliar();
		
		Assert.assertEquals(new Integer(2), res.getValor());
	}
	
	@Test
	public void testDivisaoComplexa() {
		ValorInteiro v100  = new ValorInteiro(100);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v5  = new ValorInteiro(5);
		
		ExpressaoDivisao divisao1 = new ExpressaoDivisao(v100, v10);
		ExpressaoDivisao divisao2 = new ExpressaoDivisao(divisao1, v5);
		
		ValorInteiro res = (ValorInteiro)divisao2.avaliar();
		
		Assert.assertEquals(new Integer(2), res.getValor());
	}

}
