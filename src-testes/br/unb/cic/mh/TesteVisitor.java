package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoAnd;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoOr;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoDiv;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoMult;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSoma;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSub;
import br.unb.cic.mh.expressao.unaria.ExpressaoNot;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

/*Utiliza funções e variáveis definidas em TesteUtil*/
public class TesteVisitor extends TesteUtil {

	@Test
	public void testePrettyPrinterSoma() {
		
		/*PPV para soma*/
		ExpressaoSoma soma = soma(vi(10), vi(5));
		ValorInteiro resSoma = (ValorInteiro)soma.avaliar();
		Assert.assertEquals(vi(15), resSoma);
		soma.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testePrettyPrinterSub() {
		
		/*PPV para subtração*/
		ExpressaoSub sub = sub(vi(10), vi(5));
		ValorInteiro resSub = (ValorInteiro)sub.avaliar();
		Assert.assertEquals(vi(5), resSub);
		sub.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testePrettyPrinterMult() {
		
		/*PPV para multiplicação*/
		ExpressaoMult mult = mult(vi(10), vi(5));
		ValorInteiro resMult = (ValorInteiro)mult.avaliar();
		Assert.assertEquals(vi(50), resMult);
		mult.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testePrettyPrinterDiv() {
		
		/*PPV para divisão*/
		ExpressaoDiv div = div(vi(10), vi(5));
		ValorInteiro resDiv = (ValorInteiro)div.avaliar();
		Assert.assertEquals(vi(2), resDiv);
		div.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testePrettyPrinterAnd() {
		
		/*PPV para operação and*/
		ExpressaoAnd and = and(vb(true), vb(false));
		ValorBooleano resAnd = (ValorBooleano) and.avaliar();
		Assert.assertEquals(vb(false), resAnd);
		and.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testePrettyPrinterOr() {
		
		/*PPV para operação and*/
		ExpressaoOr or = or(vb(true), vb(false));
		ValorBooleano resOr = (ValorBooleano) or.avaliar();
		Assert.assertEquals(vb(true), resOr);
		or.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testePrettyPrinterNot() {
		
		/*PPV para operação and*/
		ExpressaoNot not = not(vb(true));
		ValorBooleano resNot = (ValorBooleano) not.avaliar();
		Assert.assertEquals(vb(false), resNot);
		not.aceitar(prettyPrinter);
		System.out.println("");
	}
	
	@Test
	public void testePrettyPrinterComplexoInteiro() {
		ExpressaoSoma soma = soma(vi(8), vi(5));
		ExpressaoSub sub = sub(soma, vi(7));
		ExpressaoMult mult = mult(sub, vi(6));
		ExpressaoDiv div = div(mult, vi(3));
		ValorInteiro res = (ValorInteiro)div.avaliar();
		Assert.assertEquals(vi(12), res);
		div.aceitar(prettyPrinter);
		System.out.println("");
	}
}
