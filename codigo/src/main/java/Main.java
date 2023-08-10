import entity.Pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Emainuel", "Aguilar", "emainuel@gmail.com");
        Pessoa p2 = new Pessoa("Gabriell", "Baptista", "gabriell@gmail.com");
        Pessoa p3 = new Pessoa("Élison", "George", "amorzinho@gmail.com");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(p1);
        session.persist(p2);
        session.persist(p3);

        transaction.commit();

        List<Pessoa> pessoas = session.createQuery("from Pessoa", Pessoa.class).list();

        pessoas.forEach(p -> System.out.println(p.toString()));

        /*for (Pessoa p: pessoas){
            System.out.println(p.toString());
        }*/
    }
}
