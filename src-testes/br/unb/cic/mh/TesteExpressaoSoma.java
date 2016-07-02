package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

 
/*Utiliza os métodos vi() e soma() de TesteUtil*/
public class TesteExpressaoSoma extends TesteUtil {

	@Test
	public void testSomaSimples() {
		ValorInteiro v5  = vi(5);	//new ValorInteiro(5);
		ValorInteiro v10 = vi(10); 	//new ValorInteiro(10);
		
		ExpressaoSoma soma = soma(v5, v10);	//new ExpressaoSoma(v5, v10);
		
		ValorInteiro res = (ValorInteiro)soma.avaliar();
		Assert.assertEquals(vi(15), res);
	}
	
	@Test
	public void testSomaComplexa() {
		ValorInteiro v5  = vi(5);
		ValorInteiro v10 = vi(10);
		ValorInteiro v20 = vi(20);
		
		ExpressaoSoma soma1 = soma(v5, v10);
		ExpressaoSoma soma2 = soma(soma1, v20);
		
		ValorInteiro res = (ValorInteiro)soma2.avaliar();
		
		Assert.assertEquals(vi(35), res);
	}

}
