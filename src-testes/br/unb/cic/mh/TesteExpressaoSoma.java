package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSoma;
import br.unb.cic.mh.valor.ValorInteiro;

 
/*Utiliza os métodos vi() e soma() de TesteUtil*/
public class TesteExpressaoSoma extends TesteUtil {

	@Test
	public void testeSomaSimples() {
		ValorInteiro v5  = vi(5);	//new ValorInteiro(5);
		ValorInteiro v10 = vi(10); 	//new ValorInteiro(10);
		
		ExpressaoSoma soma = soma(v5, v10);	//new ExpressaoSoma(v5, v10);
		
		ValorInteiro res = (ValorInteiro)soma.avaliar();
		Assert.assertEquals(vi(15), res);
	}
	
	@Test
	public void testeSomaComplexa() {
		ValorInteiro v5  = vi(5);
		ValorInteiro v10 = vi(10);
		ValorInteiro v20 = vi(20);
		
		ExpressaoSoma soma1 = soma(v5, v10);
		ExpressaoSoma soma2 = soma(soma1, v20);
		
		ValorInteiro res = (ValorInteiro)soma2.avaliar();
		
		Assert.assertEquals(vi(35), res);
	}
	
	/*
	@Test
	public void testeSomaErro() {
		ValorBooleano vTrue = new ValorBooleano(true);
		ValorInteiro v5 = vi(5);
		
		ExpressaoSoma soma = soma(v5, vTrue);
		
		ValorInteiro res = (ValorInteiro)soma.avaliar();
		
		Assert.assertEquals(vi(5), res);
		
	}*/

}
