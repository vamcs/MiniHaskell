package br.unb.cic.mh;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.mh.expressao.Expressao;

/**
 * Classe usada para representar declaracoes de 
 * funcoes. 
 * 
 * @author rbonifacio
 */
public class DeclFuncao {

	// ===========================================================
	// Atributos
	// ===========================================================
	private String nome;
	private List<ArgumentoFormal> argumentos;
	private Expressao corpo;
	
	
	// ===========================================================
	// Construtores
	// ===========================================================
	
	/**
	 * Construtor que inicializa uma função completa.
	 * @param nome da função
	 * @param argumentos : lista de parâmetros da função
	 * @param corpo : expressão da função
	 */
	public DeclFuncao(String nome, List<ArgumentoFormal> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpo = corpo; 
	}
	
	/**
	 * Construtor vazio. Apenas inicializa uma lista vazia de argumentos formais.
	 */
	public DeclFuncao() {
		argumentos = new ArrayList<ArgumentoFormal>();
	}
	
	// ===========================================================
	// Métodos
	// ===========================================================
	
	/**
	 * Define o nome de uma função declarada.
	 * @param nome
	 * @return a própria função declarada
	 */
	public DeclFuncao nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	/**
	 * Adiciona argumentos formais (string, tipo) à função declarada
	 * na lista de argumentos.
	 * @param arg que representa um novo parâmetro da função
	 * @return a própria função declarada
	 */
	public DeclFuncao argumento(ArgumentoFormal arg) {
		this.argumentos.add(arg);
		return this;
	}
	
	/**
	 * Define uma nova expressão para o corpo da função declarada.
	 * @param corpo que define o comportamento da função (expressão)
	 * @return a própria função declarada
	 */
	public DeclFuncao corpo(Expressao corpo) {
		this.corpo = corpo;
		return this;
	}
	
	// ===========================================================
	// Getters & Setters
	// ===========================================================	
	
	/**
	 * @return nome (String) da função declarada
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * @return lista de argumentos formais da função declarada
	 */
	public List<ArgumentoFormal> getArgumentos() {
		return argumentos;
	}
	
	/**
	 * @return expressão corpo da função declarada
	 */
	public Expressao getCorpo() {
		return corpo;
	}
	
	
}