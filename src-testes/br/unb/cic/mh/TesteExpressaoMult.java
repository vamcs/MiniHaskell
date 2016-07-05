package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoMult;
import br.unb.cic.mh.valor.ValorInteiro;

public class TesteExpressaoMult extends TesteUtil {

	@Test
	public void testeMultSimples() {
		ValorInteiro v5  = vi(5);	//new ValorInteiro(5);
		ValorInteiro v10 = vi(10); 	//new ValorInteiro(10);
		
		ExpressaoMult mult = mult(v5, v10);	//new ExpressaoMult(v5, v10);
		
		ValorInteiro res = (ValorInteiro)mult.avaliar();
		Assert.assertEquals(vi(50), res);
	}
	
	@Test
	public void testeMultComplexa() {
		ValorInteiro v5  = vi(5);
		ValorInteiro v10 = vi(10);
		ValorInteiro v20 = vi(20);
		
		ExpressaoMult mult1 = mult(v5, v10);
		ExpressaoMult mult2 = mult(mult1, v20);
		
		ValorInteiro res = (ValorInteiro)mult2.avaliar();
		
		Assert.assertEquals(vi(1000), res);
	}
	
}
