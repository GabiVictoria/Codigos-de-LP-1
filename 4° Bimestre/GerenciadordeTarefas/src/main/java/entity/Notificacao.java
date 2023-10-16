package entity;
import jakarta.persistence.*;
/*A classe Notificacao é responsável por gerar os objetos referentes as notificações que o usuário pode receber sobre as tarefas que 
deve cumprir no determinado dia e horário*/
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String data;
    @Column
    private String mensagem;
    @Column
    //indica um relacionamento "muitos para um" com a classe Tarefa:
    @ManyToOne
    private Tarefa tarefa;
    @Column
    //indica um relacionamento "muitos para um" com a classe Categoria:
    @ManyToOne
    private Categoria categoria;
}
