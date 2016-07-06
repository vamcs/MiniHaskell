package br.unb.cic.mh.visitor;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.valor.ValorBooleano;

public class Refactoring extends  Adaptador {

	private Expressao res; 
	
	@Override
	public void visitar(ExpressaoIfThenElse exp) {
		res = exp;
		if(exp.getClausulaThen() instanceof ValorBooleano && 
				exp.getClausulaElse() instanceof ValorBooleano) {
			
			boolean ct = ((ValorBooleano)exp.getClausulaThen()).getValor();
			boolean ce = ((ValorBooleano)exp.getClausulaElse()).getValor();
			
			if(ct && !ce) {
				res = exp.getCondicao();
			}
		}
	}
	
	public Expressao getRes() {
		return res;
	}
}
