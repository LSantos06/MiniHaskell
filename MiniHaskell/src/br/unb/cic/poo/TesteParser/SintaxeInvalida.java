package br.unb.cic.poo.TesteParser;


@SuppressWarnings("serial")
public class SintaxeInvalida extends RuntimeException {

	private String exp; 
	public SintaxeInvalida(String exp) {
		super("sintaxe invalida na expressao " + exp);
	}
}