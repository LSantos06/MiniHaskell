package br.unb.cic.poo.visitor;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.ExpressaoAplicacaoFuncao;
import br.unb.cic.poo.expressoes.ExpressaoIfThenElse;
import br.unb.cic.poo.expressoes.ExpressaoLet;
import br.unb.cic.poo.expressoes.ExpressaoReferenciaIdentificador;
import br.unb.cic.poo.expressoes.logicas.*;
import br.unb.cic.poo.expressoes.matematicas.*;
import br.unb.cic.poo.expressoes.relacionais.*;
import br.unb.cic.poo.funcoes.AvaliadorExpressoes;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorInteiro;
import br.unb.cic.poo.valores.listas.*;

public class ImpressaoBonita implements Visitor{

	@Override
	public void visitar(ExpressaoAplicacaoFuncao expressao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoLet expressao) {
		
		/*
		 * let x = 10
		 */
		System.out.print("let ");
		System.out.print(expressao.getId());
		System.out.print(" = ");
		expressao.getExpressao().aceitar(this);
		System.out.println("");
		
		/*
		 * in x + x
		 */
		System.out.print("in ");
		expressao.getCorpo().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoReferenciaIdentificador expressao) {
		System.out.print(expressao.getId());	
		
	}

	@Override
	public void visitar(ExpressaoIfThenElse expressao) {
		
		/*
		 * if (x == 3) then { true } else { false }
		 */
		System.out.print("if (");
		expressao.getCondicao().aceitar(this);
		System.out.print(") then { ");
		expressao.getClausulaThen().aceitar(this);
		System.out.print(" } else { ");
		expressao.getClausulaElse().aceitar(this);
		System.out.print(" }");
	}

	@Override
	public void visitar(ExpressaoDivisao expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" / ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoMultiplicacao expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" * ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}
	
	@Override
	public void visitar(ExpressaoPotencia expressao) {
		/*
		 * ((5)^2)
		 */
		System.out.print("(");
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(")");
		System.out.print("^ ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}
	
	@Override
	public void visitar(ExpressaoRaizQuadrada expressao) {
		/*
		 * (rzqua(2))
		 */
		System.out.print("(rzqua");
		System.out.print("(");
		expressao.getSubExpressao().aceitar(this);
		System.out.println(")");
		System.out.println(")");
		
	}

	@Override
	public void visitar(ExpressaoSoma expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" + ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoSubtracao expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" - ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoAND expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" AND ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoNOT expressao) {
		System.out.print("(NOT");
		expressao.getSubExpressao().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoOR expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" OR ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoDiferente expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" != ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoIgual expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" == ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoMaior expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" > ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(ExpressaoMaiorIgual expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" >= ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}
	
	@Override
	public void visitar(ExpressaoMenor expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" < ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}
	
	@Override
	public void visitar(ExpressaoMenorIgual expressao) {
		System.out.print("(");
		expressao.getSubExpressao1().aceitar(this);
		System.out.print(" <= ");
		expressao.getSubExpressao2().aceitar(this);
		System.out.print(")");
		
	}

	@Override
	public void visitar(AvaliadorExpressoes expressao) {
		//TODO
		
		/*
		 * fat (
		 */
		System.out.print(expressao.getNome());
		System.out.print(" (");
		
		/*
		 * x, y, z, )
		 */
		int contador = 0;
		
		for (Expressao parametro: expressao.getParametros()){
			contador++;
			
			parametro.aceitar(this);
			
			/*
			 * Se a expressao a ser printada nao eh a ultima
			 */
			if (contador != (expressao.getParametros().size())){
				System.out.print(", ");
			}
		}
		System.out.print(")");
		
	}

	@Override
	public void visitar(ValorBooleano expressao) {
		if(expressao.getValor()){
			System.out.println("TRUE");
		}
		else {
			System.out.println("FALSE");
		}	

	}

	@Override
	public void visitar(ValorInteiro expressao) {
		System.out.println(expressao.getValor());
	}

	@Override
	public void visitar(ListaVazia<?> expressao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ListaNaoVazia<?> expressao) {
		// TODO Auto-generated method stub
		
	}
	
	
}
