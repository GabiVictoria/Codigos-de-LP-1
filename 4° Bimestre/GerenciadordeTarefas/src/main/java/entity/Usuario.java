package entity;
import jakarta.persistence.*;

public class Usuario {
    @Id
    private int id;
    @Column
    private String nome;
    @Column
    private String senha;
}
