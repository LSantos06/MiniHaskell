package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.logicas.ExpressaoAND;
import br.unb.cic.poo.valores.ValorBooleano;

public class TesteExpressaoAND {

	@Test
	public void testANDSimples() {
		ValorBooleano falso  = new ValorBooleano(false);
		ValorBooleano verdadeiro = new ValorBooleano(true);
		
		ExpressaoAND and1 = new ExpressaoAND(falso, verdadeiro);
		ExpressaoAND and2 = new ExpressaoAND(falso, falso);
		ExpressaoAND and3 = new ExpressaoAND(verdadeiro,falso);
		ExpressaoAND and4 = new ExpressaoAND(verdadeiro, verdadeiro);
		
		ValorBooleano res1 = (ValorBooleano)and1.avaliar();
		ValorBooleano res2 = (ValorBooleano)and2.avaliar();
		ValorBooleano res3 = (ValorBooleano)and3.avaliar();
		ValorBooleano res4 = (ValorBooleano)and4.avaliar();
		
		Assert.assertEquals(new Boolean(false), res1.getValor());
		Assert.assertEquals(new Boolean(false), res2.getValor());
		Assert.assertEquals(new Boolean(false), res3.getValor());
		Assert.assertEquals(new Boolean(true), res4.getValor());
	}
	
	
	@Test
	public void testANDComplexa() {
		ValorBooleano falso  = new ValorBooleano(false);
		ValorBooleano verdadeiro = new ValorBooleano(true);
		
		ExpressaoAND and1 = new ExpressaoAND(verdadeiro,falso);
		ExpressaoAND and2 = new ExpressaoAND(verdadeiro,verdadeiro);
		ExpressaoAND and3 = new ExpressaoAND(and1, verdadeiro);
		ExpressaoAND and4 = new ExpressaoAND(and2, verdadeiro);
		
		ValorBooleano res1 = (ValorBooleano)and3.avaliar();
		ValorBooleano res2 = (ValorBooleano)and4.avaliar();
		
		Assert.assertEquals(new Boolean(false), res1.getValor());
		Assert.assertEquals(new Boolean(true), res2.getValor());
	}

}
