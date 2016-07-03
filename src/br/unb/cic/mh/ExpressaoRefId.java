package br.unb.cic.mh;

import br.unb.cic.mh.visitor.Visitor;

/**
 * Expressao que corresponde a uma referencia a um identificado, seja ele usado
 * no corpo de uma expressao Let ou no corpo de uma aplicacao de funcao.
 * 
 * @author rbonifacio
 */
public class ExpressaoRefId implements Expressao {

	private String id;

	public ExpressaoRefId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public Tipo tipo() {
		Expressao exp = AmbienteExecucao.instance().obterExpressao(id);
		if(exp != null) {
			return exp.tipo();
		}
		throw new RuntimeException("Variaval: " + id + " nao declarada");
	}

	@Override
	public boolean checarTipo() {
		Expressao exp = AmbienteExecucao.instance().obterExpressao(id);
		if(exp != null) {
			return exp.checarTipo();
		}
		throw new RuntimeException("Variavel: " + id + " nao declarada");
	}

	@Override
	public Valor avaliar() {
		Expressao exp = AmbienteExecucao.instance().obterExpressao(id);
		if(exp != null) {
			return exp.avaliar();
		}
		throw new RuntimeException("Variavel: " + id + " nao declarada");
	}
	
	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
