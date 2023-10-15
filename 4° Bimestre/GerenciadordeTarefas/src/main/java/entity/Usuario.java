package entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "Usuario")
@Table(name = "Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String login;
    @Column
    private String senha;
    protected static List<Tarefa> tarefas= new ArrayList<>();

    public void  tarefaPendente(){
        for (Tarefa p:Usuario.tarefas) {
            if(p.getStatus().equals("Pendente")){
                System.out.println(p);
            }

        }
    }
    public void  tarefaConcluida(){
        for (Tarefa p:Usuario.tarefas) {
            if(p.getStatus().equals("Concluida")){
                System.out.println(p);
            }

        }
    }
}
