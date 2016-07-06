package br.unb.cic.poo.TesteParser;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.matematicas.*;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorConcreto;
import br.unb.cic.poo.valores.ValorInteiro;
//IMPORTANTE: programa ainda nao considera a divisao e multiplicacao como prioridades!!!
public class Interpretador {
	// Token sao os tipos de expressoes possiveis na linguagem (completar com booleano, let, ...)
	enum Token { SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO, NUMERO }; 
	private boolean ready = false;
	private Token holdToken;
	
	// ele procura pela string imserida aps o espaco e comepara para ver se cai em algum dos casos especificados
	// soma, subtracao,multiplicacao e divisao. Se nao for, ele considera como um numero por default
	private Token operador(String s) {
		switch (s) {
		 case "+": return Token.SOMA;
		 case "-": return Token.SUBTRACAO;
		 case "*": return Token.MULTIPLICACAO;
		 case "/": return Token.DIVISAO; 
		 default: return Token.NUMERO;
		}
	}
	
	
	// onde eh feita as chamadas as expressoes (reconhece qual eh por meio do token passsado)
	private Expressao avalia(Expressao v1,Expressao v2, Token t) {
		switch(t) {
		  case SOMA: return new ExpressaoSoma(v1,v2); 
		  case SUBTRACAO: return new ExpressaoSubtracao(v2,v1);
		  case MULTIPLICACAO: return new ExpressaoMultiplicacao(v1,v2);
		  case DIVISAO: return new ExpressaoDivisao(v2,v1);
		  default: throw new RuntimeException(); //TODO: nao sei o que fazer. 
		}
	}
	public int avaliarExpressoes(String exp)  {
		Stack<Expressao> stack = new Stack<Expressao>();
		Parser p = new Parser();
		
		List<String> expressao = p.parse(exp);
		
		for(String e : expressao) {
			Token token = operador(e);
			if(token == Token.NUMERO) {
				stack.push(new ValorInteiro(Integer.parseInt(e)));
				System.out.println(Integer.parseInt(e));
			}
		
			if(!ready && token != Token.NUMERO){
				holdToken = token;
				ready = true;
			}
			else if(ready){// so eh ready quando tem o segundo termo da expressao binaria
					Expressao v1 = stack.pop();
				//	System.out.println("Aqui");
					Expressao v2 = stack.pop();
				//	System.out.println("Aqui1");
					Expressao res = avalia(v1, v2, holdToken); 
					stack.push(res);
					ready = false;
			}
		}
		return  ((ValorConcreto<Integer>)stack.pop().avaliar()).getValor();
	}

}
