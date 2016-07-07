package br.unb.cic.poo.valores.listas;

import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorLista;
import br.unb.cic.poo.visitor.Visitor;

/**
 * @author filipe5214957
 * 
 * Classe que implementa o valor lista não vazia
 */
public class ListaNaoVazia<T extends Valor> extends ValorLista<T> {
	
	public ListaNaoVazia(T cabeca) {
		super(cabeca);
		ListaVazia<T> cauda = new ListaVazia<T>();
		cauda.setAnterior(this);
		this.setCauda(cauda);
		this.setAnterior(null);
	}

	@Override
	public Tipo tipo() {
		return Tipo.LISTANAOVAZIA;
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
