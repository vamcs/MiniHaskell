package br.unb.cic.mh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import br.unb.cic.mh.visitor.Visitor;

/**
 * Classe que implementa a execução de uma função declarada no ambiente de execução.
 * @author rbonifacio
 *
 */
public class ExpressaoAplicacao implements Expressao {

	// ===========================================================
	// Atributos
	// ===========================================================
	
	private String nome; 
	private List<Expressao> parametros;
	
	// ===========================================================
	// Construtores
	// ===========================================================
	
	/**
	 * Construtor que executa uma função "nome" declarada.
	 * @param nome da função a se executar
	 * @param argumentos : lista com todas expressões a se executar
	 */
	public ExpressaoAplicacao(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.parametros = argumentos;
	}
	
	/**
	 * Construtor padrão. Apenas inicializa uma lista vazia de parâmetros.
	 */
	public ExpressaoAplicacao() {
		parametros = new ArrayList<Expressao>();
	}
	
	// ===========================================================
	// Métodos
	// ===========================================================
	
	/**
	 * Seta o nome da função a ser executada.
	 * @param nome
	 * @return a própria expressão aplicação
	 */
	public ExpressaoAplicacao nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	/**
	 * Adiciona uma nova expressão a ser executada.
	 * @param exp
	 * @return a própria expressão aplicação
	 */
	public ExpressaoAplicacao parametro(Expressao exp) {
		parametros.add(exp);
		return this;
	}
	
	//Ainda não implementado.
	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Ainda não implementado.
	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Faz a execução da função declarada chamada String <b>nome</b>.
	 */
	@Override
	public Valor avaliar() {
		
		//Busca se a função declarada está no ambiente de execução.
		DeclFuncao f = AmbienteExecucao.instance().obterDeclaracaoFuncao(nome);
		
		//Caso não tenha sido declara, lança exceção.
		if(f == null) {
			throw new RuntimeException("Funcao " + nome + " nao declarada");
		}
		
		//Verifica se o número de parâmetros passado à função é o mesmo que ela pede.
		if (parametros.size() < f.getArgumentos().size()) {
			throw new RuntimeException("Número de parâmetros insuficientes.");
		}
		else if(parametros.size() > f.getArgumentos().size()) {
			throw new RuntimeException("Muitos parâmetros na chamada da função.");
		}
			
		//Faz as associacoes entre argumentos formais 
		//e parametros da chamada da funcao. 
		definirAmbiente(f);
		
		Valor resultado = f.getCorpo().avaliar();
		
		AmbienteExecucao.instance().removerEscopo();
		
		return resultado;
	}
	
	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	/**
	 * Associar no contexto de execução os argumentos 
	 * formais da funcao "f" aos parâmetros 
	 * passados na aplicação de função.
	 * <br><br>
	 * <b>EDIT</b>: Um escopo só pode conter valores concretos,
	 * portanto só é possível definir o ambiente após avaliar todos os parâmetros
	 * passados à função. Dessa forma, um novo escopo vazio é definido e as consequentes associações
	 * só são feitas após essas avaliações.
	 * 
	 * @author rbonifacio
	 * 
	 */
	private void definirAmbiente(DeclFuncao f) {
		List<ArgumentoFormal> argumentosFormais = f.getArgumentos();
		List<Expressao> exp = new ArrayList<Expressao>();
		
		//Executa os parâmetros recebidos pela função e os salva em exp.
		for(int i = 0; i < argumentosFormais.size(); i++) {
			exp.add(parametros.get(i).avaliar());
		}
		
		//Inicializa um novo escopo vazio.
		//Um novo escopo só é inicializado após avaliar todas expressões recebidas
		//como parâmetro. Caso contrário, Expressões RefId perderiam o valor corrente do escopo
		//antes de serem avaliadas. 
		//Lembrete: deve-se sempre guardar valores inteiros ou booleano no escopo.
		AmbienteExecucao.instance().definirEscopo();
		
		//Associa os argumentos às expressões (Valores Concretos) no novo escopo vazio.
		for(int i = 0; i < argumentosFormais.size(); i++) {
			AmbienteExecucao.instance().associarExpressao(argumentosFormais.get(i).getId(), exp.get(i));
		}	
	}
}
