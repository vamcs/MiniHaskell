package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressoesRelacionais extends TesteUtil {
	
	@Test
	public void testeMaiorQue() {
		ValorInteiro v10 = vi(10);
		ValorInteiro v5 = vi(5);
		
		ExpressaoMaiorQue gt = new ExpressaoMaiorQue(v10, v5);
		ValorBooleano res = (ValorBooleano) gt.avaliar();
		Assert.assertEquals(vb(true), res);
		gt.aceitar(prettyPrinter);
		System.out.println("");
		
		gt = new ExpressaoMaiorQue(v5, v10);
		res = (ValorBooleano) gt.avaliar();
		Assert.assertEquals(vb(false), res);
		gt.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testeMenorQue() {
		ValorInteiro v10 = vi(10);
		ValorInteiro v5 = vi(5);
		
		ExpressaoMenorQue gt = new ExpressaoMenorQue(v10, v5);
		ValorBooleano res = (ValorBooleano) gt.avaliar();
		Assert.assertEquals(vb(false), res);
		gt.aceitar(prettyPrinter);
		System.out.println("");
		
		gt = new ExpressaoMenorQue(v5, v10);
		res = (ValorBooleano) gt.avaliar();
		Assert.assertEquals(vb(true), res);
		gt.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testeMaiorIgual() {
		ValorInteiro v10 = vi(10);
		ValorInteiro v5 = vi(5);
		
		/*10 >= 10*/
		ExpressaoMaiorIgual gt = new ExpressaoMaiorIgual(v10, v10);
		ValorBooleano res = (ValorBooleano) gt.avaliar();
		Assert.assertEquals(vb(true), res);
		gt.aceitar(prettyPrinter);
		System.out.println("");
		
		/*5 >= 10*/
		gt = new ExpressaoMaiorIgual(v5, v10);
		res = (ValorBooleano) gt.avaliar();
		Assert.assertEquals(vb(false), res);
		gt.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testeMenorIgual() {
		ValorInteiro v10 = vi(10);
		ValorInteiro v5 = vi(5);
		
		/*10 <= 10*/
		ExpressaoMenorIgual gt = new ExpressaoMenorIgual(v10, v10);
		ValorBooleano res = (ValorBooleano) gt.avaliar();
		Assert.assertEquals(vb(true), res);
		gt.aceitar(prettyPrinter);
		System.out.println("");
		
		/*5 <= 10*/
		gt = new ExpressaoMenorIgual(v5, v10);
		res = (ValorBooleano) gt.avaliar();
		Assert.assertEquals(vb(true), res);
		gt.aceitar(prettyPrinter);
		System.out.println("");
	}
}
