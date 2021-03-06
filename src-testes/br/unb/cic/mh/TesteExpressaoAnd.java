package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoAnd;
import br.unb.cic.mh.valor.ValorBooleano;

public class TesteExpressaoAnd extends TesteUtil {
	
	@Test
	public void testeAndSimples() {
		ValorBooleano vTrue  = vb(true);	//new ValorBooleano(true);
		ValorBooleano vFalse = vb(false);	//new ValorBooleano(false);
		
		ExpressaoAnd and = and(vTrue, vFalse);	//new ExpressaoAnd(vTrue, vFalse);
		
		ValorBooleano res = (ValorBooleano) and.avaliar();
		Assert.assertEquals(vFalse, res);
		
		and = and(vTrue, vTrue);
		res = (ValorBooleano) and.avaliar();
		
		Assert.assertEquals(vTrue, res);
		
		and = and(vFalse, vFalse);
		res = (ValorBooleano) and.avaliar();
		
		Assert.assertEquals(vFalse, res);
	}
	
	@Test
	public void testeAndComplexa() {
		ValorBooleano vTrue  = vb(true);	//new ValorBooleano(true);
		ValorBooleano vFalse = vb(false);	//new ValorBooleano(false);
		
		ExpressaoAnd and1 = and(vTrue, vFalse);
		ExpressaoAnd and2 = and(and1, vFalse);
		
		ValorBooleano res = (ValorBooleano)and2.avaliar();
		
		Assert.assertEquals(vFalse, res);
		
		and2.aceitar(prettyPrinter);
	}
	
}
