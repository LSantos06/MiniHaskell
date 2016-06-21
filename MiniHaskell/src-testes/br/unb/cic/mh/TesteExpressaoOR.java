package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoOR {
	@Test
	public void testORSimples() {
		ValorBooleano falso  = new ValorBooleano(false);
		ValorBooleano verdadeiro = new ValorBooleano(true);
		
		ExpressaoOR or1 = new ExpressaoOR(falso, verdadeiro);
		ExpressaoOR or2 = new ExpressaoOR(falso, falso);
		ExpressaoOR or3 = new ExpressaoOR(verdadeiro,falso);
		ExpressaoOR or4 = new ExpressaoOR(verdadeiro, verdadeiro);
		
		ValorBooleano res1 = (ValorBooleano)or1.avaliar();
		ValorBooleano res2 = (ValorBooleano)or2.avaliar();
		ValorBooleano res3 = (ValorBooleano)or3.avaliar();
		ValorBooleano res4 = (ValorBooleano)or4.avaliar();
		
		Assert.assertEquals(new Boolean(true), res1.getValor());
		Assert.assertEquals(new Boolean(false), res2.getValor());
		Assert.assertEquals(new Boolean(true), res3.getValor());
		Assert.assertEquals(new Boolean(true), res4.getValor());
	}
	
	
	@Test
	public void testORComplexa() {
		ValorBooleano falso  = new ValorBooleano(false);
		ValorBooleano verdadeiro = new ValorBooleano(true);
		
		ExpressaoOR or1 = new ExpressaoOR(falso,falso);
		ExpressaoOR or2 = new ExpressaoOR(verdadeiro,verdadeiro);
		ExpressaoOR or3 = new ExpressaoOR(or1, falso);
		ExpressaoOR or4 = new ExpressaoOR(or2, falso);
		
		ValorBooleano res1 = (ValorBooleano)or3.avaliar();
		ValorBooleano res2 = (ValorBooleano)or4.avaliar();
		
		Assert.assertEquals(new Boolean(false), res1.getValor());
		Assert.assertEquals(new Boolean(true), res2.getValor());
	}

}
