package br.edu.utfpr.cm.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Classe utilit�ria para gerenciamento de transa��es do Hibernate, tem como objetivos:
 * <ul>
 * <li>Obter uma session;</li>
 * <li>Iniciar uma transa��o;</li>
 * <li>Fechar uma session;</li>
 * </ul>
 *
 * @author S�rgio Ramos da Silva
 */
public abstract class TransactionManager {

    private static Transaction transacao;
    private static Session sessao;

    /**
     * Obt�m uma session
         *
         * @return session
     */
    public static Session getSession() {

        sessao = HibernateUtil.openSession();
        return sessao;
    }

    /**
     * Inicia uma transa��o
         *
         * @return transaction
     */
    public static Transaction beginTransaction(Session session) {

        transacao = sessao.beginTransaction();
        return transacao;
    }

    /**
     * Fecha uma session
         *
     */
    public static void closeSession() {

        HibernateUtil.closeSession();
    }

}