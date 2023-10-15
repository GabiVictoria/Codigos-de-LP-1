package entity;
import jakarta.persistence.*;
public class Notificacao {
    @Id
    private int id;
    @Column
    private String data;
    @Column
    private String mensagem;
    @Column
    private Tarefa tarefa;
}
