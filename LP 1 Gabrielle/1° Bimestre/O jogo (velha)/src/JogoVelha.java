import java.util.Scanner;

public class JogoVelha {
    private static char[][] tabuleiro = new char[3][3]; // matriz para armazenar o tabuleiro
    private static char jogadorAtual = 'X'; // jogador que começa o jogo
    private static boolean jogoAcabou = false; // flag que indica se o jogo acabou
    private static char Vencedor = 'X'; //jogador que venceu
    static int empate = 0;

    public static void main(String[] args) {
        inicializarTabuleiro(); // preenche o tabuleiro com espaços em branco
        exibirTabuleiro(); // mostra o tabuleiro vazio

        while (!jogoAcabou) {
            jogar(); // pede ao jogador atual para fazer uma jogada
            exibirTabuleiro(); // mostra o tabuleiro atualizado
            verificarFimDeJogo(); // verifica se o jogo acabou
            if(jogoAcabou){
                break;
            }
            verificaEmpate();
            if(jogoAcabou){
                break;
            }
            trocarJogador(); // passa a vez para o próximo jogador
        }
        exibirResultado(); // exibe o simbolo do jogador
    }

    private static void inicializarTabuleiro() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ' '; // preenche cada posição com um espaço em branco
            }
        }
    }

    private static void exibirTabuleiro() {
        System.out.println("  1 2 3"); // números das colunas
        System.out.println(" -------");

        for (int linha = 0; linha < 3; linha++) {
            System.out.print(linha + 1 + "|"); // número da linha
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + "|"); // exibe o conteúdo da posição
            }
            System.out.println();
            System.out.println(" -------");
        }
    }

    private static void jogar() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        do {
            System.out.print("Jogador " + jogadorAtual + ", informe a linha (1-3): ");
            linha = scanner.nextInt() - 1; // converte para índice da matriz (0-2)

            System.out.print("Jogador " + jogadorAtual + ", informe a coluna (1-3): ");
            coluna = scanner.nextInt() - 1; // converte para índice da matriz (0-2)

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Posição inválida! Tente novamente.");
            } else if (tabuleiro[linha][coluna] != ' ') {
                System.out.println("Essa posição já está ocupada! Tente novamente.");
            } else {
                tabuleiro[linha][coluna] = jogadorAtual; // atualiza o tabuleiro com a jogada
                break; // sai do loop
            }
        } while (true);
    }

    private static boolean verificarFimDeJogo() {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != ' ' && tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                jogoAcabou = true;

            }
        }
        // Verifica colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] != ' ' && tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j]) {
                jogoAcabou = true;

            }
        }
        // Verifica diagonal principal
        if (tabuleiro[0][0] != ' ' && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            jogoAcabou = true;

        }
        // Verifica diagonal contraria
        if (tabuleiro[0][2] != ' ' && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            jogoAcabou = true;

        }

        return true;
    }

    private static void trocarJogador(){
        int atual = 1;
        int troca = 0;
        do {
            Scanner ler = new Scanner(System.in);
            System.out.println("Porfavor insira o numero do jogador que ira jogar agora. | 1 = X| e | 2 = O");
            atual = ler.nextInt();
            if (atual == 1) {
                jogadorAtual = 'X';
                troca = 0;
            } else if (atual == 2) {
                jogadorAtual = 'O';
                troca = 0;
            } else {
                System.out.println("Jogador invalido");
                troca = 1;
            }
        } while (troca != 0);
    }

    private static void exibirResultado(){
        Vencedor=jogadorAtual;
        if (empate == 0) {
            System.out.printf("Parabens jogador |" + Vencedor);
            System.out.println(" voce ganhou");
        }
        else {
            System.out.println("| Deu velha !!!!");
        }
    }

    private static void verificaEmpate () {
        if (tabuleiro[0][0] !=' '&&
                tabuleiro[0][1] !=' '&&
                tabuleiro[0][2] !=' '&&
                tabuleiro[1][0] !=' '&&
                tabuleiro[1][1] !=' '&&
                tabuleiro[1][2] !=' '&&
                tabuleiro[2][0] !=' '&&
                tabuleiro[2][1] !=' '&&
                tabuleiro[2][2]  !=' ') {
            empate = 1;
            jogoAcabou = true;
        }
    }
}