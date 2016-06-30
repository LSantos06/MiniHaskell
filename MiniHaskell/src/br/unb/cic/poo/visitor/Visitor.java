package br.unb.cic.poo.visitor;

import br.unb.cic.poo.expressoes.ExpressaoAplicacaoFuncao;
import br.unb.cic.poo.expressoes.ExpressaoIfThenElse;
import br.unb.cic.poo.expressoes.ExpressaoLet;
import br.unb.cic.poo.expressoes.ExpressaoReferenciaIdentificador;
import br.unb.cic.poo.expressoes.binarias.*;
import br.unb.cic.poo.expressoes.logicas.*;
import br.unb.cic.poo.expressoes.relacionais.*;
import br.unb.cic.poo.funcoes.AvaliadorExpressoes;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;
import br.unb.cic.poo.valores.ValorLista;

public interface Visitor {
	
	public void visitar(ExpressaoAplicacaoFuncao expressao);
	public void visitar(ExpressaoLet expressao);
	public void visitar(ExpressaoReferenciaIdentificador expressao);
	public void visitar(ExpressaoIfThenElse expressao);
	
	public void visitar(ExpressaoDivisao expressao);
	public void visitar(ExpressaoMultiplicacao expressao);
	public void visitar(ExpressaoSoma expressao);
	public void visitar(ExpressaoSubtracao expressao);
	
	public void visitar(ExpressaoAND expressao);
	public void visitar(ExpressaoNOT expressao);
	public void visitar(ExpressaoOR expressao);
	
	public void visitar(ExpressaoDiferente expressao);
	public void visitar(ExpressaoIgual expressao);
	public void visitar(ExpressaoMaior expressao);
	public void visitar(ExpressaoMaiorIgual expressao);
	public void visitar(ExpressaoMenor expressao);
	public void visitar(ExpressaoMenorIgual expressao);
	
	public void visitar(AvaliadorExpressoes expressao);
	
	public void visitar(ValorBooleano expressao);
	public void visitar(ValorInteiro expressao);
	public void visitar(ValorLista expressao);
	
}
