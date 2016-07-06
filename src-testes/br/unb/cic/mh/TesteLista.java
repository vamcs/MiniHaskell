package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.valor.ListaNaoVazia;
import br.unb.cic.mh.valor.ListaVazia;
import br.unb.cic.mh.valor.ValorInteiro;

public class TesteLista extends TesteUtil {

	@Test
	public void testeListaSimples() {
		ListaNaoVazia<ValorInteiro> lista = new ListaNaoVazia<ValorInteiro>(vi(5), null);
		
		Assert.assertEquals(vi(5), lista.avaliar());
		
		lista = lista.cons(vi(4));
		
		Assert.assertEquals(vi(4), lista.avaliar());
		Assert.assertEquals(vi(5), lista.getProx().avaliar());
		
		try {
			ListaVazia<ValorInteiro> listaVazia = new ListaVazia<ValorInteiro>();
			lista.insereLista(listaVazia, (ListaNaoVazia<ValorInteiro>) lista.getProx());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		Assert.assertEquals(null, ((ListaNaoVazia<ValorInteiro>) lista.getProx()).getProx());
		
	}
	
	@Test
	public void testeListaVazia() {
		ListaVazia<ValorInteiro> listaVazia = new ListaVazia<ValorInteiro>();
		
		Assert.assertEquals(null, listaVazia.avaliar());
		
	}
	
}
