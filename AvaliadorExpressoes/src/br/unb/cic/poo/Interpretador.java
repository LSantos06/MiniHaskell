package br.unb.cic.poo;

import java.util.List;

import br.unb.cic.poo.ed.ArrayStack;
import br.unb.cic.poo.ed.EmptyStackException;
import br.unb.cic.poo.ed.Stack;

public class Interpretador {

	enum Token { SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO, NUMERO }; 
	
	private Token operador(String s) {
		switch (s) {
		 case "+": return Token.SOMA;
		 case "-": return Token.SUBTRACAO;
		 case "*": return Token.MULTIPLICACAO;
		 case "/": return Token.DIVISAO; 
		 default: return Token.NUMERO;
		}
	}
	
	private int avalia(int v1, int v2, Token t) {
		switch(t) {
		  case SOMA: return v1 + v2; 
		  case SUBTRACAO: return v2 - v1;
		  case MULTIPLICACAO: return v1 * v2;
		  case DIVISAO: return v2 / v1;
		  default: throw new RuntimeException(); //TODO: nao sei o que fazer. 
		}
	}
	public int avaliarExpressoes(String exp) throws SintaxeInvalida {
		Stack<Integer> stack = new ArrayStack<>(Integer.class);
		Parser p = new Parser();
		
		List<String> expressao = p.parse(exp);
		
		for(String e : expressao) {
			Token token = operador(e);
			if(token == Token.NUMERO) {
				stack.push(Integer.parseInt(e));
			}
			else {
				try {
					int v1 = stack.pop();
					int v2 = stack.pop();
					int res = avalia(v1, v2, token); 
					stack.push(res);
				}
				catch(EmptyStackException err) {
					throw new SintaxeInvalida(exp);
				}
			}
		}
		return stack.pop();
	}
}
