package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoOr;
import br.unb.cic.mh.valor.ValorBooleano;

public class TesteExpressaoOr extends TesteUtil {
	
	@Test
	public void testeOrSimples() {
		ValorBooleano vTrue  = vb(true);	//new ValorBooleano(true);
		ValorBooleano vFalse = vb(false);	//new ValorBooleano(false);
		
		ExpressaoOr or = or(vTrue, vFalse);	//new ExpressaoOr(vTrue, vFalse);
		
		ValorBooleano res = (ValorBooleano) or.avaliar();
		Assert.assertEquals(vTrue, res);
		
		or = or(vTrue, vTrue);
		res = (ValorBooleano) or.avaliar();
		
		Assert.assertEquals(vTrue, res);
		
		or = or(vFalse, vFalse);
		res = (ValorBooleano) or.avaliar();
		
		Assert.assertEquals(vFalse, res);
	}
	
	@Test
	public void testeOrComplexa() {
		ValorBooleano vTrue  = vb(true);	//new ValorBooleano(true);
		ValorBooleano vFalse = vb(false);	//new ValorBooleano(false);
		
		ExpressaoOr or1 = or(vTrue, vFalse);
		ExpressaoOr or2 = or(or1, vFalse);
		
		ValorBooleano res = (ValorBooleano)or2.avaliar();
		
		Assert.assertEquals(vTrue, res);
		
		or2.aceitar(prettyPrinter);
	}
	
}
