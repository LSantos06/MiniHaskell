package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.relacionais.ExpressaoMenorIgual;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoMenorIgual {
	
	@Test
	public void testMenorIgualSimples() {
		ValorInteiro v40  = new ValorInteiro(40);
		ValorInteiro v20 = new ValorInteiro(20);
		ValorInteiro v20_2 = new ValorInteiro(20);
		
		ExpressaoMenorIgual menor = new ExpressaoMenorIgual(v40, v20);
		ExpressaoMenorIgual igual = new ExpressaoMenorIgual(v20, v20_2);
		
		ValorBooleano res1 = (ValorBooleano)menor.avaliar();
		ValorBooleano res2 = (ValorBooleano)igual.avaliar();
		
		Assert.assertEquals(false, res1.getValor());
		Assert.assertEquals(true, res2.getValor());
	}
}