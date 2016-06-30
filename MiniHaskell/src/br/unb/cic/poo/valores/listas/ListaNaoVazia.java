package br.unb.cic.poo.valores.listas;

import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorLista;
import br.unb.cic.poo.visitor.Visitor;

public class ListaNaoVazia<T extends Valor> extends ValorLista<T> {

	public ListaNaoVazia(T valor) {
		super(valor);
	}

	@Override
	public ValorLista<T> inserir(T valor) {
		ValorLista<T> novo = new ListaNaoVazia<T>(valor);
		novo.setCabeca(null);
		novo.setCauda(this);
		this.setCabeca(novo);
		return novo;
	}

	@Override
	public T obterValor() {
		return this.getValor();
	}

	@Override
	public void remover() {
		if (this.getCabeca() != null) {
			this.getCabeca().setCauda(this.getCauda());
		}
		this.getCauda().setCabeca(this.getCabeca());
		
	}

	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}
