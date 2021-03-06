package br.unb.cic.mh;

import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSub;
import br.unb.cic.mh.valor.ValorInteiro;

/*Utiliza os m�todos vi() e soma() de TesteUtil*/
public class TesteExpressaoSub extends TesteUtil {

	@Test
	public void testeSubSimples() {
		ValorInteiro v5  = vi(5);
		ValorInteiro v10 = vi(10);
		
		ExpressaoSub sub = sub(v10, v5);
		
		ValorInteiro res = (ValorInteiro)sub.avaliar();
		Assert.assertEquals(vi(5), res);
	}
	
	@Test
	public void testeSubComplexa() {
		ValorInteiro v5  = vi(5);
		ValorInteiro v10 = vi(10);
		ValorInteiro v20 = vi(20);
		
		ExpressaoSub sub1 = sub(v20, v10);
		ExpressaoSub sub2 = sub(sub1, v5);
		
		ValorInteiro res = (ValorInteiro)sub2.avaliar();
		
		Assert.assertEquals(vi(5), res);
	}
	
	@Test
	public void testeSubNegativa() {
		ValorInteiro v5 = vi(5);
		ValorInteiro v10 = vi(10);
		
		ExpressaoSub sub = sub(v5, v10);
		
		ValorInteiro res = (ValorInteiro)sub.avaliar();
		
		Assert.assertEquals(vi(-5), res);
		/*	Mesmo efeito que:
		*	Assert.assertEquals(new Integer(-5), res.getValor());
		*/
	}

}
