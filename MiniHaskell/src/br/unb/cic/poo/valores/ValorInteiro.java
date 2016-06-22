package br.unb.cic.poo.valores;

/**
 * @author LSantos06
 * 
 * Classe que representa os valores INTEIROS da linguagem.
 */
public class ValorInteiro extends ValorConcreto<Integer>{

	public ValorInteiro(Integer valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.INTEIRO;
	}
	
}
