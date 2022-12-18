import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.println("Por favor, digite o número da Conta!");
            int numero = scanner.nextInt();
            System.out.println("Por favor, digite o número da Agência!");
            String agencia = scanner.next();
            System.out.println("Por favor, digite o nome Cliente!");
            String nomeCliente = scanner.next();
            System.out.println("Por favor, digite o Saldo!");
            float saldo = scanner.nextFloat();

            System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque");
        }
    }
}
