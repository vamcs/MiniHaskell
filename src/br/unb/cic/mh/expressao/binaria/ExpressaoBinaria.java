package br.unb.cic.mh.expressao.binaria;

import br.unb.cic.mh.expressao.Expressao;
import br.unb.cic.mh.visitor.Visitor;

/**
 * Classe que representa todas as operações que envolvem dois valores e um resultado.
 * Foi subdivida em expressões que retornam um valor booleano e um valor inteiro.
 * 
 * @author vamcs
 *
 */
public abstract class ExpressaoBinaria implements Expressao{

	// ===========================================================
	// Atributos
	// ===========================================================
	
	protected Expressao sub1;
	protected Expressao sub2;
	
	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ExpressaoBinaria(Expressao s1, Expressao s2) {
		this.sub1 = s1;
		this.sub2 = s2;
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	public abstract String getOperador();
	
	/*A função aceitar vale para todas as subclasses.*/
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
	// ===========================================================
	// Getters & Setters
	// ===========================================================
	
	public Expressao getSub1() {
		return sub1;
	}
	
	public Expressao getSub2() {
		return sub2;
	}
	
}
