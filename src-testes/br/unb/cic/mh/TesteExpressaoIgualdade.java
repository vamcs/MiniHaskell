package br.unb.cic.mh;

import org.junit.Test;

import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoAnd;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoIgualdade;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoOr;
import br.unb.cic.mh.expressao.unaria.ExpressaoNot;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

import org.junit.Assert;

public class TesteExpressaoIgualdade extends TesteUtil {
	
	@Test
	public void testeIgualdadeSimples() {
		ValorBooleano vTrue = vb(true);
		ValorBooleano vFalse = vb(false);
		ValorInteiro v10 = vi(10);
		ValorInteiro v5 = vi(5);
		
		/*Compara valores booleanos.*/
		ExpressaoIgualdade<ValorBooleano> equalBoolean = new ExpressaoIgualdade<ValorBooleano>(vTrue, vFalse);
		ValorBooleano res = (ValorBooleano) equalBoolean.avaliar();
		Assert.assertEquals(vFalse, res);
		
		/*Compara valores inteiros.*/
		ExpressaoIgualdade<ValorInteiro> equalInteger = new ExpressaoIgualdade<ValorInteiro>(v10, v5);
		res = (ValorBooleano) equalInteger.avaliar();
		Assert.assertEquals(vFalse, res);
	}
	
	@Test
	public void testeIgualdadeComplexa() {
		ValorBooleano vTrue = vb(true);
		ValorBooleano vFalse = vb(false);
		ValorInteiro v10 = vi(10);
		ValorInteiro v5 = vi(5);
		
		/*(True || False)*/
		ExpressaoOr or = or(vTrue, vFalse);
		
		/*((True || False) && False)*/
		ExpressaoAnd and = and(or, vFalse);
		
		/*not (((True || False) && False))*/
		ExpressaoNot not = not(and);
		
		/*(not == (((True || False) && False))) == True)*/
		ExpressaoIgualdade<ValorBooleano> equal1 = new ExpressaoIgualdade<ValorBooleano>(not, vTrue);
		
		/*(10 == 5)*/
		ExpressaoIgualdade<ValorInteiro> equal2 = new ExpressaoIgualdade<ValorInteiro>(v10, v5);
		
		/*((equal1) == (10 == 5))*/
		ExpressaoIgualdade<ValorBooleano> equal = new ExpressaoIgualdade<ValorBooleano>(equal1, equal2);
		
		/*Resultado final: False.*/
		ValorBooleano res = (ValorBooleano) equal.avaliar();
		Assert.assertEquals(vFalse, res);
		
		equal.aceitar(prettyPrinter);
	}
	
}
