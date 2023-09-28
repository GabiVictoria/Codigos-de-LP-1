import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Tarefa {
    static Scanner ler = new Scanner(System.in);
    private String nome;
    private String dataInicio;
    private String descricao;
    private int idTarefa;
    private Date data;

    public Tarefa(String nome, String dataInicio) throws ParseException {
        this.nome = nome;
        this.dataInicio = dataInicio;
        idTarefa = Agenda.gerarId();
        mudaData();
    }
    public static void exibirTarefas(){
        Agenda.tarefas.sort(Comparator.comparing(Tarefa::getData));
        for (Tarefa p:Agenda.tarefas) {
            System.out.println(p);
        }
    }
    public void mudaData() throws ParseException {
        data = new SimpleDateFormat("dd-MM-yyyy").parse(dataInicio);
    }

    public Date getData() {
        return data;
    }
    public static void EdtTarefa (int id) throws ParseException {
        for (Tarefa p:Agenda.tarefas) {
            if(p.idTarefa==(id)){
                System.out.println("Deseja mudar o nome? Se nao tecle enter");
                String a = ler.next();
                if(a!=""){
                    p.setNome(a);
                }
                System.out.println("Deseja mudar a descricao? Se nao tecle enter");
                a = ler.next();
                if(a!=""){
                    p.setDescricao(a);
                }
                System.out.println("Deseja mudar a data incial? Se nao tecle enter");
                a = ler.next();
                if(a!=""){
                    p.setDataInicio(a);
                }
            }

        }
    }

    public static void removerTarefa(){
        System.out.println("Digite o id da ocorrencia");
        int i = ler.nextInt();
        Agenda.tarefas.removeIf(n->(n.idTarefa==i));
    }

    public static void consultaTarefas(String d){
        for (Tarefa p:Agenda.tarefas) {
            if(p.dataInicio.equals(d)){
                System.out.println(p);
            }

        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "nome='" + nome + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", descricao='" + descricao + '\'' +
                ", idTarefa=" + idTarefa +
                '}';
    }
}