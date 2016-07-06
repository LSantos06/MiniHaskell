package br.unb.cic.poo.testes;
import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.matematicas.ExpressaoPotencia;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoPotencia extends TesteUtil{
	@Test
	public void testePotenciaSimples(){
		ValorInteiro v2  = inteiro(2);
		ValorInteiro v4 = inteiro(4);
		
		ExpressaoPotencia pot = potencia(v2, v4);
		
		ValorInteiro res = (ValorInteiro)pot.avaliar();
		
		Assert.assertEquals(new Integer(16), res.getValor());
	}
	
	@Test
	public void testePotenciaComplexa(){
		ValorInteiro v100  = inteiro(100);
		ValorInteiro v10 = inteiro(10);
		ValorInteiro v0  = inteiro(0);
		
		ExpressaoPotencia pot1 = potencia(v100, v10);
		ExpressaoPotencia pot2 = potencia(pot1, v0);
		
		ValorInteiro res = (ValorInteiro)pot2.avaliar();
		
		Assert.assertEquals(new Integer(1), res.getValor());
	}
}
