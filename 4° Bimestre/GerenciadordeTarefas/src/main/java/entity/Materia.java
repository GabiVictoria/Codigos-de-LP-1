package entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "Materia")
@Table(name = "Materia")

public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String descricao;

    protected static List<Tarefa> tarefas= new ArrayList<>();
}
