package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.logicas.ExpressaoNOT;
import br.unb.cic.poo.valores.ValorBooleano;

public class TesteExpressaoNOT {
	@Test
	public void testNOTSimples() {
		ValorBooleano falso  = new ValorBooleano(false);
		ValorBooleano verdadeiro = new ValorBooleano(true);
		
		ExpressaoNOT not1 = new ExpressaoNOT(verdadeiro);
		ExpressaoNOT not2 = new ExpressaoNOT(falso);
		
		ValorBooleano res1 = (ValorBooleano)not1.avaliar();
		ValorBooleano res2 = (ValorBooleano)not2.avaliar();
		
		Assert.assertEquals(new Boolean(false), res1.getValor());
		Assert.assertEquals(new Boolean(true), res2.getValor());
	}
	
	
	@Test
	public void testNOTComplexa() {
		ValorBooleano falso  = new ValorBooleano(false);
		ValorBooleano verdadeiro = new ValorBooleano(true);
		
		ExpressaoNOT not1 = new ExpressaoNOT(falso);
		ExpressaoNOT not2 = new ExpressaoNOT(verdadeiro);
		ExpressaoNOT not3 = new ExpressaoNOT(not1);
		ExpressaoNOT not4 = new ExpressaoNOT(not2);
		
		ValorBooleano res1 = (ValorBooleano)not3.avaliar();
		ValorBooleano res2 = (ValorBooleano)not4.avaliar();
		
		Assert.assertEquals(new Boolean(false), res1.getValor());
		Assert.assertEquals(new Boolean(true), res2.getValor());
	}

}
