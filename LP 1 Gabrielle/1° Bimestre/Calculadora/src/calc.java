import java.util.Scanner;
public class calc {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int num1, num2;
        int total;
        char simbolo = 1;
        while (simbolo != '0') {
            System.out.println();
            System.out.println("Digite o primeiro numero");
            num1 = ler.nextInt();

            System.out.println("Digite o simbolo da operacao");
            simbolo = ler.next().charAt(0);
            if (simbolo == '0')
                break;
            System.out.println("Digite o segundo numero da operacao ");
            num2 = ler.nextInt();
            switch (simbolo) {
                case '+':
                    total = num1 + num2;
                    System.out.println(num1 + "+" + num2 + "=" + total);
                    break;
                case '-':
                    total = num1 - num2;
                    System.out.println(num1 + "-" + num2 + "=" + total);
                    break;
                case '*':
                    total = num1 * num2;
                    System.out.println(num1 + "*" + num2 + "=" + total);
                    break;
                case '/':
                    total = num1 / num2;
                    System.out.println(num1 + "/" + num2 + "=" + total);
                    break;
            }
        }
    }
}
