package br.unb.cic.poo.testes;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.poo.funcoes.ArgumentoFormal;
import br.unb.cic.poo.funcoes.AvaliadorExpressoes;
import br.unb.cic.poo.funcoes.DeclaracaoFuncao;
import br.unb.cic.poo.main.AmbienteExecucao;
import br.unb.cic.poo.valores.Tipo;
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
}
