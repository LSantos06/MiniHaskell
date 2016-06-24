package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.relacionais.ExpressaoMaior;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoMaior {

	@Test
	public void testMaiorSimples() {
		ValorInteiro v20  = new ValorInteiro(20);
		ValorInteiro v10 = new ValorInteiro(10);
		
		ExpressaoMaior maior = new ExpressaoMaior(v20, v10);
		
		ValorBooleano res = (ValorBooleano)maior.avaliar();
		
		Assert.assertEquals(true, res.getValor());
	}
}
