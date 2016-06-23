package br.unb.cic.poo.valores;

/**
 * @author LSantos06
 * 
 * Tipos possiveis para uma expressao:
 * 		- Booleano;
 * 		- Inteiro.
 */
public enum Tipo {
	BOOLEANO,
	INTEIRO,
	Funcao,// indica que a funcao esta bem tipada
	ERRO;
}
