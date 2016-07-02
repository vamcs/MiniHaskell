package br.unb.cic.mh;

public abstract class ExpressaoUnaria implements Expressao {

	protected Expressao sub;
	
	public ExpressaoUnaria(Expressao sub) {
		this.sub = sub;
	}

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

	public Expressao getSub() {
		return sub;
	}

//	@Override
//	public void aceitar(Visitor v) {
//		// TODO Auto-generated method stub
//
//	}

}
