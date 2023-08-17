package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Pedidos");

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany 
}
