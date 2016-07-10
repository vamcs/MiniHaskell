package br.unb.cic.mh.visitor;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.expressao.ExpressaoIfThenElse;
import br.unb.cic.mh.expressao.binaria.ExpressaoBinaria;
import br.unb.cic.mh.expressao.binaria.booleana.ExpressaoOr;
import br.unb.cic.mh.expressao.unaria.ExpressaoUnaria;
import br.unb.cic.mh.valor.ValorBooleano;
import br.unb.cic.mh.valor.ValorInteiro;

public class Refactoring extends  Adaptador {

	private Expressao res; 
	private Expressao exp1;
	private Expressao exp2;
	private int flag = 0;
	
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
			
			//Efeito da condicao reversa com o uso das leis de De Morgan
			if(flag == 1)
			{
				res = exp.getClausulaElse();
			}
			if(flag == 2)
			{
				res = exp.getClausulaThen();
			}
		}
	}
	
	/**
	 * Metodo para visitar a expressao de condicao do ifthenelse.
	 * Eh implementado com base das leis de De Morgan para realizar
	 * condicao reversa.
	 */
	
	@Override
	public void visitar(ExpressaoBinaria exp)
	{
		if(exp.getSub1() instanceof ValorBooleano &&
				exp.getSub2() instanceof ValorBooleano)
		{
			
			//Caso a expressao for booleana
			boolean sub1 = !(((ValorBooleano)exp.getSub1()).getValor());
			boolean sub2 = !(((ValorBooleano)exp.getSub2()).getValor());
			
			if(exp.getOperador() == "&&")
			{
				if(sub1 || sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			else if(exp.getOperador() == "||")
			{
				if(sub1 && sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			else if(exp.getOperador() == "==")
			{
				if(sub1 != sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			else if(exp.getOperador() == "!=")
			{
				if(sub1 == sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			
		}
		
		//Caso a expressao for inteira
		else if(exp.getSub1() instanceof ValorInteiro &&
				exp.getSub2() instanceof ValorInteiro)
		{
			int sub1 = ((ValorInteiro)exp.getSub2()).getValor();
			int sub2 = ((ValorInteiro)exp.getSub1()).getValor();
			
			if(exp.getOperador() == "==")
			{
				if(sub1 != sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			else if(exp.getOperador() == "!=")
			{
				if(sub1 == sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			else if(exp.getOperador() == "<")
			{
				if(sub1 <= sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			else if(exp.getOperador() == "<=")
			{
				if(sub1 < sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			else if(exp.getOperador() == ">")
			{
				if(sub1 >= sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
			else if(exp.getOperador() == ">=")
			{
				if(sub1 > sub2)
				{
					flag = 1;
				}
				else
				{
					flag = 2;
				}
			}
		}
	}
	
	public Expressao getRes() {
		return res;
	}
}
