/*2. Classe: ContaPoupaca (herda Bancaria)  
Variáveis de instância: 
    - diaRendimento (int) 
métodos: 
    - gets e sets 
    - calcularNovoSaldo (recebe a taxa de rendimento e atualiza     - saldo)  */

public class Contas extends Bancaria {
    private int diaRendimento;

    //CONSTRUTOR Q RECEBE O diaRendimento E CHAMA O COONSTRUTOR DA SUPERCLASSE
    public Contas(String cliente, int numConta, double saldoConta, int diaRendimento) {
        super(cliente, numConta, saldoConta); //CHAMA CONSTRUTOR DA SUPERCLASSE
        this.diaRendimento = diaRendimento; //DEFINE DIA DE RENDIMENTO
    }

    //GETTERS E SETTERS
    public int getDiaRendimento() {
        return diaRendimento;
    }
    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }

    //METODO P/ VER O NOVO SALDO CM BASE EM TAXAS DE RENDIMENTO
    public void calcularNovoSaldo(double taxaRendimento){
        if (taxaRendimento > 0) {
            //ATUALIZAR SALDO CM BASE NA TAXA DE RENDIMENTO
            double novoSaldo = getSaldoConta() + (getSaldoConta() * taxaRendimento / 100);
            setSaldoConta(novoSaldo); //ATUALIZAR SALDO NA SUPER-CLASSE
            System.out.println("Novo saldo após rendimento: " + novoSaldo);
        }else {
            System.out.println("Taxa de rendimento inválida.");
        }
    }
}
