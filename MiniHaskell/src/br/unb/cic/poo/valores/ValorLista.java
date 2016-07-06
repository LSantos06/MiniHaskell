package br.unb.cic.poo.valores;

import br.unb.cic.poo.valores.listas.ListaNaoVazia;
import br.unb.cic.poo.valores.listas.ListaVazia;

public abstract class ValorLista<T extends Valor> implements Valor{

	protected ValorLista<T> anterior;
	
	protected ValorLista() {
		this.anterior = null;
	}
	
	public ValorLista<T> getAnterior() {
		return anterior;
	}
	
	public void setAnterior(ValorLista<T> anterior) {
		this.anterior = anterior;
	}
	
	public ValorLista<T> inserir(T valor) {
		ValorLista<T> novo = new ListaNaoVazia<T>(valor);
		if (this.getAnterior() != null) {
			((ListaNaoVazia<T>) this.getAnterior()).setCauda(novo);
		}
		((ListaNaoVazia<T>) novo).setCauda(this);
		novo.setAnterior(this.getAnterior());
		this.setAnterior(novo);
		
		return novo;
	}
	
	public abstract Valor obterValor();
	
	@SuppressWarnings("unchecked")
	public int tamanho(){
		int tamanho = 0;
		ValorLista<?> aux = this;
		
		while(!(aux instanceof ListaVazia<?>)){
			tamanho++;
			aux = ((ListaNaoVazia<T>) aux).getCauda();
		}
		
		return tamanho;		
	}
}
