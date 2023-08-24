package entity;

import jakarta.persistence.*;

@Entity(name = "Produto")
@Table(name = "Produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @Column
    private int nome;
    @Column
    private int preco;

    public Produto(int nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
