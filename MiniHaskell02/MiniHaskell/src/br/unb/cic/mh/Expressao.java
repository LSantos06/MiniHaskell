package br.unb.cic.mh;

enum Tipo {
	BOOLEANO,
	INTEIRO,
	ERRO;
}

public interface Expressao {
	public Tipo tipo(); 
	public boolean checarTipo();
	public Valor avaliar();
}
