package entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "Materia")
@Table(name = "Materia")

//A classe Materia é responsável por gerar os objetos correspondentes as matérias do sistema gerenciador de tarefas
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String descricao;
    
}
