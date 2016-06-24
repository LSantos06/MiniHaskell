package br.unb.cic.poo.parser;
import java.util.Scanner;


public class ProgramaPrincipal {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in); 
	
		System.out.print("> ");
		String exp = sc.nextLine(); 
		Interpretador interpretador = new Interpretador();
		
		while(!exp.equals("exit")) {
			try {
				int res = interpretador.avaliarExpressoes(exp);
				System.out.println("RES = " + res);
			}
			catch(SintaxeInvalida foo) {
				System.out.println(foo.getMessage());
			}
			System.out.print("> ");
			exp = sc.nextLine();
		}
		sc.close();
	}
}