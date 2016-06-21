package br.unb.cic.poo.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TesteExpressaoDivisao.class, TesteExpressaoMultiplicacao.class, TesteExpressaoSoma.class,
		TesteExpressaoSubtracao.class })
public class AllTests {

}
