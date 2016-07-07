package br.unb.cic.poo.visitor;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoIfThenElse;
import br.unb.cic.poo.expressoes.ExpressaoLet;
import br.unb.cic.poo.expressoes.ExpressaoReferenciaIdentificador;
import br.unb.cic.poo.expressoes.logicas.*;
import br.unb.cic.poo.expressoes.matematicas.*;
import br.unb.cic.poo.expressoes.relacionais.*;
import br.unb.cic.poo.funcoes.AplicacaoFuncao;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;
import br.unb.cic.poo.valores.listas.*;

public class Refatoramento implements Visitor{

	private Expressao resultado;
	
	public Expressao getResultado(){
		return resultado;
	}
	
	@Override
	public void visitar(ExpressaoLet expressao) {}

	@Override
	public void visitar(ExpressaoReferenciaIdentificador expressao) {}

	@Override
	public void visitar(ExpressaoIfThenElse expressao) {
		resultado = expressao;
		
		if(expressao.getClausulaThen() instanceof ValorBooleano &&
		   expressao.getClausulaElse() instanceof ValorBooleano){
			
			boolean clausulaThen = ((ValorBooleano)expressao.getClausulaThen()).getValor();
			boolean clausulaElse = ((ValorBooleano)expressao.getClausulaElse()).getValor();
		
			/*
			 * if (x == 0){
			 * 		return true;
			 * }
			 * else{
			 * 		return false;
			 * }
			 * 
			 * resultado = (x == 0).
			 */
			if(clausulaThen && !clausulaElse){
				resultado = expressao.getCondicao();
			}
		}
		
	}

	@Override
	public void visitar(ExpressaoDivisao expressao) {
		resultado = expressao;
		
		if(expressao.getSubExpressao1() instanceof ValorInteiro &&
		   expressao.getSubExpressao2() instanceof ValorInteiro){
			
			int subExpressao2 = ((ValorInteiro)expressao.getSubExpressao2()).getValor();
			
			/*
			 * Um numero divido por 1 eh igual a ele mesmo.
			 */
			if(subExpressao2 == 1){
				resultado = expressao.getSubExpressao1();
			}
		}
	}

	@Override
	public void visitar(ExpressaoMultiplicacao expressao) {
		resultado = expressao;
		
		if(expressao.getSubExpressao1() instanceof ValorInteiro &&
		   expressao.getSubExpressao2() instanceof ValorInteiro){
			
			int subExpressao2 = ((ValorInteiro)expressao.getSubExpressao2()).getValor();
			
			/*
			 * Um numero multiplicado por 1 eh igual a ele mesmo.
			 */
			if(subExpressao2 == 1){
				resultado = expressao.getSubExpressao1();
			}
			
			/*
			 * Um numero multiplicado por 0 eh igual a 0.
			 */
			if(subExpressao2 == 0){
				resultado = new ValorInteiro(0);
			}
		}
	}

	@Override
	public void visitar(ExpressaoPotencia expressao) {
		resultado = expressao;
		
		if(expressao.getSubExpressao1() instanceof ValorInteiro &&
		   expressao.getSubExpressao2() instanceof ValorInteiro){
			
			int subExpressao2 = ((ValorInteiro)expressao.getSubExpressao2()).getValor();
			
			/*
			 * Um numero elevado a 1 eh igual a ele mesmo.
			 */
			if(subExpressao2 == 1){
				resultado = expressao.getSubExpressao1();
			}
			
			/*
			 * Um numero elevado a 0 eh igual a 1.
			 */
			if(subExpressao2 == 0){
				resultado = new ValorInteiro(1);
			}
		}	
	}

	@Override
	public void visitar(ExpressaoRaizQuadrada expressao) {}

	@Override
	public void visitar(ExpressaoSoma expressao) {
		resultado = expressao;
		
		if(expressao.getSubExpressao1() instanceof ValorInteiro &&
		   expressao.getSubExpressao2() instanceof ValorInteiro){
			
			int subExpressao2 = ((ValorInteiro)expressao.getSubExpressao2()).getValor();
			
			/*
			 * Um numero somado com 0 eh igual a ele mesmo.
			 */
			if(subExpressao2 == 0){
				resultado = expressao.getSubExpressao1();
			}
		}	
	}

	@Override
	public void visitar(ExpressaoSubtracao expressao) {
		resultado = expressao;
		
		if(expressao.getSubExpressao1() instanceof ValorInteiro &&
		   expressao.getSubExpressao2() instanceof ValorInteiro){
			
			int subExpressao2 = ((ValorInteiro)expressao.getSubExpressao2()).getValor();
			
			/*
			 * Um numero subtraido com 0 eh igual a ele mesmo.
			 */
			if(subExpressao2 == 0){
				resultado = expressao.getSubExpressao1();
			}
		}	
		
	}

	@Override
	public void visitar(ExpressaoAND expressao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoNOT expressao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoOR expressao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoDiferente expressao) {}

	@Override
	public void visitar(ExpressaoIgual expressao) {}

	@Override
	public void visitar(ExpressaoMaior expressao) {}

	@Override
	public void visitar(ExpressaoMaiorIgual expressao) {}

	@Override
	public void visitar(ExpressaoMenor expressao) {}

	@Override
	public void visitar(ExpressaoMenorIgual expressao) {}
	
	@Override
	public void visitar(AplicacaoFuncao expressao) {}

	@Override
	public void visitar(ValorBooleano expressao) {}

	@Override
	public void visitar(ValorInteiro expressao) {}

	@Override
	public void visitar(ListaVazia<?> expressao) {}

	@Override
	public void visitar(ListaNaoVazia<?> expressao) {}

}
