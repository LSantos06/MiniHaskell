package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.funcoes.ArgumentoFormal;
import br.unb.cic.poo.funcoes.AvaliadorExpressoes;
import br.unb.cic.poo.funcoes.DeclaracaoFuncao;
import br.unb.cic.poo.main.AmbienteExecucao;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoAplicacaoFuncao extends TesteUtil {
	
	@Test
	public void testeFuncaoIncrementa(){
		/*
		 * int inc(int x){
		 * 		return (x + 1);
		 * }
		 */
		DeclaracaoFuncao inc = new DeclaracaoFuncao();
		 inc.setNome ("inc");
		 inc.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		 inc.setCorpo (soma(refId("x"), inteiro(1)));
		
		/*
		 * Declarando a funcao no ambiente de execucao
		 */
		AmbienteExecucao.getInstancia().declaraFuncao(inc);
		
		/*
		 * inc((3 + 2)) = 6
		 */
		AvaliadorExpressoes ae = new AvaliadorExpressoes();
		 ae.setNome("inc");
		 ae.setParametro(soma(inteiro(3), inteiro(2)));
		
		Assert.assertEquals(new ValorInteiro(6), ae.avaliar());
	
	}
	
	/* 
	 * A funcao nao foi declarada no ambiente de execucao
	 * portanto o resultado do teste sera uma exception
	 */
	@Test(expected = RuntimeException.class)
	public void  testeFuncaoNaoDeclarada(){
		/*
		 * int dobro(int x){
		 * 		return (x * 2);
		 * }
		 */
		DeclaracaoFuncao dobro = new DeclaracaoFuncao();
		 dobro.setNome ("dobro");
		 dobro.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		 dobro.setCorpo (multiplicacao(refId("x"), inteiro(2)));
		
		/*
		 * dobro(3) = 6; 
		 */
		AvaliadorExpressoes ae = new AvaliadorExpressoes();
		 ae.setNome("dobro");
		 ae.setParametro((inteiro(3)));

		/*
		 * Funcao dobro nao declarada
		 */
		System.out.print("testeFuncaoNaoDeclarada() = ");
		ae.avaliar();		
	}
	
	/*
	 * Funcao chamada tem menos parametros que a funcao declarada
	 */
	@Test(expected = RuntimeException.class)
	public void testeFuncaoMenosParametros(){
		/*
		 * int mult(int x, int y){
		 * 		return (x * y);
		 * }
		 */
		DeclaracaoFuncao mult = new DeclaracaoFuncao();
		 mult.setNome ("mult");
		 mult.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		 mult.setArgumento(new ArgumentoFormal("y", Tipo.INTEIRO));
		 mult.setCorpo (multiplicacao(refId("x"),refId("y")));  
		
		/*
		 * Declarando a funcao no ambiente de execucao
		 */ 
		AmbienteExecucao.getInstancia().declaraFuncao(mult);
		
		/*
		 * mult(3) = ERRO
		 */
		AvaliadorExpressoes ae = new AvaliadorExpressoes();
		 ae.setNome("mult");
		 ae.setParametro(inteiro(3));

		/*
		 * Funcao mult tem menos parametros dos que os declarados
		 */
		System.out.print("testeFuncaoMenosParametros() = ");
		ae.avaliar();	
	}
	
	/*
	 * Funcao chamada tem mais parametros que a funcao declarada
	 */
	@Test(expected = RuntimeException.class)
	public void testeFuncaoMaisParametros(){
		/*
		 * int pow(int x, int y){
		 * 		return (potencia(x, y));
		 * } 
		 */
		DeclaracaoFuncao pow = new DeclaracaoFuncao();
		 pow.setNome ("pow");
		 pow.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		 pow.setArgumento(new ArgumentoFormal("y", Tipo.INTEIRO));
		 pow.setCorpo (potencia(refId("x"),refId("y")));  
	
		/*
		 * Declarando a funcao no ambiente de execucao
		 */
		AmbienteExecucao.getInstancia().declaraFuncao(pow);
		
		/*
		 * pow(3, 2, 1) = ERRO
		 */
		AvaliadorExpressoes ae = new AvaliadorExpressoes();
		 ae.setNome("pow");
		 ae.setParametro(inteiro(3));
		 ae.setParametro(inteiro(2));
		 ae.setParametro(inteiro(1));
		
		/*
		 * Funcao pow tem mais parametros dos que os declarados
		 */
		System.out.print("testeFuncaoMaisParametros() = ");
		ae.avaliar();
	}
	
	/*
	 * Funcao declarada, mas nao chamada
	 */
	@Test(expected = RuntimeException.class)
	public void testeFuncaoNaoChamada(){
		/*
		 * int rzqua(int x){
		 * 		return raiz(x);
		 * }
		 */
		DeclaracaoFuncao rzqua = new DeclaracaoFuncao();
		 rzqua.setNome ("rzqua");
		 rzqua.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		 rzqua.setCorpo (raiz(refId("x")));
		
		/*
		 * Declarando a funcao no ambiente de execucao
		 */
		AmbienteExecucao.getInstancia().declaraFuncao(rzqua);
		
		AvaliadorExpressoes ae = new AvaliadorExpressoes();
		
		/*
		 * Funcao chamada nao tem nome
		 */
		System.out.print("testeFuncaoNaoChamada = ");
		ae.avaliar();
	}
	
	/*
	 * Funcao declarada e chamada tem mesmo nome, mas tipos diferentes
	 */
	@Test(expected = RuntimeException.class)
	public void testeTiposDiferentes(){
		/*
		 * rzqua eh a funcao declarada no testeFuncaoNaoChamada
		 * 
		 * int rzqua(int x){
		 * 		return raiz(x);
		 * }
		 */
		AvaliadorExpressoes ae = new AvaliadorExpressoes();
		 ae.setNome("rzqua");
		 ae.setParametro(new ValorBooleano(true));
		
		/*
		 * Tipo da funcao rzqua nao equivale ao que foi declarado
		 */
		System.out.print("testeTiposDiferentes = ");
		ae.avaliar();
	}
}
