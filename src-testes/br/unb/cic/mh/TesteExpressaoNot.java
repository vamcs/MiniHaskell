package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

public class TesteExpressaoNot extends TesteUtil {
	@Test
	public void testeNotSimples() {
		ValorBooleano vTrue  = vb(true);	//new ValorBooleano(true);
		ValorBooleano vFalse = vb(false);	//new ValorBooleano(false);
		
		ExpressaoNot not = not(vFalse);	//new ExpressaoNot(vFalse);
		
		ValorBooleano res = (ValorBooleano) not.avaliar();
		Assert.assertEquals(vTrue, res);
		
		not = not(vTrue);
		res = (ValorBooleano) not.avaliar();
		
		Assert.assertEquals(vFalse, res);
		
	}
	
	@Test
	public void testeNotComplexo() {
		ValorBooleano vTrue  = vb(true);	//new ValorBooleano(true);
		ValorBooleano vFalse = vb(false);	//new ValorBooleano(false);
		
		ExpressaoOr or1 = or(vTrue, vFalse);
		ExpressaoAnd and = and(vTrue, vTrue);
		ExpressaoOr or2 = or(or1, and);
		ExpressaoNot not = not(or2);
		
		ValorBooleano res = (ValorBooleano) not.avaliar();
		
		Assert.assertEquals(vFalse, res);
		
		not.aceitar(prettyPrinter);
	}
}
