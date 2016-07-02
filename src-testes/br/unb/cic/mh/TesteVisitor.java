package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.visitor.PPVisitor;

public class TesteVisitor extends TesteUtil {

	@Test
	public void TestePrettyPrinterSoma() {
		ValorInteiro v5 = vi(5);
		ValorInteiro v10 = vi(10);
		
		PPVisitor v = new PPVisitor();
		
		/*PPV para soma*/
		ExpressaoSoma soma = soma(v10, v5);
		ValorInteiro resSoma = (ValorInteiro)soma.avaliar();
		Assert.assertEquals(vi(15), resSoma);
		soma.aceitar(v);
		System.out.println("");
	}
	
	@Test
	public void TestePrettyPrinterSub() {
		ValorInteiro v5 = vi(5);
		ValorInteiro v10 = vi(10);
		
		PPVisitor v = new PPVisitor();
		
		/*PPV para subtração*/
		ExpressaoSub sub = sub(v10, v5);
		ValorInteiro resSub = (ValorInteiro)sub.avaliar();
		Assert.assertEquals(v5, resSub);
		sub.aceitar(v);
		System.out.println("");
	}
	
	@Test
	public void TestePrettyPrinterMult() {
		ValorInteiro v5 = vi(5);
		ValorInteiro v10 = vi(10);
		
		PPVisitor v = new PPVisitor();
		
		/*PPV para multiplicação*/
		ExpressaoMult mult = mult(v10, v5);
		ValorInteiro resMult = (ValorInteiro)mult.avaliar();
		Assert.assertEquals(vi(50), resMult);
		mult.aceitar(v);
		System.out.println("");
	}
	
	@Test
	public void TestePrettyPrinterDiv() {
		ValorInteiro v5 = vi(5);
		ValorInteiro v10 = vi(10);
		
		PPVisitor v = new PPVisitor();
		
		/*PPV para divisão*/
		ExpressaoDiv div = div(v10, v5);
		ValorInteiro resDiv = (ValorInteiro)div.avaliar();
		Assert.assertEquals(vi(2), resDiv);
		div.aceitar(v);
		System.out.println("");
	}
}
