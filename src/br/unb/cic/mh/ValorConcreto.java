package br.unb.cic.mh;

public abstract class ValorConcreto<T> implements Valor {

	protected T valor;

	public ValorConcreto(T valor) {
		this.valor = valor;
	}

	@Override
	public Valor avaliar() {
		return this;
	}

	@Override
	public boolean checarTipo() {
		return true;
	}
	
	public T getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object outroValor) {
		if(outroValor instanceof ValorConcreto) {
			ValorConcreto valorConcreto = (ValorConcreto) outroValor;
			return valorConcreto.valor.equals(valor);
		}
		return false;
	}

}
