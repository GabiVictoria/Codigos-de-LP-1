import java.text.ParseException;
import java.util.Scanner;
public class Main {
    static Scanner ler = new Scanner(System.in);
    public static void main(String[] args ) throws ParseException {
        int e =0;
        int op = 0;
        int c=0;
        String d;

        do {
           op = Agenda.exibirMenu(op);
            switch (op) {
                    case 1:
                        System.out.println("Digite quantos eventos quer criar ");
                        e = ler.nextInt();
                        System.out.println("voce escolheu: " + e);
                        Agenda.criarEvento(e);
                        e=0;
                        break;
                    case 2:
                        System.out.println("Digite quantas tarefas quer criar ");
                        e = ler.nextInt();
                        System.out.println("voce escolheu: " + e);
                        Agenda.criarTarefa(e);

                        break;
                    case 3:
                        System.out.println("Digite quantos lembretes quer criar ");
                        e = ler.nextInt();
                        System.out.println("voce escolheu: " + e);
                        Agenda.criarLembrte(e);

                        break;
                    case 4:
                        Evento.removerEvento();
                        System.out.println("Removido");
                        break;
                    case 5:
                        Tarefa.removerTarefa();
                        System.out.println("Removido");
                        break;
                    case 6:
                        Lembrete.removerLembrete();
                        System.out.println("Removido");
                        break;
                    case 7:
                        Evento.exibirEventos();
                        break;
                    case 8:
                        Tarefa.exibirTarefas();
                        break;
                    case 9:
                        Lembrete.exibirLembretes();
                        break;
                    case 10:
                        System.out.println("digite a data no formato'DD-MM-AAAA'");
                        d = ler.next();
                        Evento.consultaEventos(d);
                        Tarefa.consultaTarefas(d);
                        Lembrete.consultaLembretes(d);
                        break;

            }
            System.out.println("Voltar ao menu (0)");
            System.out.println("encerrar agenda (1)");
            c = ler.nextInt();
        
} while (c!=1);


    }

}
