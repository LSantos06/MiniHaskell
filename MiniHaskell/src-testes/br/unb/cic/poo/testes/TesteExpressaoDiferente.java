package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.relacionais.ExpressaoDiferente;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoDiferente {

	@Test
	public void testDiferenteInteiro() {
		ValorInteiro v20  = new ValorInteiro(20);
		ValorInteiro v10 = new ValorInteiro(10);
		
		ExpressaoDiferente diferente = new ExpressaoDiferente(v20, v10);
		
		ValorBooleano res = (ValorBooleano)diferente.avaliar();
		
		Assert.assertEquals(true, res.getValor());
	}
	
	@Test
	public void testDiferenteBooleano() {
		ValorBooleano vTrue  = new ValorBooleano(true);
		
		ExpressaoDiferente diferente = new ExpressaoDiferente(vTrue, vTrue);
		
		ValorBooleano res = (ValorBooleano)diferente.avaliar();
		
		Assert.assertEquals(false, res.getValor());
	}

}
