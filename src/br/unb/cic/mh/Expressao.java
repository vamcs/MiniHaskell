package br.unb.cic.mh;

import br.unb.cic.mh.visitor.Visitor;

enum Tipo {
	BOOLEANO,
	INTEIRO,
	ERRO;
}

public interface Expressao {
	public Tipo tipo(); 
	public boolean checarTipo();
	public Valor avaliar();
	public void aceitar(Visitor v);
}
