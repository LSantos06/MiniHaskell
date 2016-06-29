package br.unb.cic.poo.visitor;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoAplicacaoFuncao;
import br.unb.cic.poo.expressoes.ExpressaoIfThenElse;
import br.unb.cic.poo.expressoes.ExpressaoLet;
import br.unb.cic.poo.expressoes.ExpressaoReferenciaIdentificador;
import br.unb.cic.poo.expressoes.binarias.ExpressaoDivisao;
import br.unb.cic.poo.expressoes.binarias.ExpressaoMultiplicacao;
import br.unb.cic.poo.expressoes.binarias.ExpressaoSoma;
import br.unb.cic.poo.expressoes.binarias.ExpressaoSubtracao;
import br.unb.cic.poo.expressoes.logicas.ExpressaoAND;
import br.unb.cic.poo.expressoes.logicas.ExpressaoNOT;
import br.unb.cic.poo.expressoes.logicas.ExpressaoOR;
import br.unb.cic.poo.expressoes.relacionais.ExpressaoDiferente;
import br.unb.cic.poo.expressoes.relacionais.ExpressaoIgual;
import br.unb.cic.poo.expressoes.relacionais.ExpressaoMaior;
import br.unb.cic.poo.expressoes.relacionais.ExpressaoMenor;
import br.unb.cic.poo.funcoes.AvaliadorExpressoes;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;

public class Metrica implements Visitor{

	private int numeroNos = 0;
	
	public int getNumeroNos() {
		return numeroNos;
	}

	@Override
	public void visitar(ExpressaoAplicacaoFuncao expressao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoLet expressao) {
		numeroNos += 1;
		expressao.getExpressao().aceitar(this);
		expressao.getCorpo().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoReferenciaIdentificador expressao) {
		numeroNos += 1;
	}

	@Override
	public void visitar(ExpressaoIfThenElse expressao) {
		numeroNos += 1;
		expressao.getCondicao().aceitar(this);
		expressao.getClausulaThen().aceitar(this);
		expressao.getClausulaElse().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoDivisao expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);	
	}

	@Override
	public void visitar(ExpressaoMultiplicacao expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);	
	}

	@Override
	public void visitar(ExpressaoSoma expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);	
	}

	@Override
	public void visitar(ExpressaoSubtracao expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);	
	}

	@Override
	public void visitar(ExpressaoAND expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);	
	}

	@Override
	public void visitar(ExpressaoNOT expressao) {
		numeroNos += 1;
		expressao.getSubExpressao().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoOR expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);		
	}

	@Override
	public void visitar(ExpressaoDiferente expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);		
	}

	@Override
	public void visitar(ExpressaoIgual expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);		
	}

	@Override
	public void visitar(ExpressaoMaior expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);		
	}

	@Override
	public void visitar(ExpressaoMenor expressao) {
		numeroNos += 1;
		expressao.getSubExpressao1().aceitar(this);
		expressao.getSubExpressao2().aceitar(this);
	}

	@Override
	public void visitar(AvaliadorExpressoes expressao) {
		//TODO
		for(Expressao parametro: expressao.getParametros()){
			parametro.aceitar(this);
		}
		
	}

	@Override
	public void visitar(ValorBooleano expressao) {
		numeroNos += 1;
	}

	@Override
	public void visitar(ValorInteiro expressao) {
		numeroNos += 1;
	}

}
