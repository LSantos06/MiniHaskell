package br.unb.cic.poo.testes;

import org.junit.Test;

import br.unb.cic.poo.valores.ValorBooleano;
import br.unb.cic.poo.valores.ValorConcreto;
import br.unb.cic.poo.valores.ValorInteiro;
import br.unb.cic.poo.valores.ValorLista;
import br.unb.cic.poo.valores.listas.ListaNaoVazia;
import br.unb.cic.poo.valores.listas.ListaVazia;
import org.junit.Assert;

public class TesteValorLista {

	@SuppressWarnings("unchecked")
	@Test
	public void testListaInteiro() {
		ValorLista<ValorInteiro> lista1 = new ListaVazia<ValorInteiro>();
		ValorInteiro v0 = new ValorInteiro(0);
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(3);
		ValorInteiro v5 = new ValorInteiro(5);
		
		// Testando lista vazia
		Assert.assertNull(lista1.getCabeca());
		Assert.assertNull(lista1.getCauda());
		Assert.assertNull(lista1.getAnterior());
		
		// Testando lista com inserção do 1º elemento
		lista1 = lista1.inserir(v1);
		Assert.assertEquals(new Integer(1), ((ValorConcreto<Integer>) lista1.getCabeca()).getValor());
		Assert.assertNull(lista1.getCauda().getCabeca());
		Assert.assertEquals(new Integer(1), lista1.tamanho().getValor());
		
		// Testando lista com inserção do 2º elemento
		lista1 = lista1.inserir(v2);
		Assert.assertEquals(new Integer(2), ((ValorConcreto<Integer>) lista1.getCabeca()).getValor());
		Assert.assertEquals(new Integer(1), ((ValorConcreto<Integer>) lista1.getCauda().getCabeca()).getValor());
		Assert.assertNull(lista1.getCauda().getCauda().getCabeca());
		Assert.assertEquals(new Integer(2), lista1.tamanho().getValor());
		
		// Testando lista com inserção do 3º elemento (elemento v3 inserido no meio da lista)
		ValorLista<ValorInteiro> lista2 = lista1.getCauda().inserir(v3);
		Assert.assertEquals(new Integer(2), ((ValorConcreto<Integer>) lista2.getAnterior().getCabeca()).getValor());
		Assert.assertEquals(new Integer(3), ((ValorConcreto<Integer>) lista2.getCabeca()).getValor());
		Assert.assertEquals(new Integer(1), ((ValorConcreto<Integer>) lista2.getCauda().getCabeca()).getValor());
		Assert.assertNull(lista1.getCauda().getCauda().getCauda().getCabeca());
		Assert.assertEquals(new Integer(3), lista1.tamanho().getValor());
		
		//Testando busca por posição
		Assert.assertEquals(new Integer(2), ((ValorConcreto<Integer>) lista1.buscaPorPosicao(v0).getCabeca()).getValor());
		Assert.assertEquals(new Integer(3), ((ValorConcreto<Integer>) lista1.buscaPorPosicao(v1).getCabeca()).getValor());
		Assert.assertEquals(new Integer(1), ((ValorConcreto<Integer>) lista1.buscaPorPosicao(v2).getCabeca()).getValor());
		Assert.assertEquals(null, lista1.buscaPorPosicao(v5));
		
		// Testando remoção
		lista1.getCauda().getCauda().remover();
		Assert.assertEquals(new Integer(2), ((ValorConcreto<Integer>) lista1.getCabeca()).getValor());
		Assert.assertEquals(new Integer(3), ((ValorConcreto<Integer>) lista1.getCauda().getCabeca()).getValor());
		Assert.assertNull(lista1.getCauda().getCauda().getCabeca());
		Assert.assertEquals(new Integer(2), lista1.tamanho().getValor());
		lista2 = lista1.getCauda().getCauda().remover();
		Assert.assertNotNull(lista2);
		Assert.assertEquals(new Integer(2), lista1.tamanho().getValor());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListaBooleano() {
		ValorBooleano bt = new ValorBooleano(true);
		ValorBooleano bf = new ValorBooleano(false);
		ValorInteiro v0 = new ValorInteiro(0);
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v5 = new ValorInteiro(5);
		
		// Testando lista iniciada com 1 elemento
		ValorLista<ValorBooleano> lista1 = new ListaNaoVazia<ValorBooleano>(bt);
		Assert.assertEquals(true, ((ValorConcreto<Boolean>) lista1.getCabeca()).getValor());
		Assert.assertNull(lista1.getCauda().getCabeca());
		Assert.assertEquals(new Integer(1), lista1.tamanho().getValor());
		
		// Testando lista com inserção do 2º elemento
		lista1 = lista1.inserir(bt);
		Assert.assertEquals(true, ((ValorConcreto<Boolean>) lista1.getCabeca()).getValor());
		Assert.assertEquals(true, ((ValorConcreto<Boolean>) lista1.getCauda().getCabeca()).getValor());
		Assert.assertNull(lista1.getCauda().getCauda().getCabeca());
		Assert.assertEquals(new Integer(2), lista1.tamanho().getValor());
		
		// Testando lista com inserção do 3º elemento (elemento bf inserido no meio da lista)
		ValorLista<ValorBooleano> lista2 = lista1.getCauda().inserir(bf);
		Assert.assertEquals(true, ((ValorConcreto<Boolean>) lista2.getAnterior().getCabeca()).getValor());
		Assert.assertEquals(false, ((ValorConcreto<Boolean>) lista2.getCabeca()).getValor());
		Assert.assertEquals(true, ((ValorConcreto<Boolean>) lista2.getCauda().getCabeca()).getValor());
		Assert.assertNull(lista1.getCauda().getCauda().getCauda().getCabeca());
		Assert.assertEquals(new Integer(3), lista1.tamanho().getValor());
		
		//Testando busca por posição
		Assert.assertEquals(true, ((ValorConcreto<Boolean>) lista1.buscaPorPosicao(v0).getCabeca()).getValor());
		Assert.assertEquals(false, ((ValorConcreto<Boolean>) lista1.buscaPorPosicao(v1).getCabeca()).getValor());
		Assert.assertEquals(true, ((ValorConcreto<Boolean>) lista1.buscaPorPosicao(v2).getCabeca()).getValor());
		Assert.assertEquals(null, lista1.buscaPorPosicao(v5));
		
		// Testando remoção
		lista1.getCauda().getCauda().remover();
		Assert.assertEquals(true, ((ValorConcreto<Boolean>) lista1.getCabeca()).getValor());
		Assert.assertEquals(false, ((ValorConcreto<Boolean>) lista1.getCauda().getCabeca()).getValor());
		Assert.assertNull(lista1.getCauda().getCauda().getCabeca());
		Assert.assertEquals(new Integer(2), lista1.tamanho().getValor());
		lista2 = lista1.getCauda().getCauda().remover();
		Assert.assertNotNull(lista2);
		Assert.assertEquals(new Integer(2), lista1.tamanho().getValor());
		
	}

}
