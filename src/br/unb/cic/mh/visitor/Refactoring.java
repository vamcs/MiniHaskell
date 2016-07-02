package br.unb.cic.mh.visitor;

import br.unb.cic.mh.Expressao;
import br.unb.cic.mh.ExpressaoIfThenElse;
import br.unb.cic.mh.ValorBooleano;

public class Refactoring extends  Adaptador {

	public Expressao res; 
	
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
