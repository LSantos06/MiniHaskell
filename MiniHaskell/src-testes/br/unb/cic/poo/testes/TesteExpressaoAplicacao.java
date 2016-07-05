package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.funcoes.ArgumentoFormal;
import br.unb.cic.poo.funcoes.AvaliadorExpressoes;
import br.unb.cic.poo.funcoes.DeclaracaoFuncao;
import br.unb.cic.poo.main.AmbienteExecucao;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class TesteExpressaoAplicacao extends TesteUtil {
	@Test
	public void testeFuncaoIncrementa(){
		DeclaracaoFuncao inc = new DeclaracaoFuncao();
		 inc.setNome ("inc");
		 inc.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		 inc.setCorpo (soma(refId("x"), inteiro(1)));
		
		AmbienteExecucao.getInstancia().declaraFuncao(inc);
		
		AvaliadorExpressoes ap = new AvaliadorExpressoes();
		ap.setNome("inc");
		ap.setParametro(soma(inteiro(3), inteiro(2)));
		
		Assert.assertEquals(new ValorInteiro(6), ap.avaliar());
	
	}
	@Test
	public void  testeFuncaoNaoDeclarada(){
		// a funcao f nao foi delcarada no ambiente de execucao,
		DeclaracaoFuncao f = new DeclaracaoFuncao();
		 f.setNome ("dobro");
		 f.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		 f.setCorpo (multiplicacao(refId("x"), inteiro(2)));
		
		 //se a linha abaixo for comentada o teste passa 
		//AmbienteExecucao.getInstancia().declaraFuncao(f);
		
		AvaliadorExpressoes f1 = new AvaliadorExpressoes();
		f1.setNome("dobro");
		f1.setParametro((inteiro(3)));
		Assert.assertEquals(new ValorInteiro(6), f1.avaliar());
	}
	// Funcao chamada tem menos elementos que a funcao declarada
	// esse teste realiza multiplicacao entre x e y
	@Test
	public void testeFuncaoMenosElementos(){
		DeclaracaoFuncao mult = new DeclaracaoFuncao();
		 mult.setNome ("mult");
		 mult.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		 mult.setArgumento(new ArgumentoFormal("y", Tipo.INTEIRO));
		 mult.setCorpo (multiplicacao(refId("x"),refId("y")));  
		 
		 AmbienteExecucao.getInstancia().declaraFuncao(mult);
		AvaliadorExpressoes AvalM = new AvaliadorExpressoes();
		AvalM.setNome("mult");
		// so coloca um parametro na lista de argumentos, mas a funcao precisa de 2
		AvalM.setParametro(inteiro(3));
		// se a linha abaixo for descomentada, o teste passa a funcionar
		//AvalM.setParametro(inteiro(1));
		Assert.assertEquals(new ValorInteiro(3), AvalM.avaliar());
	}
	
	// Funcao chamada tem mais elementos que a funcao declarada
	// esse teste realiza potencia de x^y
	@Test
	public void testeFuncaoMaisElementos(){
		DeclaracaoFuncao pow = new DeclaracaoFuncao();
		pow.setNome ("pow");
		pow.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		pow.setArgumento(new ArgumentoFormal("y", Tipo.INTEIRO));
		pow.setCorpo (potencia(refId("x"),refId("y")));  
		
		AmbienteExecucao.getInstancia().declaraFuncao(pow);
		
		AvaliadorExpressoes AvalPot = new AvaliadorExpressoes();
		AvalPot.setNome("pow");
		// coloca 3 parametros na lista de argumentos, mas a funcao so tem 2
		AvalPot.setParametro(inteiro(3));
		AvalPot.setParametro(inteiro(2));
		// se a linha abaixo for comentada, o teste passa a funcionar
		AvalPot.setParametro(inteiro(1));
		Assert.assertEquals(inteiro(9), AvalPot.avaliar());
	}
	// Funcao foi declarada ,mas nao foi chamada
	@Test
	public void testeFuncaoNaoChamada(){
		DeclaracaoFuncao RAIZ = new DeclaracaoFuncao();
		
		RAIZ.setNome ("raiz");
		RAIZ.setArgumento(new ArgumentoFormal("x", Tipo.INTEIRO));
		RAIZ.setCorpo (raiz(refId("x")));
		
		
		AmbienteExecucao.getInstancia().declaraFuncao(RAIZ);
		AvaliadorExpressoes Raiz = new AvaliadorExpressoes();
		//Descomentar as linhas abaixo para o teste "dar barra verde" (passar)
		
		/*Raiz.setNome("raiz");
		Raiz.setParametro(inteiro(4));
		*/
		Assert.assertEquals(inteiro(2), Raiz.avaliar());
	}
	
	// Funcoao declarada e chamda tem mesmo nome mas tipos diferentes
	@Test
	public void testeTiposDiferentes(){
		AvaliadorExpressoes Booleano = new AvaliadorExpressoes();
		// raiz eh a funcao declarada no testeFuncaoNaoChamada
		Booleano.setNome("raiz");
		// comentar essa linha para teste funcionar
		Booleano.setParametro(new ValorBooleano(true));
		//Descomentar essa linha para teste funcionar
		//Booleano.setParametro(inteiro(4));
		Assert.assertEquals(inteiro(2), Booleano.avaliar());
	}
}
