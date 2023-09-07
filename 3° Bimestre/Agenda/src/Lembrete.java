import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Lembrete {
    static Scanner ler = new Scanner(System.in);

    private String nome;
    private String dataInicio;
    private String horaInicio;
    private String desccricao;
    private int idLembrete;
    private Date data;

    public Lembrete(String nome, String dataInicio, String horaInicio) throws ParseException {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.horaInicio = horaInicio;
        idLembrete = Agenda.gerarId();
        mudaData();
    }

    public static void exibirLembretes(){
        Agenda.lembretes.sort(Comparator.comparing(Lembrete::getData));
        for (Lembrete p:Agenda.lembretes) {
            System.out.println(p);
        }
    }
    public void mudaData() throws ParseException {
        data = new SimpleDateFormat("dd-MM-yyyy").parse(dataInicio);
    }

    public Date getData() {
        return data;
    }
    public void ExibirData() throws ParseException {}
    public void EdtLembrete(){}
    public void ExcLembrete(){}

    public static void removerLembrete(){
        System.out.println("Digite o id da ocorrencia");
        int i = ler.nextInt();
        Agenda.lembretes.removeIf(n->(n.idLembrete==i));
    }

    public static void consultaLembretes(String d){
        for (Lembrete p:Agenda.lembretes) {
            if(p.dataInicio.equals(d)){
            System.out.println(p);
        }
        
        }
    }

    @Override
    public String toString() {
        return "Lembrete{" +
                "nome='" + nome + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", desccricao='" + desccricao + '\'' +
                ", idLembrete=" + idLembrete +
                '}';
    }
}
