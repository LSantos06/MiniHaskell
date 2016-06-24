package br.unb.cic.poo.valores;

import br.unb.cic.poo.visitor.Visitor;

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
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}
