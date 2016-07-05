package br.unb.cic.mh;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoAnd;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoOr;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoDiv;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoMult;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSoma;
import br.unb.cic.mh.expressao.binaria.inteira.ExpressaoSub;
import br.unb.cic.mh.expressao.unaria.ExpressaoNot;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;
import br.unb.cic.mh.visitor.PPVisitor;

public abstract class TesteUtil {
	
	protected PPVisitor prettyPrinter = new PPVisitor();
	
	public ExpressaoSoma soma(Expressao exp1, Expressao exp2) {
		return new ExpressaoSoma(exp1, exp2);
	}
	
	public ExpressaoSub sub(Expressao exp1, Expressao exp2) {
		return new ExpressaoSub(exp1, exp2);
	}
	
	public ExpressaoMult mult(Expressao exp1, Expressao exp2) {
		return new ExpressaoMult(exp1, exp2);
	}
	
	public ExpressaoDiv div(Expressao exp1, Expressao exp2) {
		return new ExpressaoDiv(exp1, exp2);
	}
	
	public ExpressaoAnd and(Expressao exp1, Expressao exp2) {
		return new ExpressaoAnd(exp1, exp2);
	}
	
	public ExpressaoOr or(Expressao exp1, Expressao exp2) {
		return new ExpressaoOr(exp1, exp2);
	}
	
//	public ExpressaoIgualdade equal(Expressao exp1, Expressao exp2) {
//		return new ExpressaoIgualdade(exp1, exp2);
//	}
	
	public ExpressaoNot not(Expressao exp) {
		return new ExpressaoNot(exp);
	}
	
	public ExpressaoRefId ref(String id) {
		return new ExpressaoRefId(id);
	}
	
	public ValorInteiro vi(Integer valor) {
		return new ValorInteiro(valor);
	}
	
	public ValorBooleano vb(Boolean valor) {
		return new ValorBooleano(valor);
	}
}
