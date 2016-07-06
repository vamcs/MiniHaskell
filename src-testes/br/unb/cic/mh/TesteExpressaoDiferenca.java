package br.unb.cic.mh;

import org.junit.Test;

import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoDiferenca;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

import org.junit.Assert;

public class TesteExpressaoDiferenca extends TesteUtil {

	@Test
	public void testeDiferencaSimples() {
		ValorInteiro v1 = vi(1);
		ValorInteiro v2 = vi(2);
		ValorBooleano vTrue = vb(true);
		ValorBooleano vFalse = vb(false);
		
		ExpressaoDiferenca<?> dif = new ExpressaoDiferenca<ValorInteiro>(v1, v2);
		ValorBooleano res = (ValorBooleano) dif.avaliar();
		
		Assert.assertEquals(vTrue, res);
		dif.aceitar(prettyPrinter);
		System.out.println("");
		
		dif = new ExpressaoDiferenca<ValorInteiro>(v1, v1);
		res = (ValorBooleano) dif.avaliar();
		
		Assert.assertEquals(vFalse, res);
		dif.aceitar(prettyPrinter);
		System.out.println("");
		
		dif = new ExpressaoDiferenca<ValorBooleano>(vFalse, vTrue);
		res = (ValorBooleano) dif.avaliar();
		
		Assert.assertEquals(vTrue, res);
		dif.aceitar(prettyPrinter);
		System.out.println("");
		
		dif = new ExpressaoDiferenca<ValorBooleano>(vFalse, vFalse);
		res = (ValorBooleano) dif.avaliar();
		
		Assert.assertEquals(vFalse, res);
		dif.aceitar(prettyPrinter);
		System.out.println("");
	}

}
