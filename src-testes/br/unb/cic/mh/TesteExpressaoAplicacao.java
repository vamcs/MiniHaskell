package br.unb.cic.mh;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class TesteExpressaoAplicacao extends TesteUtil {

	@Test
	public void testeFuncaoIncrementa() {
		DeclFuncao inc = (new DeclFuncao()).nome("inc")
				.argumento(new ArgumentoFormal("x", Tipo.INTEIRO))
				.corpo(soma(ref("x"), vi(1)));

		AmbienteExecucao.instance().declararFuncao(inc);

		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("inc").parametro(soma(vi(3), vi(2)));

		Assert.assertEquals(new ValorInteiro(6), ap.avaliar());
	}

	@Test
	public void testeSomaRefId() {
		//ExpressaoRefId x = ref("x");
		//ExpressaoRefId y = ref("y");
		
		DeclFuncao soma = (new DeclFuncao()).nome("soma")
				.argumento(new ArgumentoFormal("x", Tipo.INTEIRO))
				.corpo(soma(ref("x"), ref("x")));
		
		AmbienteExecucao ambiente = AmbienteExecucao.instance();
		
		ambiente.declararFuncao(soma);
		
		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("soma").parametro(vi(2));
		
		Assert.assertEquals(vi(10), ap.avaliar());
	}

}
