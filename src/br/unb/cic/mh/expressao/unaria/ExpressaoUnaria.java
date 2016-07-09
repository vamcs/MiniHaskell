package br.unb.cic.mh.expressao.unaria;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.visitor.Visitor;

/**
 * Implementa express�es que recebem apenas um valor para opera��o.
 * 
 * @author vamcs
 *
 */
public abstract class ExpressaoUnaria implements Expressao {

	// ===========================================================
	// Atributos
	// ===========================================================
	
	protected Expressao sub;
	
	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ExpressaoUnaria(Expressao sub) {
		this.sub = sub;
	}

	// ===========================================================
	// M�todos
	// ===========================================================
	
	@Override
	public Tipo tipo() {
		if (sub.equals(Tipo.BOOLEANO)) {
			return Tipo.BOOLEANO;
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.BOOLEANO);
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
	// ===========================================================
	// Getters & Setters
	// ===========================================================
	
	public Expressao getSub() {
		return sub;
	}

}
