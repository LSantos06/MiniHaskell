package br.unb.cic.mh;

/**
 * @author LSantos06
 * 
 * Tipos possiveis para uma expressao:
 * 		- Booleano;
 * 		- Inteiro.
 */
enum Tipo {
	BOOLEANO,
	INTEIRO,
	ERRO;
}

/**
 * @author LSantos06
 * 
 * Uma expressao possui:
 * 		- Um tipo (Booleano ou Inteiro).
 * 		- Uma funcao que checa o tipo da expressao.
 * 		- Uma funcao que avalia a expressao.
 */
public interface Expressao {
	
	public Tipo tipo(); 
	public boolean checarTipo();
	public Valor avaliar();
}
