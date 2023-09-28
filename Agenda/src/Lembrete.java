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
    private String descricao;
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

    public static void EdtLembrete (int id) throws ParseException {
        for (Lembrete p:Agenda.lembretes) {
            if(p.idLembrete==(id)){
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
                System.out.println("Deseja mudar a hora incial? Se nao tecle enter");
                a = ler.next();
                if(a!=""){
                    p.setHoraInicio(a);
                }
                System.out.println("Deseja mudar a data incial? Se nao tecle enter");
                a = ler.next();
                if(a!=""){
                    p.setDataInicio(a);
                }

            }
        }
    }


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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Lembrete{" +
                "nome='" + nome + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", desccricao='" + descricao + '\'' +
                ", idLembrete=" + idLembrete +
                '}';
    }
}