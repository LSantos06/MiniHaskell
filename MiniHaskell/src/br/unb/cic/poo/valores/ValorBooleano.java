package br.unb.cic.poo.valores;

/**
 * @author LSantos06
 * 
 * Classe que representa os valores BOOLEANOS da linguagem.
 */
public class ValorBooleano extends ValorConcreto<Boolean>{

	public ValorBooleano(Boolean valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.BOOLEANO;
	}	
}
