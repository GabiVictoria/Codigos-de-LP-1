package entity;
import jakarta.persistence.*;
@Entity(name = "Tarefa")
@Table(name = "Tarefa")

public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    private String vencimmento;
    @Column
    private Materia materia;
    @Column
    private String status;
    @Column
    private Categoria categoria;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVencimmento() {
        return vencimmento;
    }

    public void setVencimmento(String vencimmento) {
        this.vencimmento = vencimmento;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
