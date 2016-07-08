package br.unb.cic.mh;
import org.junit.Assert;
import org.junit.Test;

import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoAnd;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoDiferenca;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoIgualdade;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;
import br.unb.cic.mh.visitor.PPVisitor;
public class TesteIfThenElse {
	public void testeIfThenElseSimples() {
		ValorInteiro v0 = new ValorInteiro(0);
		ValorInteiro v1 = new ValorInteiro(1);
		ValorInteiro v2 = new ValorInteiro(2);
		ValorInteiro v3 = new ValorInteiro(3);
		ExpressaoIfThenElse ite = new ExpressaoIfThenElse(
				new ExpressaoDiferenca<ValorInteiro>(v0, v1), 
				v2,
				v3);
		PPVisitor pp = new PPVisitor();
		pp.visitar(ite);
	}
}
