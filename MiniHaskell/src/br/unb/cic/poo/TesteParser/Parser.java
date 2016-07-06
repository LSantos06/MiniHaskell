package br.unb.cic.poo.TesteParser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// pega uma string e um espaco
public class Parser {

	public List<String> parse(String string) {
		List<String> retorno = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(string, " ");
		
		while(st.hasMoreTokens()) {
			retorno.add(st.nextToken());
		}
		return retorno;
	}

	
}