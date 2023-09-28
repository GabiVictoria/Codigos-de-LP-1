import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    protected static List <Tarefa> tarefas = new ArrayList<>();
    protected static List <Evento> eventos= new ArrayList<>();
    protected static List <Lembrete> lembretes = new ArrayList<>();


    static Scanner ler = new Scanner(System.in);
    private static int idOcorrencia;

    public static void criarEvento(int e) throws ParseException {
        for (int i = 0;i<e; i++){
            System.out.println("Digite o nome, a data inicial, a data final, a hora inicial e a hora final");
            System.out.println("digite a data no formato'DD-MM-AAAA'");
            Agenda.eventos.add(new Evento(ler.next(),ler.next(), ler.next(), ler.next(),ler.next()));
            System.out.println("criado!");
        }
        for (Evento p:Agenda.eventos) {
            System.out.println(p);
        }
    }

    public static void criarTarefa(int t) throws ParseException {
        for (int i = 0;i<t; i++){
            System.out.println("Digite o nome, a data inicial");
            System.out.println("digite a data no formato'DD-MM-AAAA'");
            tarefas.add(new Tarefa(ler.next(), ler.next()));
            System.out.println("criado!");
        }
        for (Tarefa p:tarefas) {
            System.out.println(p);
        }
    }

    public static void criarLembrte(int l) throws ParseException {
        for (int i = 0;i<l; i++){
            System.out.println("Digite o nome, a data inicial, a hora inicial");
            System.out.println("digite a data no formato'DD-MM-AAAA'");
            lembretes.add(new Lembrete(ler.next(), ler.next(), ler.next()));
            System.out.println("criado!");
        }
        for (Lembrete p:lembretes) {
            System.out.println(p);
        }
    }

    public static int gerarId(){
        idOcorrencia+=1;
        return idOcorrencia;
    }

    public static int exibirMenu(int op){
        System.out.println(" Exibindo menu ");
        System.out.println(" Criar evento (1)");
        System.out.println(" Criar tarefa (2)");
        System.out.println(" Criar lembrete (3)");
        System.out.println(" Remover evento (4)");
        System.out.println(" Remover tarefa (5)");
        System.out.println(" Remover lembrete (6)");
        System.out.println(" Exibir evento (7)");
        System.out.println(" Exibir tarefa (8)");
        System.out.println(" Exibir lembrete (9)");
        System.out.println(" Consultar por dia (10)");
        System.out.println(" Editar evento (11)");
        System.out.println(" Editar tarefa (12)");
        System.out.println(" Editar lembrete (13)");
        System.out.println(" Digite a sua opcao!");
        op= ler.nextInt();
        return op;
    }


}