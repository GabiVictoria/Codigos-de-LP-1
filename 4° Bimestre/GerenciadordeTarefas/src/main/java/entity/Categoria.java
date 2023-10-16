package entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "Categoria")
@Table(name = "Categoria")

/*A classe Categoria é reponsável por gerar categorias para as tarefas e materias dentro do sistema gerenciador de tarefas*/
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nome;
    @Column
    private String descricao;


}
