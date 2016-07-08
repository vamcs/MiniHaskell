package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.ExpressaoLet;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoDiferenca;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoIgualdade;
import br.unb.cic.mh.valor.ValorInteiro;

public class TesteExpressaoIfThenElse extends TesteUtil {
	
	@Test
	public void testeIfThenElseSimples() {
		ValorInteiro v1 = vi(1);
		ValorInteiro v2 = vi(2);
		ExpressaoIgualdade<ValorInteiro> igual = new ExpressaoIgualdade<ValorInteiro>(v1, v2);
		ExpressaoDiferenca<ValorInteiro> dif = new ExpressaoDiferenca<ValorInteiro>(v1, v2);
		ExpressaoRefId x = ref("x");
		ExpressaoLet let1 = new ExpressaoLet("x", vi(5), x);
		let1.aceitar(prettyPrinter);
		System.out.println("");
		
		ExpressaoLet let2 = new ExpressaoLet("x", vi(1), x); 
		let1.aceitar(prettyPrinter);
		System.out.println("");
		
		ExpressaoIfThenElse ite = new ExpressaoIfThenElse(igual, let1, let2);
		
		ite.aceitar(prettyPrinter);
		
		Assert.assertEquals(v1, ite.avaliar());
		
		ite = new ExpressaoIfThenElse(dif, let1, let2);
		
		Assert.assertEquals(vi(5), ite.avaliar());
	}
	
}
