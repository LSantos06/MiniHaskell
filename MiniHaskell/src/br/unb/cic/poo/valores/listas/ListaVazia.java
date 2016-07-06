package br.unb.cic.poo.valores.listas;

import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorLista;
import br.unb.cic.poo.visitor.Visitor;

public class ListaVazia<T extends Valor> extends ValorLista<T> {

	public ListaVazia() {
		super();
	}

	@Override
	public T obterValor() {
		return null;
	}

	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
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
		return null;
	}
	
}

