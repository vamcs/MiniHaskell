package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.valor.Lista;
import br.unb.cic.mh.valor.ListaNaoVazia;
import br.unb.cic.mh.valor.ListaVazia;
import br.unb.cic.mh.valor.ValorInteiro;

public class TesteLista extends TesteUtil {

	@Test
	public void testeListaSimples() {
		//[5]
		ListaNaoVazia<ValorInteiro> lista = new ListaNaoVazia<ValorInteiro>(vi(5));
		Assert.assertEquals(vi(5), lista.avaliar());
		Assert.assertEquals(null, lista.getProx().avaliar());
		
		//[4, 5]
		lista = lista.cons(vi(4));
		Assert.assertEquals(vi(4), lista.avaliar());
		Assert.assertEquals(vi(5), lista.getProx().avaliar());
		Assert.assertEquals(null, lista.getProx().getProx().avaliar());
		
		lista.aceitar(prettyPrinter);
		System.out.println("");
		
		//[4, 5, []]
		try {
			ListaVazia listaVazia = new ListaVazia();
			Lista.insereLista((ListaNaoVazia<ValorInteiro>) lista.getProx(), listaVazia);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		Assert.assertEquals(null, ((ListaNaoVazia<ValorInteiro>) lista.getProx()).getProx().avaliar());
		
		lista.aceitar(prettyPrinter);
		
	}
	
	@Test
	public void testeListaVazia() {
		ListaVazia listaVazia = new ListaVazia();
		
		Assert.assertEquals(null, listaVazia.avaliar());
		
		listaVazia.aceitar(prettyPrinter);
		
	}
	
}
