package br.graecus.neptunum.Sessao;

import br.graecus.neptunum.modelos.*;
import br.graecus.neptunum.util.HibernateUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioSessao {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Usuario> listaUsuarios(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Usuario> query = session.createQuery("from Usuario ", Usuario.class);
        return query.getResultList();
    }

    public void salvarUsuario(Usuario usuario){
        Transaction transaction = session.beginTransaction();
        session.persist(usuario);
        transaction.commit();
    }
}
