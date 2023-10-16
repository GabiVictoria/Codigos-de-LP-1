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
    //indica um relacionamento "um para muitos" com a classe Usuario:
    @OneToMany
    //indica que a classe vai ter uma chave estrangeira da classe Usuario:
    @JoinColumn(name="usuario_id")
    protected static List<Tarefa> tarefas= new ArrayList<>();
    //indica um relacionamento "um para muitos" com a classe Usuario:
    @OneToMany
    //indica que a classe Materia possui uma chave estrangeira da classe Usuario:
    @JoinColumn(name="usuario_id")
    protected static List<Materia> materias= new ArrayList<>();
    //indica um relacionamento "um para muitos" com a classe Usuario:
    @OneToMany
    //indica que a classe Categoria possui uma chave estrangeira da classe Usuario:
    @JoinColumn(name="usuario_id")
    protected static List<Categoria> categorias= new ArrayList<>();
    //indica um relacionamento "um para muitos" com a classe Usuario:
    @OneToMany
    //indica que a classe Notificacao possui uma chave estrangeira da classe Usuario:
    @JoinColumn(name="usuario_id")
    protected static List<Notificacao> notificacoes= new ArrayList<>();


    
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
