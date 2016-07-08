package br.unb.cic.mh;

import org.junit.Assert;

import br.unb.cic.mh.expressao.ExpressaoAplicacao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoDiferenca;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoIgualdade;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoDiv;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoMult;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSub;
import br.unb.cic.mh.valor.ValorInteiro;
import br.unb.cic.mh.visitor.PPVisitor;

public class main {

	public static void main(String[] args) {
		ExpressaoRefId n = new ExpressaoRefId("n");
		ValorInteiro v0 = new ValorInteiro(0);
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v5 = new ValorInteiro(10);
		ValorInteiro v120 = new ValorInteiro(2);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(3);
		ExpressaoSub sub = new ExpressaoSub(n, v1);
		
		AmbienteExecucao ambiente = AmbienteExecucao.instance();
		
		ExpressaoAplicacao apInterna = (new ExpressaoAplicacao())
				.nome("fat")
				.parametro(sub);

		ExpressaoDiv div = new ExpressaoDiv(n, apInterna);
		ExpressaoMult mult = new ExpressaoMult(n, apInterna);
		ExpressaoIfThenElse ite = new ExpressaoIfThenElse(new ExpressaoIgualdade<ValorInteiro>(n, v0), v1,v2);
		ExpressaoIfThenElse ite2 = new ExpressaoIfThenElse(new ExpressaoDiferenca<ValorInteiro>(v0, v1), v2,v3);
		DeclFuncao fat = (new DeclFuncao()).nome("fat").argumento(new ArgumentoFormal("n", Tipo.INTEIRO)).corpo(ite);
		
		ambiente.declararFuncao(fat);
		
		ExpressaoAplicacao ap = (new ExpressaoAplicacao()).nome("fat").parametro(v5);

		Assert.assertEquals(v120, ap.avaliar());
		
		ValorInteiro res = (ValorInteiro) ap.avaliar();
		//System.out.println(res.getValor());
		
		ap = (new ExpressaoAplicacao()).nome("fat").parametro(v1);
		try{
			ap.avaliar();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
		PPVisitor pp = new PPVisitor();
		System.out.println("******************** Teste Pretty Printer *********************");
		System.out.println();
		System.out.println();
		System.out.println("***************** Pretty Printer ValorInteiro *****************");
		System.out.println();
		pp.visitar(v120);
		System.out.println();
		System.out.println();
		System.out.println("***************** Pretty Printer Mult e aplicacao de funcao *****************");
		System.out.println();
		pp.visitar(mult);
		System.out.println();
		System.out.println();
		System.out.println("***************** Pretty Printer Div e aplicacao de funcao *****************");
		System.out.println();
		pp.visitar(div);
		System.out.println();
		System.out.println();
		System.out.println("***************** Pretty Printer If Then Else *****************");
		System.out.println();
		pp.visitar(ite);
		System.out.println();
		System.out.println();
		pp.visitar(ite2);
		System.out.println();
		
	}
	
}
