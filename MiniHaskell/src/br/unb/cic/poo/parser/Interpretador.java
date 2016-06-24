package br.unb.cic.poo.parser;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Interpretador {

	enum Token { SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO, NUMERO, EXPRESSAO,ERRO }; 
	
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
		Stack<Integer> stack = new Stack<Integer>();
		Parser p = new Parser();
		Token operacao = Token.ERRO;
		int count =0;
		List<String> expressao = p.parse(exp);
		
		for(String e : expressao) {
			Token token = operador(e);
			if(token.equals(Token.NUMERO) && count<2) {
				stack.push(Integer.parseInt(e));
				count++;
			}
			else if(!token.equals(Token.NUMERO) && count <2){// eh uma operacao
				operacao = token;
				
			} else if(expressao.size()>= 4 && count == 2){//expressao complexa

				try {
					
					int v1 = stack.pop();
					int v2 = stack.pop();
					int res = avalia(v1, v2, operacao); 
					stack.push(res);
				}
				catch(EmptyStackException err) {
					throw new SintaxeInvalida(exp);
				}
				count = 0;
			}
		}
		if(expressao.size()<4){
			try {	
				int v1 = stack.pop();
				int v2 = stack.pop();
				int res = avalia(v1, v2, operacao); 
				stack.push(res);
			}
			catch(EmptyStackException err) {
				throw new SintaxeInvalida(exp);
			}
		}
		return stack.pop();
	}
}
