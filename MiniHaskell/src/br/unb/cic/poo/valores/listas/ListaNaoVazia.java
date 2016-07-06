package br.unb.cic.poo.valores.listas;

import br.unb.cic.poo.valores.Tipo;
import br.unb.cic.poo.valores.Valor;
import br.unb.cic.poo.valores.ValorLista;
import br.unb.cic.poo.visitor.Visitor;

public class ListaNaoVazia<T extends Valor> extends ValorLista<T> {

	private Valor cabeca;
	private ValorLista<T> cauda;
	
	public ListaNaoVazia(T cabeca) {
		super();
		this.cabeca = cabeca;
		this.cauda = null;
	}

	public Valor getCabeca() {
		return cabeca;
	}

	public void setCabeca(Valor cabeca) {
		this.cabeca = cabeca;
	}

	public ValorLista<T> getCauda() {
		return cauda;
	}

	public void setCauda(ValorLista<T> cauda) {
		this.cauda = cauda;
	}

	@Override
	public Valor obterValor() {
		return this.getCabeca();
	}

	public ValorLista<T> remover() {
		if (this.getAnterior() != null) {
			((ListaNaoVazia<T>) this.getAnterior()).setCauda(this.getCauda());
		}
		this.getCauda().setAnterior(this.getAnterior());
		return this.getCauda();
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
		return cabeca.avaliar();
	}
	
	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);	
	}
}
