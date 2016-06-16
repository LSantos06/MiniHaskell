package br.unb.cic.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
