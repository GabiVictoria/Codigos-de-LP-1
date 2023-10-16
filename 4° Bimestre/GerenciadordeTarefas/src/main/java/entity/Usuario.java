package entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "Usuario")
@Table(name = "Usuario")

//A classe Usuário gera objetos que contém as informações referentes aos usuários do sistema gerenciador de tarefas
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
    //indica um relacionamento "um para muitos" com a tabela Usuario:
    @OneToMany
    @JoinColumn(name = "tarefa_id")
    protected static List<Tarefa> tarefas= new ArrayList<>();
    //indica um relacionamento "um para muitos" com a tabela Usuario:
    @OneToMany
    @JoinColumn(name = "materia_id")
    protected static List<Materia> materias= new ArrayList<>();
    //indica um relacionamento "um para muitos" com a tabela Usuario:
    @OneToMany
    @JoinColumn(name = "categoria_id")
    protected static List<Categoria> categorias= new ArrayList<>();
    //indica um relacionamento "um para muitos" com a tabela Usuario:
    @OneToMany
    @JoinColumn(name = "notificacao_id")
    protected static List<Notificacao> notificacoes= new ArrayList<>();


    //Imprime a lista das tarefas pendentes
    public void  tarefaPendente(){
        for (Tarefa p:Usuario.tarefas) {
            if(p.getStatus().equals("Pendente")){
                System.out.println(p);
            }

        }
    }
    //Imprime a lista das tarefas concluidas 
    public void  tarefaConcluida(){
        for (Tarefa p:Usuario.tarefas) {
            if(p.getStatus().equals("Concluida")){
                System.out.println(p);
            }

        }
    }
}
