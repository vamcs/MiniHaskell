package br.unb.cic.mh;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe usada para representar declaracoes de 
 * funcoes. 
 * 
 * @author rbonifacio
 */
public class DeclFuncao {

	private String nome;
	private List<ArgumentoFormal> argumentos;
	private Expressao corpo;
	
	public DeclFuncao(String nome, List<ArgumentoFormal> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpo = corpo; 
	}
	
	public DeclFuncao() {
		argumentos = new ArrayList<ArgumentoFormal>();
	}
	
	public DeclFuncao nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public DeclFuncao argumento(ArgumentoFormal arg) {
		this.argumentos.add(arg);
		return this;
	}
	
	public DeclFuncao corpo(Expressao corpo) {
		this.corpo = corpo;
		return this;
	}
	public String getNome() {
		return nome;
	}
	public List<ArgumentoFormal> getArgumentos() {
		return argumentos;
	}
	public Expressao getCorpo() {
		return corpo;
	}
	
	
}

class ArgumentoFormal {
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