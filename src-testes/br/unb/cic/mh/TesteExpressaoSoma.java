package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

 

public class TesteExpressaoSoma {

	@Test
	public void testSomaSimples() {
		ValorInteiro v5  = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		
		ExpressaoSoma soma = new ExpressaoSoma(v5, v10);
		
		ValorInteiro res = (ValorInteiro)soma.avaliar();
		Assert.assertEquals(new Integer(15), res.getValor());
	}
	
	@Test
	public void testSomaComplexa() {
		ValorInteiro v5  = new ValorInteiro(5);
		ValorInteiro v10 = new ValorInteiro(10);
		ValorInteiro v20 = new ValorInteiro(20);
		
		ExpressaoSoma soma1 = new ExpressaoSoma(v5, v10);
		ExpressaoSoma soma2 = new ExpressaoSoma(soma1, v20);
		
		ValorInteiro res = (ValorInteiro)soma2.avaliar();
		
		Assert.assertEquals(new ValorInteiro(35), res);
	}

}
