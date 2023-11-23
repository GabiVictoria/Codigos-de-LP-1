package br.graecus.neptunum.Sessao;

import br.graecus.neptunum.modelos.*;
import br.graecus.neptunum.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TarefaSessao {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void salvarTarefa(Tarefa tarefa){
        Transaction transaction = session.beginTransaction();
        session.persist(tarefa);
        transaction.commit();
    }

    public List<Tarefa> listaTarefas(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Tarefa> query = session.createQuery("from Tarefa ", Tarefa.class);
        return query.getResultList();
    }

    public Tarefa buscarTarefa(Integer id) {
        return session.get(Tarefa.class, id);
    }

    public void deletarTarefa(Integer id) {
        Tarefa tarefa = session.get(Tarefa.class, id);
        if (tarefa != null) {
            session.beginTransaction();
            session.remove(tarefa);
            session.getTransaction().commit();
        }
    }
}
