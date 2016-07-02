package br.unb.cic.mh.visitor;

import br.unb.cic.mh.ExpressaoAplicacao;
import br.unb.cic.mh.ExpressaoBinaria;
import br.unb.cic.mh.ExpressaoIfThenElse;
import br.unb.cic.mh.ExpressaoLet;
import br.unb.cic.mh.ExpressaoNot;
import br.unb.cic.mh.ExpressaoRefId;
import br.unb.cic.mh.ValorBooleano;
import br.unb.cic.mh.ValorInteiro;

public class PPVisitor extends Adaptador {

	@Override
	public void visitar(ExpressaoIfThenElse exp) {
		
	}

	@Override
	public void visitar(ExpressaoLet exp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ExpressaoBinaria exp) {
		System.out.print("(");
		exp.getSub1().aceitar(this);
		System.out.print(" " + exp.getOperando() + " ");
		exp.getSub2().aceitar(this);
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoNot exp) {
		System.out.print("not (");
		exp.getSub().aceitar(this);
		System.out.print(")");
	}
	
	@Override
	public void visitar(ValorInteiro exp) {
		System.out.print(exp.getValor());
	}

	@Override
	public void visitar(ValorBooleano exp) {
		if(exp.getValor()) {
			System.out.print("True");
		}
		else {
			System.out.print("False");
		}
	}

}
