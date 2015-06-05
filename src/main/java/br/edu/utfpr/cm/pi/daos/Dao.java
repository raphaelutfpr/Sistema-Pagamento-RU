package br.edu.utfpr.cm.pi.daos;

import java.util.List;

/**
 * Interface gen�rica destinada � persist�ncia de objetos.
 * 
 * @param <T>
 *            - Par�metro gen�rico que identifica o tipo do objeto.
 * @param <I>
 *            - Par�metro gen�rico que identifica o tipo do identificador do
 *            objeto. Exemplos: {@code Long}, {@code Integer}, etc.
 */
public interface Dao<T, I> {

	/**
	 * Salva um objeto.
	 *
	 * @param objeto
	 *            - objeto a ser salvo.
	 */
	public void save(T objeto);

	/**
	 * Atualiza um objeto.
	 * 
	 * @param objeto
	 *            - objeto a ser atualizado.
	 */
	public void update(T objeto);

	/**
	 * Exclui um objeto.
	 * 
	 * @param objeto
	 *            - objeto que ser� exclu�do.
	 */
	public void delete(T objeto);

	/**
	 * Obt�m um objeto da base de dados com base no id.
	 *
	 * @param id
	 *            - Identificador do objeto a ser pesquisado.
	 * @return <T>T<T> - Objeto encontrado.
	 */
	public T findById(I id);

	/**
	 * Obt�m a lista de objetos do tipo <T>T<T>.
	 *
	 * @return Uma lista de objetos.
	 */
	
	 public List<T> getAll();
}