package entity;
import jakarta.persistence.*;
@Entity(name = "Materia")
@Table(name = "Materia")
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
