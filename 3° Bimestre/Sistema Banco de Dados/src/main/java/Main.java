import entity.Endereco;
import entity.Pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            Pessoa p1 = new Pessoa("Emainuel", "Aguilar", "emainuel@gmail.com", new Endereco("Limoeiro", "Sampa"));
            Pessoa p2 = new Pessoa("Gabriell", "Baptista", "gabriell@gmail.com", new Endereco("Beija Flor", "Gothan City"));
            Pessoa p3 = new Pessoa("Élison", "George", "amorzinho@gmail.com", new Endereco("Guianazes", "Porto Belo"));

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

           /* Endereco e1 = new Endereco("Limoeiro", "Sampa");
            Endereco e2 = new Endereco("Beija flor", "Gotham City");

            transaction = session.beginTransaction();
            session.persist(e1);
            session.persist(e2);
            transaction.commit();

            List<Endereco> enderecos = session.createQuery("from Endereco",Endereco.class).list();
            enderecos.forEach(p -> System.out.println(p.toString()));*/
    }
}
