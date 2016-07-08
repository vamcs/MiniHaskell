package br.unb.cic.mh.expressao;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.mh.AmbienteExecucao;
import br.unb.cic.mh.ArgumentoFormal;
import br.unb.cic.mh.DeclFuncao;
import br.unb.cic.mh.Tipo;
import br.unb.cic.mh.valor.Valor;
import br.unb.cic.mh.visitor.Visitor;

/**
 * Classe que implementa a execu��o de uma fun��o declarada no ambiente de execu��o.
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
	 * Construtor que executa uma fun��o "nome" declarada.
	 * @param nome da fun��o a se executar
	 * @param argumentos : lista com todas express�es a se executar
	 */
	public ExpressaoAplicacao(String nome, List<Expressao> argumentos) {
		this.nome = nome;
		this.parametros = argumentos;
	}
	/**
	 * Construtor padr�o. Apenas inicializa uma lista vazia de par�metros.
	 */
	public String getnome(){
		return nome;
	}
	
	public List<Expressao> getparametros(){
		return parametros;
	}
	public ExpressaoAplicacao() {
		parametros = new ArrayList<Expressao>();
	}
	
	// ===========================================================
	// M�todos
	// ===========================================================
	
	/**
	 * Seta o nome da fun��o a ser executada.
	 * @param nome
	 * @return a pr�pria express�o aplica��o
	 */
	public ExpressaoAplicacao nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	/**
	 * Adiciona uma nova express�o a ser executada.
	 * @param exp
	 * @return a pr�pria express�o aplica��o
	 */
	public ExpressaoAplicacao parametro(Expressao exp) {
		parametros.add(exp);
		return this;
	}
	
	//Ainda n�o implementado.
	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Ainda n�o implementado.
	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Faz a execu��o da fun��o declarada chamada String <b>nome</b>.
	 */
	@Override
	public Valor avaliar() {
		
		//Busca se a fun��o declarada est� no ambiente de execu��o.
		DeclFuncao f = AmbienteExecucao.instance().obterDeclaracaoFuncao(nome);
		
		//Caso n�o tenha sido declara, lan�a exce��o.
		if(f == null) {
			throw new RuntimeException("Funcao " + nome + " nao declarada");
		}
		
		//Verifica se o n�mero de par�metros passado � fun��o � o mesmo que ela pede.
		if (parametros.size() < f.getArgumentos().size()) {
			throw new RuntimeException("N�mero de par�metros insuficientes.");
		}
		else if(parametros.size() > f.getArgumentos().size()) {
			throw new RuntimeException("Muitos par�metros na chamada da fun��o.");
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
	 * Associar no contexto de execu��o os argumentos 
	 * formais da funcao "f" aos par�metros 
	 * passados na aplica��o de fun��o.
	 * <br><br>
	 * <b>EDIT</b>: Um escopo s� pode conter valores concretos,
	 * portanto s� � poss�vel definir o ambiente ap�s avaliar todos os par�metros
	 * passados � fun��o. Dessa forma, um novo escopo vazio � definido e as consequentes associa��es
	 * s� s�o feitas ap�s essas avalia��es.
	 * 
	 * @author rbonifacio
	 * 
	 */
	private void definirAmbiente(DeclFuncao f) {
		List<ArgumentoFormal> argumentosFormais = f.getArgumentos();
		List<Expressao> exp = new ArrayList<Expressao>();
		
		//Executa os par�metros recebidos pela fun��o e os salva em exp.
		for(int i = 0; i < argumentosFormais.size(); i++) {
			exp.add(parametros.get(i).avaliar());
		}
		
		//Inicializa um novo escopo vazio.
		//Um novo escopo s� � inicializado ap�s avaliar todas express�es recebidas
		//como par�metro. Caso contr�rio, Express�es RefId perderiam o valor corrente do escopo
		//antes de serem avaliadas. 
		//Lembrete: deve-se sempre guardar valores inteiros ou booleano no escopo.
		AmbienteExecucao.instance().definirEscopo();
		
		//Associa os argumentos �s express�es (Valores Concretos) no novo escopo vazio.
		for(int i = 0; i < argumentosFormais.size(); i++) {
			AmbienteExecucao.instance().associarExpressao(argumentosFormais.get(i).getId(), exp.get(i));
		}	
	}
}
