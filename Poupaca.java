/*4. Classe: Contas 
Criar um método main com menu que contenha os seguintes itens: 
    - Incluir dados relativos ás contas dos clientes 
    - Sacar determinado valor da(s) sua(s) conta(s) 
    - Depositar determinado valor da(s) sua(s) conta(s) 
    - Mostrar novo saldo do cliente, a partir da taxa de rendimento, 
    daqueles que possuem conta poupança 
    - Mostrar os dados da conta de um cliente  */

    import java.util.ArrayList;
    import java.util.Scanner;
    
    class Conta {
        private String cliente;
        private int numConta;
        private double saldo;
    
        public Conta(String cliente, int numConta, double saldo) {
            this.cliente = cliente;
            this.numConta = numConta;
            this.saldo = saldo;
        }
    
        public int getNumConta() { return numConta; }
        public double getSaldo() { return saldo; }
        
        public void depositar(double valor) { saldo += valor; }
        public boolean sacar(double valor) {
            if (saldo >= valor) {
                saldo -= valor;
                return true;
            }
            return false;
        }
    
        @Override
        public String toString() {
            return "Cliente: " + cliente + ", Conta: " + numConta + ", Saldo: " + saldo;
        }
    }
    
    public class Poupaca {
        private static ArrayList<Conta> contas = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);
    
        public static void main(String[] args) {
            int opcao;
            do {
                System.out.println("\nMenu: 1. Incluir 2. Sacar 3. Depositar 4. Mostrar 0. Sair");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha
                switch (opcao) {
                    case 1: incluirConta(); break;
                    case 2: realizarOperacao("sacar"); break;
                    case 3: realizarOperacao("depositar"); break;
                    case 4: mostrarDadosConta(); break;
                    case 0: System.out.println("Saindo..."); break;
                    default: System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        }
    
        private static void incluirConta() {
            System.out.print("Nome do cliente: ");
            String cliente = scanner.nextLine();
            System.out.print("Número da conta: ");
            int numConta = scanner.nextInt();
            System.out.print("Saldo inicial: ");
            double saldo = scanner.nextDouble();
            contas.add(new Conta(cliente, numConta, saldo));
            System.out.println("Conta incluída com sucesso!");
        }
    
        private static void realizarOperacao(String tipo) {
            System.out.print("Número da conta: ");
            int numConta = scanner.nextInt();
            System.out.print("Valor: ");
            double valor = scanner.nextDouble();
    
            for (Conta conta : contas) {
                if (conta.getNumConta() == numConta) {
                    if (tipo.equals("sacar") && conta.sacar(valor)) {
                        System.out.println("Saque realizado! Novo saldo: " + conta.getSaldo());
                    } else if (tipo.equals("depositar")) {
                        conta.depositar(valor);
                        System.out.println("Depósito realizado! Novo saldo: " + conta.getSaldo());
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    return;
                }
            }
            System.out.println("Conta não encontrada!");
        }
    
        private static void mostrarDadosConta() {
            System.out.print("Número da conta: ");
            int numConta = scanner.nextInt();
            for (Conta conta : contas) {
                if (conta.getNumConta() == numConta) {
                    System.out.println(conta);
                    return;
                }
            }
            System.out.println("Conta não encontrada!");
        }
    }
    