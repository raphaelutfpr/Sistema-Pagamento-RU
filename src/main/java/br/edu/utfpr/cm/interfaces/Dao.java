package br.edu.utfpr.cm.interfaces;

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
	 * Insere ou atualiza um objeto.
	 *
	 * @param objeto
	 *            - objeto a ser inserio ou atualizado.
	 */
	public void save(T objeto);

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
	public T getById(I id);

	/**
	 * Obt�m uma lista de objetos do tipo <T>T<T>.
	 *
	 * @return Uma lista de objetos.
	 */
	public List<T> getAll();
}