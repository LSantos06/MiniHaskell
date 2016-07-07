package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.matematicas.ExpressaoRaizQuadrada;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoRaizQuadrada extends TesteUtil {
	@Test
	public void testeRaizSimples(){
		ValorInteiro v16  = inteiro(16);
		
		ExpressaoRaizQuadrada r = raiz(v16);
		
		ValorInteiro res = (ValorInteiro)r.avaliar();
		
		Assert.assertEquals(new Integer(4), res.getValor());
	}
	
	
	@Test
	public void testeRaizNegativa(){
		ValorInteiro v1_ = inteiro(-1);
		
		ExpressaoRaizQuadrada r_neg = raiz(v1_);
		
		ValorInteiro res = (ValorInteiro) r_neg.avaliar();
		
		Assert.assertEquals(new Integer(0),res.getValor());
	}
	
	@Test
	public void testeRaizComplexa(){
		ValorInteiro v81  = inteiro(81);
		ExpressaoRaizQuadrada r1 = raiz(v81);
		ExpressaoRaizQuadrada r2 = raiz(r1);
		
		ValorInteiro res = (ValorInteiro)r2.avaliar();
		
		Assert.assertEquals(new Integer(3), res.getValor());
	}
}
