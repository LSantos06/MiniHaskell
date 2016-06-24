package br.unb.cic.poo.valores;

import br.unb.cic.poo.visitor.Visitor;

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
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}
