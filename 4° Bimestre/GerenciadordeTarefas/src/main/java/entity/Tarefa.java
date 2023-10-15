package entity;
import jakarta.persistence.*;
public class Tarefa {
    @Id
    private int id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    private String vencimmento;
    @Column
    private Materia materia;
    @Column
    private String status;
}
