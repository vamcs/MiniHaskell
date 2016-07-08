package br.unb.cic.mh.expressao;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.visitor.Visitor;

public interface Expressao {
	public Tipo tipo(); 
	public boolean checarTipo();
	public Valor avaliar();
	//public String getOperator();
	public void aceitar(Visitor v);
}
