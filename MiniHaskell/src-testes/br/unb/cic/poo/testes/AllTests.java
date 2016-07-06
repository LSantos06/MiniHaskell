package br.unb.cic.poo.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteExpressaoAND.class, TesteExpressaoFuncao.class, TesteExpressaoDiferente.class,
		TesteExpressaoDivisao.class, TesteExpressaoIgual.class, TesteExpressaoLet.class, TesteExpressaoMaior.class,
		TesteExpressaoMenor.class, TesteExpressaoMultiplicacao.class, TesteExpressaoNOT.class, TesteExpressaoOR.class,
		TesteExpressaoSoma.class, TesteExpressaoSubtracao.class })
public class AllTests {

}
