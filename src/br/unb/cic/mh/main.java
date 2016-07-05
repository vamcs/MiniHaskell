package br.unb.cic.mh;

import org.junit.Assert;

import br.unb.cic.mh.expressao.ExpressaoAplicacao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoIgualdade;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoMult;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSub;
import br.unb.cic.mh.valor.ValorInteiro;

public class main {

	public static void main(String[] args) {
		ExpressaoRefId n = new ExpressaoRefId("n");
		ValorInteiro v0 = new ValorInteiro(0);
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v5 = new ValorInteiro(5);
		ValorInteiro v120 = new ValorInteiro(120);
		ExpressaoSub sub = new ExpressaoSub(n, v1);
		
		AmbienteExecucao ambiente = AmbienteExecucao.instance();

		ExpressaoAplicacao apInterna = (new ExpressaoAplicacao())
				.nome("fat")
				.parametro(sub);
		
		ExpressaoMult mult = new ExpressaoMult(n, apInterna);
		
		ExpressaoIfThenElse ite = new ExpressaoIfThenElse(
				new ExpressaoIgualdade<ValorInteiro>(n, v0), 
				v1,
				mult);
	
		DeclFuncao fat = (new DeclFuncao())
				.nome("fat")
				.argumento(new ArgumentoFormal("n", Tipo.INTEIRO))
				.corpo(ite);
		
		ambiente.declararFuncao(fat);
		
		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("fat").parametro(v5);

		Assert.assertEquals(v120, ap.avaliar());
		ValorInteiro res = (ValorInteiro) ap.avaliar();
		System.out.println(res.getValor());
		
		ap = (new ExpressaoAplicacao()).nome("fat");
		try{
			ap.avaliar();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
