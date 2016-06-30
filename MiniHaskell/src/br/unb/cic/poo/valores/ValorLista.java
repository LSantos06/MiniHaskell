package br.unb.cic.poo.valores;

import br.unb.cic.poo.valores.listas.ListaVazia;
import br.unb.cic.poo.visitor.Visitor;

public abstract class ValorLista<T extends Valor> implements Valor{

	protected T valor;
	protected ValorLista<T> cabeca;
	protected ValorLista<T> cauda;
	
	public abstract ValorLista<T> inserir(T valor);
	public abstract T obterValor();
	public abstract void remover();
	
	public ValorLista(T valor) {
		this.valor = valor;
	}
	
	@Override
	public Tipo tipo() {
		return valor.tipo();
	}
	
	@Override
	public boolean checarTipo() {
		return valor.checarTipo();
	}
	
	@Override
	public Valor avaliar() {
		return valor.avaliar();
	}
	
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public ValorLista<T> getCabeca() {
		return cabeca;
	}
	public void setCabeca(ValorLista<T> cabeca) {
		this.cabeca = cabeca;
	}
	public ValorLista<T> getCauda() {
		return cauda;
	}
	public void setCauda(ValorLista<T> cauda) {
		this.cauda = cauda;
	}
	
	public int tamanho(){
		int tamanho = 0;
		ValorLista<?> aux = this;
		
		while(!(aux instanceof ListaVazia<?>)){
			tamanho++;
			aux = aux.getCauda();
		}
		
		return tamanho;		
	}

	@Override
	public void aceitar(Visitor visitor) {
		visitor.visitar(this);
	}
}
