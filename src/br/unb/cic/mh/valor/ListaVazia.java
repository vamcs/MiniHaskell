package br.unb.cic.mh.valor;

public class ListaVazia<T extends Valor> extends Lista {

	private T valor;
	
	public ListaVazia() {
		this.valor = null;
		this.prox = null;
	}

	@Override
	public Valor avaliar() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
