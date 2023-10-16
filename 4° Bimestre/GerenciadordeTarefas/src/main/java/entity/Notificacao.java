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
    //indica um relacionamento "muitos para um" com a tabela Tarefa:
    @ManyToOne
    //indica que a tabela Notificacao possui uma chave estrangeira da tabela Tarefa:
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;
    @Column
    //indica um relacionamento "muitos para um" com a tabela Categoria:
    @ManyToOne
    //indica que a tabela Notificacao possui uma chave estrangeira da tabela Categoria:
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
