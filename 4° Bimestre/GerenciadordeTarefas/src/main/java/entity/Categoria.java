package entity;
import jakarta.persistence.*;
public class Categoria {
    @Id
    private int id;
    @Column
    private String nome;
    @Column
    private String descricao;
}
