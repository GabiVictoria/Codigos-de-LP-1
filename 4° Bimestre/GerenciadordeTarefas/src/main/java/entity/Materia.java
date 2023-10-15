package entity;
import jakarta.persistence.*;
public class Materia {
    @Id
    private int id;
    @Column
    private String nome;
    @Column
    private String descricao;
}
