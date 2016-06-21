package br.unb.cic.poo.valores;

/**
 * @author LSantos06
 * 
 * Classe que implementa os tipos nos valores da linguagem.
 */
public abstract class ValorConcreto<T> implements Valor {

	protected T valor;

	public ValorConcreto(T valor) {
		this.valor = valor;
	}
	
	@Override
	public Valor avaliar() {
		return this;
	}

	@Override
	public boolean checarTipo() {
		return true;
	}
	
	public T getValor() {
		return valor;
	}
}
