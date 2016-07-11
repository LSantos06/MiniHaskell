package br.unb.cic.poo.TesteParser;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import br.unb.cic.poo.expressoes.Expressao;
import br.unb.cic.poo.expressoes.logicas.ExpressaoAND;
import br.unb.cic.poo.expressoes.logicas.ExpressaoNOT;
import br.unb.cic.poo.expressoes.logicas.ExpressaoOR;
import br.unb.cic.poo.expressoes.matematicas.*;
import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorConcreto;
import br.unb.cic.poo.valores.ValorInteiro;
//IMPORTANTE: programa ainda nao considera a divisao e multiplicacao como prioridades!!!
public class Interpretador {
	// Token sao os tipos de expressoes possiveis na linguagem (completar com booleano, let, ...)
	enum Token { AND,NOT,OR,STR,BOOL,ITE,LET,SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO, NUMERO }; 
	private boolean ready = false;
	private Token holdToken;
	
	// ele procura pela string imserida aps o espaco e comepara para ver se cai em algum dos casos especificados
	// soma, subtracao,multiplicacao e divisao. 
	// Gramatica do programa
	private Token operador(String s) throws Exception {
		switch (s) {
		 case "+": return Token.SOMA;
		 case "-": return Token.SUBTRACAO;
		 case "*": return Token.MULTIPLICACAO;
		 case "/": return Token.DIVISAO; 
		 case "if": return Token.ITE;// ITE = IfThenElse
		 case "let": return Token.LET;
		 case "bool": return Token.BOOL;
		 case "int": return Token.NUMERO;
		 case "not": return Token.NOT;
		 case "or": return Token.OR;
		 case "and": return Token.AND;
		 default: // aqui ele vai tentar verificar se o que foi passado eh inteiro, booleano ou nome(usado para variaveis). Ainda nao faz operacao com nomes
			 try{
				Integer.parseInt(s);
				 return Token.NUMERO;
			 }catch (Exception e1){
				 try{
						Boolean.parseBoolean(s);
						return Token.BOOL;
					 }catch(Exception e2){// nao eh booleano
						 return Token.STR;
					 }
	
			 }
			 
			 // nao eh uma palavra de operacaoes. Entao pode ser um numero, booleano ou um nome 
		}
	}
	
	
	// onde eh feita as chamadas as expressoes (reconhece qual eh por meio do token passsado)
	private Expressao avalia(Expressao v1,Expressao v2, Token t) {
		switch(t) {
		  case SOMA: return new ExpressaoSoma(v1,v2); 
		  case SUBTRACAO: return new ExpressaoSubtracao(v2,v1);
		  case MULTIPLICACAO: return new ExpressaoMultiplicacao(v1,v2);
		  case DIVISAO: return new ExpressaoDivisao(v2,v1);
		  case NOT: return new ExpressaoNOT(v1);
		  case AND: return new ExpressaoAND(v1,v2);
		  case OR: return new ExpressaoOR(v1,v2);
		  default: throw new RuntimeException(); //TODO: nao sei o que fazer. 
		}
	}
	
	// retorna a string correspondente a avaliacao da string passada
	public String avaliarExpressoes(String exp) throws Exception  {
		Stack<Expressao> stack = new Stack<Expressao>();
		Parser p = new Parser();
		
		List<String> expressao = p.parse(exp);
		
		for(String e : expressao) {
			Token token = operador(e);
			if(token == Token.NUMERO) {
				stack.push(new ValorInteiro(Integer.parseInt(e)));
				System.out.println(Integer.parseInt(e));
			}
			if(token == Token.BOOL){
				stack.push(new ValorBooleano(Boolean.parseBoolean(e)));
			}
		
			if(!ready && (EhMatematica(token) || EhLogica(token) )){
				holdToken = token;
				ready = true;
			}
			else if(ready){// so eh ready quando tem o segundo termo da expressao binaria
					Expressao v1 = stack.pop();
					Expressao v2;
					if (holdToken != Token.NOT){
						 v2 = stack.pop();
					}else {
						 v2 = null;
					}
					Expressao res = avalia(v1, v2, holdToken); 
					stack.push(res);
					ready = false;
			}
		}
		ready = false;// sempre que for numero usa esse metodo
		if (stack.peek().tipo()==Tipo.INTEIRO){// se ve o tipo da resposta eh inteiro
			return  toString().valueOf((((ValorConcreto<Integer>)stack.pop().avaliar()).getValor()));
		}else if(stack.peek().tipo()== Tipo.BOOLEANO){// ve se o tipo da resposta eh booleano
			return toString().valueOf((((ValorConcreto<Boolean>)stack.pop().avaliar()).getValor()));
		}else {// aqui ainda nao esta sendo considerada o tipo lista
			return "Ha um erro de tipos";
		}
	}
	
	private boolean EhLogica(Token t) {
		return t== Token.AND  || t == Token.OR || t== Token.NOT;
	}


	public boolean EhMatematica (Token t){
		return t== Token.DIVISAO  || t == Token.SOMA || t== Token.MULTIPLICACAO || t == Token.SUBTRACAO;
	}

}
