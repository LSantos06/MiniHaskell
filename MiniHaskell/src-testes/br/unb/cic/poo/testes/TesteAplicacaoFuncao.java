package br.unb.cic.poo.testes;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.funcoes.AplicacaoFuncao;
import br.unb.cic.poo.funcoes.ArgumentoFormal;
import br.unb.cic.poo.funcoes.DeclaracaoFuncao;
import br.unb.cic.poo.main.AmbienteExecucao;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteAplicacaoFuncao extends TesteUtil {
	
	@Test
	public void testeFuncaoFat(){
		/*
		 * int fat(int x){
		 * 		if (x == 0){
		 * 			return 1;
		 * 		}
		 * 		else {
		 * 			return (x * fat(x-1));
		 * 		}
		 * }
		 */
		// um fatorial recursivo eh a funcao que multiplica o valor corrente com o proximo valor (fat n * fat n-1)
		// a declaracao de funcao eh a mesma independente de n. O que muda eh quantas vezes chamamos(avaliamos essa funcao)
		DeclaracaoFuncao fat = new DeclaracaoFuncao();
		fat.setNome("fat");
		fat.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		fat.setCorpo(ifThenElse(igual(refId("x"), inteiro(1)), 
					   inteiro(1), 
					   multiplicacao(refId("x"),subtracao(refId("x"),inteiro(1) ) )
					   			)
					);
					   
		 
		 /*
		 * Declarando a funcao no ambiente de execucao
		 */
		ValorInteiro v1 = inteiro(3);// valor do n inicial
		// inicio da configuracao da  chamada da funcao (com o n inicial)
		AmbienteExecucao.getInstancia().declaraFuncao(fat);
		AplicacaoFuncao ae = new AplicacaoFuncao();
		 ae.setNome("fat");
		 ae.setParametro(v1);
		 // fim inicio da configuracao da  chamada da funcao
		 
		 // res eh o valor da resposta corrente (ele faz tudo que tem vezes o proximo valor
		 int res = 1;
		 
		 /* ind sao os valores das multiplicacoes em dada iteracao. Exemplo para o fatorial de 5:
		  	ind = 5 => res = 1 * 5 * 4 (Obs.: 5 * 4 provem da avaliacao da funcao fatorial com parametro 5)
		  	ind = 3 => res = 20 * 3 * 2 (Obs.: 3 * 2 provem da avaliacao da funcao fatorial com parametro 3)
		  	ind = 1 => res = 120 * 1 (Obs.: 1 provem da avaliacao da funcao fatorial com parametro 1) */
		 int ind = v1.getValor();
		 while (ind > 0){
			 ValorInteiro result = (ValorInteiro) ae.avaliar();
			res*= result.getValor(); 
			ind -=2;
			ae.resetParametro(inteiro(ind));// reconfigura a chamada da funcao para que ela possa ser realizada com um indice 
			// atualizado como o exemplo
		 }
		 /*
			 * fat(5) = 
			 */
		/*
		 * fat(5)
		 *  5 * fat(4) = 120
	     *
	     * fat(4)
	     *  4 * fat(3) = 24
	     * 
	     * fat(3)
	     *  3 * fat(2) = 6
	     * 
	     * fat(2)
	     *  2 * fat(1) = 2
	     * 
	     * fat(1)
	     *  1 * fat(0) = 1
	     *  
	     * fat(0)
	     *  1 
		 */

		Assert.assertEquals(new ValorInteiro(6), inteiro(res)); 
	
	}
	
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
		AplicacaoFuncao ae = new AplicacaoFuncao();
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
		AplicacaoFuncao ae = new AplicacaoFuncao();
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
		AplicacaoFuncao ae = new AplicacaoFuncao();
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
		AplicacaoFuncao ae = new AplicacaoFuncao();
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
		
		AplicacaoFuncao ae = new AplicacaoFuncao();
		
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
		AplicacaoFuncao ae = new AplicacaoFuncao();
		 ae.setNome("rzqua");
		 ae.setParametro(new ValorBooleano(true));
		
		/*
		 * Tipo da funcao rzqua nao equivale ao que foi declarado
		 */
		System.out.print("testeTiposDiferentes() = ");
		ae.avaliar();
	}
}
