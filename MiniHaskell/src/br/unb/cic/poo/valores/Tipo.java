package br.unb.cic.poo.valores;

/**
 * @author LSantos06
 * 
 * Tipos possiveis para uma expressao:
 * 		- Booleano;
 * 		- Inteiro;
 * 		- Funcao, indica que a funcao esta bem tipada;
 * 		- Lista Vazia;
 * 		- Lista Não Vazia. 
 */
public enum Tipo {
	BOOLEANO,
	INTEIRO,
	FUNCAO,
	LISTAVAZIA,
	LISTANAOVAZIA,
	ERRO;
}
