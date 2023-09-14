import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Evento {
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFinal;
    private String horaInicio;
    private String horaFinal;
    private   int idEvento;
    private Date data;


    static Scanner ler = new Scanner(System.in);

    public Evento(String nome, String dataInicio, String dataFinal, String horaInicio, String horaFinal) throws ParseException {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        idEvento = Agenda.gerarId();
        mudaData();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(String dataInicio) throws ParseException {
        this.dataInicio = dataInicio;
        mudaData();
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void EdtEvento (int id){
        for (Evento p:Agenda.eventos) {
            if(p.idEvento==(id)){
                System.out.println("deseja mudar o nome?");
                setNome();
            }

        }
    }
    public static void exibirEventos(){
        Agenda.eventos.sort(Comparator.comparing(Evento::getData));
        for (Evento p:Agenda.eventos) {
            System.out.println(p);
        }
    }
    public static void consultaEventos(String d){
        for (Evento p:Agenda.eventos) {
            if(p.dataInicio.equals(d)){
            System.out.println(p);
        }
        
        }
    }


    public void mudaData() throws ParseException {
         data = new SimpleDateFormat("dd-MM-yyyy").parse(dataInicio);
    }

    public Date getData() {
        return data;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public static void removerEvento(){
        System.out.println("Digite o id da ocorrencia");
        int i = ler.nextInt();
        Agenda.eventos.removeIf(n->(n.idEvento==i));
    }


    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFinal='" + horaFinal + '\'' +
                ", idEvento=" + idEvento +
                '}';
    }
}

