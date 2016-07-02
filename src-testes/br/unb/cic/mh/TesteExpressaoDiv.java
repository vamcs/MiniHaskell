package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoDiv extends TesteUtil {
	
	@Test
	public void testDivSimples() {
		ValorInteiro v5  = vi(5);	//new ValorInteiro(5);
		ValorInteiro v10 = vi(10); 	//new ValorInteiro(10);
		
		ExpressaoDiv div = div(v10, v5);	//new ExpressaoDiv(v5, v10);
		
		ValorInteiro res = (ValorInteiro)div.avaliar();
		Assert.assertEquals(vi(2), res);
	}
	
	@Test
	public void testDivEspecial() {
		ValorInteiro v5  = vi(5);	//new ValorInteiro(5);
		ValorInteiro v10 = vi(10); 	//new ValorInteiro(10);
		
		ExpressaoDiv div = div(v5, v10);	//new ExpressaoDiv(v5, v10);
		
		ValorInteiro res = (ValorInteiro)div.avaliar();
		Assert.assertEquals(vi(0), res);
	}
	
	@Test
	public void testDivComplexa() {
		ValorInteiro v5  = vi(5);
		ValorInteiro v10 = vi(10);
		ValorInteiro v50 = vi(50);
		
		ExpressaoDiv div1 = div(v50, v10);
		ExpressaoDiv div2 = div(div1, v5);
		
		ValorInteiro res = (ValorInteiro)div2.avaliar();
		
		Assert.assertEquals(vi(1), res);
	}
}
