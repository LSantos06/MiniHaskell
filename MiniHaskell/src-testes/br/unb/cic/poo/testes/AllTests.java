package br.unb.cic.poo.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteAplicacaoFuncao.class, TesteExpressaoAND.class, TesteExpressaoDiferente.class,
		TesteExpressaoDivisao.class, TesteExpressaoIgual.class, TesteExpressaoLet.class, TesteExpressaoMaior.class,
		TesteExpressaoMaiorIgual.class, TesteExpressaoMenor.class, TesteExpressaoMenorIgual.class,
		TesteExpressaoMultiplicacao.class, TesteExpressaoNOT.class, TesteExpressaoOR.class,
		TesteExpressaoPotencia.class, TesteExpressaoRaizQuadrada.class, TesteExpressaoSoma.class,
		TesteExpressaoSubtracao.class })
public class AllTests {

}
