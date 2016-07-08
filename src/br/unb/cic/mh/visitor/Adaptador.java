package br.unb.cic.mh.visitor;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.expressao.ExpressaoAplicacao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.ExpressaoLet;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.ExpressaoBinaria;
import br.unb.cic.mh.expressao.unaria.ExpressaoUnaria;
import br.unb.cic.mh.valor.Lista;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

public class Adaptador implements Visitor {


	
	public void visitar(ExpressaoIfThenElse exp) {
	}

	@Override
	public void visitar(ExpressaoLet exp) {
	}

	@Override
	public void visitar(ExpressaoRefId exp) {
	}

	@Override
	public void visitar(ExpressaoAplicacao exp) {
	}

	@Override
	public void visitar(ValorInteiro exp) {
	}

	@Override
	public void visitar(ValorBooleano exp) {
	}

	@Override
	public void visitar(ExpressaoBinaria exp) {
		
	}

	@Override
	public void visitar(ExpressaoUnaria exp) {
		
	}

	@Override
	public void visitar(Lista lista) {
		// TODO Auto-generated method stub
		
	}

	public void visitar(Valor exp) {
		// TODO Auto-generated method stub
		
	}
	


}
