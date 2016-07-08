package br.unb.cic.mh.visitor;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.expressao.ExpressaoAplicacao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.ExpressaoLet;
import br.unb.cic.mh.expressao.ExpressaoRefId;
import br.unb.cic.mh.expressao.binaria.ExpressaoBinaria;
import br.unb.cic.mh.expressao.unaria.ExpressaoUnaria;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

import java.util.List;

import br.unb.cic.mh.Tipo;

public class PPVisitor extends Adaptador {

	@Override
	public void visitar(ExpressaoIfThenElse exp) {
		System.out.print("if"+"(");
		visitar((ExpressaoBinaria)exp.getcondicao());
		System.out.print("){\n\t");
		System.out.print("then ");
		visitar((Valor)exp.getclausulaThen());
		System.out.print("\n\t");
		System.out.print("else ");
		visitar((Valor)exp.clausulaElse());
		System.out.print("\n}");
	}
	
	public void visitar(ExpressaoAplicacao exp){
		System.out.print(exp.getnome());
		System.out.print("(");
		int size = exp.getparametros().size();
		for(int i=0;i<size;i++){
			exp.getparametros().get(i).aceitar(this);
			i++;
				if(i<size){
					System.out.print(",");
					exp.getparametros().get(i).aceitar(this);
					i++;
				}

		}
		System.out.print(")");
	}

	@Override
	public void visitar(ExpressaoLet exp) {
		System.out.print("Let " + exp.getId() + " = ");
		exp.getExp().aceitar(this);
		System.out.print(" in ");
		exp.getCorpo().aceitar(this);
	}

	@Override
	public void visitar(ExpressaoRefId exp) {
		System.out.print(exp.getId());
	}
	
	@Override
	public void visitar(ExpressaoBinaria exp) {
		System.out.print("(");
		exp.getSub1().aceitar(this);
		System.out.print(" " + exp.getOperador() + " ");
		exp.getSub2().aceitar(this);
		System.out.print(")");
	}
	
	@Override
	public void visitar(ExpressaoUnaria exp) {
		System.out.print("not (");
		exp.getSub().aceitar(this);
		System.out.print(")");
	}
	
	@Override
	public void visitar(Valor exp) {
		if(exp.tipo()==Tipo.BOOLEANO){
			visitar((ValorBooleano)exp);
		}
		else if(exp.tipo()==Tipo.INTEIRO){
			visitar((ValorInteiro)exp);
		}
		else if(exp.tipo()==Tipo.ERRO){
		}
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
