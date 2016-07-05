package br.unb.cic.mh;

/**
 * Classe que contém a definição dos argumentos formais.
 * São compostos basicamente de um identificador e um tipo.
 * @author rbonifacio
 */
public class ArgumentoFormal {
	private String id;
	private Tipo tipo;
	
	public ArgumentoFormal(String id, Tipo tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	public String getId() {
		return id;
	}
	public Tipo getTipo() {
		return tipo;
	} 
	
	
}