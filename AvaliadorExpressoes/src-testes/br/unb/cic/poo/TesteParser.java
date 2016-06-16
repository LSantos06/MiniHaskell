package br.unb.cic.poo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TesteParser {

	@Test
	public void testParser() {
		Parser p = new Parser();
		
		List<String> retorno = p.parse("5 43 +"); 
		
		Assert.assertEquals(3, retorno.size());
		Assert.assertEquals("5", retorno.get(0));
		Assert.assertEquals("43", retorno.get(1));
		Assert.assertEquals("+", retorno.get(2));
	
	}

}

