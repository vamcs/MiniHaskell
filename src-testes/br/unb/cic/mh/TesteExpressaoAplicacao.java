package br.unb.cic.mh;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.unb.cic.mh.expressao.ExpressaoAplicacao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoIgualdade;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoMult;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSub;
import br.unb.cic.mh.valor.ValorInteiro;

import org.junit.Assert;

public class TesteExpressaoAplicacao extends TesteUtil {

	@Test
	public void testeFuncaoIncrementa() {

		ExpressaoRefId x = ref("x");

		DeclFuncao inc = (new DeclFuncao()).nome("inc").argumento(new ArgumentoFormal("x", Tipo.INTEIRO))
				.corpo(soma(x, vi(1)));

		AmbienteExecucao.instance().declararFuncao(inc);

		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("inc").parametro(soma(vi(3), vi(2)));
		Assert.assertEquals(vi(6), ap.avaliar());

		ap = (new ExpressaoAplicacao()).nome("inc").parametro(vi(7));
		Assert.assertEquals(vi(8), ap.avaliar());
	}

	@Test
	public void testeSomaRefId() {
		ExpressaoRefId x = ref("x");
		ExpressaoRefId y = ref("y");

		DeclFuncao soma = (new DeclFuncao()).nome("soma").argumento(new ArgumentoFormal("x", Tipo.INTEIRO))
				.argumento(new ArgumentoFormal("y", Tipo.INTEIRO)).corpo(soma(x, y));

		AmbienteExecucao ambiente = AmbienteExecucao.instance();

		ambiente.declararFuncao(soma);

		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("soma").parametro(vi(2)).parametro(vi(3));

		Assert.assertEquals(vi(5), ap.avaliar());
	}

	@Test
	public void testeFatorial() {
		ValorInteiro v1 = vi(1);
		ValorInteiro v0 = vi(0);
		ExpressaoRefId n = ref("n");
		ExpressaoSub sub = sub(n, v1);
		ExpressaoIgualdade<ValorInteiro> igual = new ExpressaoIgualdade<ValorInteiro>(n, v0);
		
		AmbienteExecucao ambiente = AmbienteExecucao.instance();

		ExpressaoAplicacao apInterna = (new ExpressaoAplicacao())
				.nome("fat")
				.parametro(sub);
		
		ExpressaoMult mult = mult(n, apInterna);
		
		ExpressaoIfThenElse ite = new ExpressaoIfThenElse(igual, v1, mult);
	
		DeclFuncao fat = (new DeclFuncao())
				.nome("fat")
				.argumento(new ArgumentoFormal("n", Tipo.INTEIRO))
				.corpo(ite);
		
		ambiente.declararFuncao(fat);
		
		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("fat").parametro(vi(10));

		Assert.assertEquals(vi(3628800), ap.avaliar());
		
		ap = (new ExpressaoAplicacao()).nome("fat");
		try{
			ap.avaliar();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
