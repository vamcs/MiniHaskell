package br.unb.cic.mh;


public abstract class TesteUtil {
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
	
	public ExpressaoRefId ref(String id) {
		return new ExpressaoRefId(id);
	}
	
	public ValorInteiro vi(Integer valor) {
		return new ValorInteiro(valor);
	}
}
