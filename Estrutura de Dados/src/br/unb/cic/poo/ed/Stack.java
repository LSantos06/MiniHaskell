package br.unb.cic.poo.ed;

public interface Stack<T> {
	public void push(T value);
	public T pop();
	public T top(); 
	public int size(); 
}
