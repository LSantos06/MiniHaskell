package br.unb.cic.poo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteInterpretador {

	@Test
	public void test() {
		Interpretador interpretador = new Interpretador();	
		
		Assert.assertEquals(48, interpretador.avaliarExpressoes("5 43 +"));
		Assert.assertEquals(5, interpretador.avaliarExpressoes("15 3 /"));
	
		Assert.assertEquals(5, interpretador.avaliarExpressoes("5 -"));
		
	}

}
