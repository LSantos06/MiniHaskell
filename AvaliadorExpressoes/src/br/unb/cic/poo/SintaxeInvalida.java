package br.unb.cic.poo;

public class SintaxeInvalida extends Exception {

	private String exp; 
	public SintaxeInvalida(String exp) {
		super("sintaxe invalida na expressao " + exp);
	}
}
