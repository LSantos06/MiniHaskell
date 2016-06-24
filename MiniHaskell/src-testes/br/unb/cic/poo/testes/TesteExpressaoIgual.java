package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.relacionais.ExpressaoIgual;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoIgual {

	@Test
	public void testIgualInteiro() {
		ValorInteiro v20  = new ValorInteiro(20);
		ValorInteiro v10 = new ValorInteiro(10);
		
		ExpressaoIgual igual = new ExpressaoIgual(v20, v10);
		
		ValorBooleano res = (ValorBooleano)igual.avaliar();
		
		Assert.assertEquals(false, res.getValor());
	}
	
	@Test
	public void testIgualBooleano() {
		ValorBooleano vTrue  = new ValorBooleano(true);
		
		ExpressaoIgual igual = new ExpressaoIgual(vTrue, vTrue);
		
		ValorBooleano res = (ValorBooleano)igual.avaliar();
		
		Assert.assertEquals(true, res.getValor());
	}
}
