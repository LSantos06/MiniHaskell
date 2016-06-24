package br.unb.cic.poo.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.unb.cic.poo.expressoes.ExpressaoLet;

public class TesteExpressaoLet extends TesteUtil{

	@Test
	public void testeExpressaoLetSimples(){
		/*
		 * let x = 10
		 * in x + x
		 */
		ExpressaoLet let = new ExpressaoLet("x", inteiro(10), 
							soma(refId("x"), refId("x")));
		
		assertEquals(inteiro(20), let.avaliar());
	}
	
	@Test
	public void testeExpressaoLetComplexa(){
		/*
		 * let x = 2
		 * in x + y
		 */
		ExpressaoLet letInterno = new ExpressaoLet("x", inteiro(2),
									soma(refId("x"), refId("y")));
		
		/*
		 * let y = 8
		 * in let x = 2
		 * 	  in x + y
		 */
		ExpressaoLet letExterno = new ExpressaoLet("y", inteiro(8),
									letInterno);
		
		assertEquals(inteiro(10), letExterno.avaliar());
	}
}
