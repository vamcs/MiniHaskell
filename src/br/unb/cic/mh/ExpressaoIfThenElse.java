package br.unb.cic.mh;

import br.unb.cic.mh.visitor.Visitor;

/**
 * Representa uma expressao do tipo IfThenElse
 * 
 * @author rbonifacio
 */
public class ExpressaoIfThenElse implements Expressao{
	
	private Expressao condicao;
	private Expressao clausulaThen;
	private Expressao clausulaElse;
	
	public ExpressaoIfThenElse(Expressao condicao, Expressao clausulaThen,
			Expressao clausulaElse) {
		this.condicao = condicao;
		this.clausulaThen = clausulaThen;
		this.clausulaElse = clausulaElse;
	}

	@Override
	public Valor avaliar() {
		ValorBooleano c = (ValorBooleano)condicao.avaliar();
		
		if(c.getValor() == true) {
			return clausulaThen.avaliar();
		}
		else {
			return clausulaElse.avaliar();
		}
	}

	@Override
	public Tipo tipo() {
		Tipo cond = condicao.tipo();
		
		if(cond.equals(Tipo.BOOLEANO)) {
			if(clausulaThen.tipo().equals(clausulaElse.tipo())) {
				return clausulaThen.tipo();
			}
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return !tipo().equals(Tipo.ERRO);
	} 
	
	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	public Expressao getCondicao() {
		return condicao;
	}

	public Expressao getClausulaThen() {
		return clausulaThen;
	}

	public Expressao getClausulaElse() {
		return clausulaElse;
	}
	
	
	
	

}
