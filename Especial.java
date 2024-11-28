/* 3. Classe: ContaEspecial (herda Bancaria) 
Variáveis de instância: 
    - limiteCredito (float) 
Métodos: 
    - gets e sets 
    - sacarValor (permitir saldo negativo até o valor do limite de crédito)  
*/
public class Especial extends Bancaria {
    private double limiteCredito;

    // GETTERS E SETTERS
    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    // CONSTRUTOR QUE RECEBE O diaRendimento E CHAMA O CONSTRUTOR DA SUPERCLASSE
    public Especial(String cliente, int numConta, double saldoConta, int diaRendimento) {
        super(cliente, numConta, saldoConta); // CHAMA CONSTRUTOR DA SUPERCLASSE
        this.limiteCredito = diaRendimento; // DEFINE DIA DE RENDIMENTO
    }

    // MÉTODO PARA SACAR VALOR
    public boolean sacarValor(double valor) {
        if (getSaldoConta() + limiteCredito >= valor) { // PERMITIR SALDO NEGATIVO ATÉ O LIMITE DE CRÉDITO
            setSaldoConta(getSaldoConta() - valor);
            return true; // Retorna true se o saque for bem-sucedido
        } else {
            System.out.println("Saque não permitido. Valor excede o limite de crédito."); // MENSAGEM DE ERRO
            return false; // Retorna false se o saque não for permitido
        }
    }
}
