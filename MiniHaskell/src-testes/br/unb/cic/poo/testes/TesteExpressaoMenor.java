package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.relacionais.ExpressaoMenor;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoMenor {

	@Test
	public void testMenorSimples() {
		ValorInteiro v40  = new ValorInteiro(40);
		ValorInteiro v20 = new ValorInteiro(20);
		
		ExpressaoMenor menor = new ExpressaoMenor(v40, v20);
		
		ValorBooleano res = (ValorBooleano)menor.avaliar();
		
		Assert.assertEquals(false, res.getValor());
	}
}
