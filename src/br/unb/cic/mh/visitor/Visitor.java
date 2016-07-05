package br.unb.cic.mh.visitor;

import br.unb.cic.mh.expressao.ExpressaoAplicacao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.ExpressaoLet;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.ExpressaoBinaria;
import br.unb.cic.mh.expressao.unaria.ExpressaoUnaria;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

public interface Visitor {
	public void visitar(ExpressaoIfThenElse exp);
	public void visitar(ExpressaoLet exp);
	public void visitar(ExpressaoBinaria exp);
	public void visitar(ExpressaoUnaria exp);
	public void visitar(ExpressaoRefId exp);
	public void visitar(ExpressaoAplicacao exp);
	public void visitar(ValorInteiro exp);
	public void visitar(ValorBooleano exp);
}
