package entity;

import jakarta.persistence.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pedidos")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name= "produto_id"))


    private List<Produto> produtos;

    public Pedido(Pessoa pessoa, List<Produto> produtos) {
        this.pessoa = pessoa;
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", produtos=" + produtos +
                '}';
    }
}
