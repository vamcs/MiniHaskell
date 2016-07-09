package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.valor.Lista;
import br.unb.cic.mh.valor.ListaNaoVazia;
import br.unb.cic.mh.valor.ListaVazia;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorInteiro;

public class TesteLista extends TesteUtil {

	@Test
	public void testeListaSimples() {
		//[5]
		Lista lista = new ListaNaoVazia<ValorInteiro>(vi(5));
		Assert.assertEquals(vi(5), lista.avaliar());
		Assert.assertEquals(null, lista.getProx().avaliar());
		
		//[4, 5]
		ListaNaoVazia<ValorInteiro> node = new ListaNaoVazia<ValorInteiro>(vi(4));
		lista = lista.cons(node);
		Assert.assertEquals(vi(4), lista.avaliar());
		Assert.assertEquals(vi(5), lista.getProx().avaliar());
		Assert.assertEquals(null, lista.getProx().getProx().avaliar());
		
		lista.aceitar(prettyPrinter);
		System.out.println("");
		
		//[4, 5, []] erro
		try {
			ListaVazia listaVazia = new ListaVazia();
			Lista.insere(lista.getProx(), listaVazia);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		Assert.assertEquals(null, lista.getProx().getProx().avaliar());
		
		lista.aceitar(prettyPrinter);
		
		//[4, 6, 5]
		ListaNaoVazia<ValorInteiro> novo = new ListaNaoVazia<ValorInteiro>(vi(6));
		Lista.insere(lista, novo);
		
		lista.aceitar(prettyPrinter);
		
		System.out.println(Lista.tamanho(lista));
		
		lista = Lista.pop(lista);
		
		lista.aceitar(prettyPrinter);
		
		Valor valor2 = Lista.elemento(lista, 1);
		
		valor2.aceitar(prettyPrinter);
		
	}
	
	@Test
	public void testeListaVazia() {
		ListaVazia listaVazia = new ListaVazia();
		
		Assert.assertEquals(null, listaVazia.avaliar());
		
		listaVazia.aceitar(prettyPrinter);
		
	}
	
}
