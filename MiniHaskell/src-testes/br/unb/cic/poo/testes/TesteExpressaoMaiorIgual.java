package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.relacionais.ExpressaoMaiorIgual;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoMaiorIgual {

	@Test
	public void testMaiorIgualSimples() {
		ValorInteiro v20  = new ValorInteiro(20);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v20_2 = new ValorInteiro(20);
		
		ExpressaoMaiorIgual maior = new ExpressaoMaiorIgual(v20, v10);
		ExpressaoMaiorIgual igual = new ExpressaoMaiorIgual(v20,v20_2);
		
		ValorBooleano res1 = (ValorBooleano)maior.avaliar();
		ValorBooleano res2 = (ValorBooleano)igual.avaliar();
		
		Assert.assertEquals(true, res1.getValor());
		Assert.assertEquals(true, res2.getValor());
	}
}
