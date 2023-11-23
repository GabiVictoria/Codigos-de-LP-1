package br.graecus.neptunum.modelos;
import jakarta.persistence.*;

@Table
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;


    public Categoria(String nome) {
        this.nome = nome;

    }
    public Categoria(){}


    @Override
    public String toString() {
        return "Cateogoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
