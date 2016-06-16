package br.unb.cic.poo.ed;

import java.lang.reflect.Array;

public class ArrayStack<T> implements Stack<T> {
	
	private static final int MAX_SIZE = 10; 
	private int top;
	private T[] elementos; 
	
	public ArrayStack(Class<T> c) {
		top = 0; 
		elementos = (T[])Array.newInstance(c, MAX_SIZE);
	}

	@Override
	public void push(T value) {
		if(size() >= MAX_SIZE) {
			throw new FullStackException();
		}
		elementos[top++] = value;
	}

	@Override
	public T pop() {
		if(size() == 0) { 
			throw new EmptyStackException();
		}
		T value = elementos[--top];
		return value;
	}

	@Override
	public T top() {
		T value = elementos[top-1];
		return value;
	}

	@Override
	public int size() {
		return top;
	}
	
	
}
