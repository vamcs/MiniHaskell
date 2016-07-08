package br.unb.cic.mh.valor;

import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.visitor.Visitor;

//TODO: organizar classes e criar cabeca da lista
public abstract class Lista implements Valor {

	protected Valor valor;
	protected Lista prox;
	
	public Lista(Valor valor) {
		this.valor = valor;
		this.prox = null;
		
	}

	public Valor getValor() {
		return valor;
	}

	public Lista getProx() {
		return prox;
	}

	public static void insereLista(ListaNaoVazia<?> local, Lista novo) {

		if (novo.getClass() != ListaVazia.class) {
			novo.prox = local.prox;
			local.prox = novo;
		} else {
			throw new RuntimeException("Proibido inserir lista vazia.");
		}
	}
	
//	public static int tamanhoLista(Lista lista) {
//		
//		if (lista.getValor() != null) {
//			//Lista com 1 ou mais elementos.
//			while (lista.get) {
//				
//			}
//		}
//		else {
//			//Lista vazia.
//			return 0;
//		}
//		
//		return tamanho;
//	}
	
	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
