package br.unb.cic.mh;

import br.unb.cic.mh.visitor.Visitor;

/**
 * Define expressoes nomeadas, cmo 
 * 
 *   let x = 10 
 *   in x + x 
 *  
 * ou seja, associa uma expressao a um identificador, 
 * e depois avalia o corpo que pode referenciar o 
 * identificador. A necessidade da expressao let 
 * fez com que fosse necessario definir um ambiente 
 * de execucao.  
 *  
 * @author rbonifacio
 *
 */
public class ExpressaoLet implements Expressao {

	private String id;
	private Expressao exp;
	private Expressao corpo;
	
	public ExpressaoLet(String id, Expressao exp, Expressao corpo) {
		this.id = id;
		this.exp = exp;
		this.corpo = corpo;
	}

	@Override
	public Tipo tipo() {
		if(checarTipo()) {
			return corpo.tipo();
		}
		return Tipo.ERRO;
	}

	@Override
	public boolean checarTipo() {
		return exp.checarTipo() && corpo.checarTipo();
	}

	@Override
	public Valor avaliar() {
		AmbienteExecucao.instance().associarExpressao(id, exp);
		return corpo.avaliar();
	}
	
	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
