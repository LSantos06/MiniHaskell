package br.unb.cic.poo.valores.listas;

import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorLista;
import br.unb.cic.poo.visitor.Visitor;

/**
 * @author filipe5214957
 * 
 * Classe que implementa o valor lista vazia
 */
public class ListaVazia<T extends Valor> extends ValorLista<T> {

	public ListaVazia() {
		super(null);
	}
	
	@Override
	public Tipo tipo() {
		return Tipo.LISTAVAZIA;
	}

	@Override
	public boolean checarTipo() {
		return true;
	}

	@Override
	public Valor avaliar() {
		return this;
	}
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
	
}

