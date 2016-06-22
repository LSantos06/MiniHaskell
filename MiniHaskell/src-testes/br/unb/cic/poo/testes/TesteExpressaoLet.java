package br.unb.cic.poo.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoLet;
import br.unb.cic.poo.expressoes.ExpressaoReferenciaIdentificador;
import br.unb.cic.poo.expressoes.binarias.ExpressaoMultiplicacao;
import br.unb.cic.poo.expressoes.binarias.ExpressaoSoma;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoLet {

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

	/**
	 * @author LSantos06 
	 *
	 * Escrevendo funcoes para facilitar os testes.
	 */
	public ExpressaoSoma soma(Expressao expressao1, Expressao expressao2){
		return new ExpressaoSoma(expressao1, expressao2);
	}
	
	public ExpressaoMultiplicacao multiplicacao(Expressao expressao1, Expressao expressao2){
		return new ExpressaoMultiplicacao(expressao1, expressao2);
	}
	
	public ValorInteiro inteiro(Integer valor){
		return new ValorInteiro(valor);
	}
	
	public ExpressaoReferenciaIdentificador refId(String id){
		return new ExpressaoReferenciaIdentificador(id);
	}
}
