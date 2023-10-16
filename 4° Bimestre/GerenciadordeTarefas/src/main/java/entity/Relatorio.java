package entity;
import jakarta.persistence.*;
@Entity(name = "Materia")
@Table(name = "Materia")
    
//A classe Relatorio relata o progresso das tarefas
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String data;
}
