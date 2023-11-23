package br.graecus.neptunum.modelos;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nickName;

    @Column(unique = true)
    private String nomeUsuario;


    @Column
    private String senha;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();

    public Usuario(String nickName, String nomeUsuario, String senha) {
        this.nickName = nickName;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public  Usuario(){

    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nickName + '\'' +
                ", senha='" + senha + '\'' +
                ", tarefas=" + tarefas +
                '}';
    }

    public void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}
