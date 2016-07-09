package br.unb.cic.mh.valor;

public abstract class ValorConcreto<T> implements Valor {

	// ===========================================================
	// Atributos
	// ===========================================================
	
	protected T valor;

	// ===========================================================
	// Construtores
	// ===========================================================
	
	public ValorConcreto(T valor) {
		this.valor = valor;
	}

	// ===========================================================
	// Métodos
	// ===========================================================
	
	@Override
	public Valor avaliar() {
		return this;
	}

	@Override
	public boolean checarTipo() {
		return true;
	}

	@Override
	public boolean equals(Object outroValor) {
		if(outroValor instanceof ValorConcreto) {
			ValorConcreto<?> valorConcreto = (ValorConcreto<?>) outroValor;
			return valorConcreto.valor.equals(valor);
		}
		return false;
	}
	
	// ===========================================================
	// Getters & Setters
	// ===========================================================
	
	public T getValor() {
		return valor;
	}

}
