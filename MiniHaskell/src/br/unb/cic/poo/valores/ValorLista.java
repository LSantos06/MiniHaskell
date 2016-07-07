package br.unb.cic.poo.valores;

import br.unb.cic.poo.valores.listas.ListaNaoVazia;
import br.unb.cic.poo.valores.listas.ListaVazia;

/**
 * @author filipe5214957
 * 
 * Classe que implementa o valor lista
 */
public abstract class ValorLista<T extends Valor> implements Valor{

	private Valor cabeca;
	private ValorLista<T> cauda;
	private ValorLista<T> anterior;
	
	protected ValorLista(T cabeca) {
		this.cabeca = cabeca;
		this.cauda = null;
		this.anterior = null;
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

	public ValorLista<T> getAnterior() {
		return anterior;
	}
	
	public void setAnterior(ValorLista<T> anterior) {
		this.anterior = anterior;
	}
	
	public ValorLista<T> inserir(T valor) {
		ValorLista<T> novo = new ListaNaoVazia<T>(valor);
		if (this.getAnterior() != null) {
			this.getAnterior().setCauda(novo);
		}
		novo.setCauda(this);
		novo.setAnterior(this.getAnterior());
		this.setAnterior(novo);
		
		return novo;
	}
	
	public ValorLista<T> remover() {
		if(this.tipo() == Tipo.LISTANAOVAZIA){
			if (this.getAnterior() != null) {
				this.getAnterior().setCauda(this.getCauda());
			}
			this.getCauda().setAnterior(this.getAnterior());
			return this.getCauda();
		}
		return this;
	}
	
	public ValorLista<T> buscaPorPosicao (ValorInteiro posicao) {
		ValorLista<T> elemento = this;
		int aux;
		
		for(aux = 0 ; aux != posicao.getValor() ; aux++) {
			if(aux > this.tamanho().getValor()) {
				return null;
			}
			elemento = elemento.getCauda();
		}
		
		return elemento;
	}
	
	public ValorInteiro tamanho (){
		int tamanho = 0;
		ValorLista<?> aux = this;
		
		while(!(aux instanceof ListaVazia<?>)){
			tamanho++;
			aux = ((ListaNaoVazia<?>) aux).getCauda();
		}
		
		return new ValorInteiro(tamanho);		
	}
}
