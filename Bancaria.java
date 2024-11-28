/*Exercício 1 – Desenvolva os seguintes códigos 
1. Classe: ContaBancaria 
Variáveis de instância: 
    - cliente (String) 
    - numeroConta (int) 
    - saldoConta (float) 
métodos: 
    - gets e sets 
    - sacarValor (não permite valor negativo) 
    - depositarValor  
*/

import java.util.Scanner;

//SUPER-CLASSE
class Bancaria {
    private String cliente;
    private int numConta;
    private double saldoConta;

    //CONSTRUTORES
    public Bancaria(String cliente, int numConta, double saldoConta) {
        this.cliente = cliente;
        this.numConta = numConta;
        this.saldoConta = saldoConta;
    }

    // GETTERS E SETTERS
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    //METODO P/ SACAR VALOR
    public boolean sacarValor(double valor) {
        // Implementação do saque na classe Bancaria
        return false; // Este é apenas um exemplo; você deve implementar a lógica real.
    }


    //METODO P/ DEPOSITAR VALOR
    public void depositarValor(double valor){
        if (valor > 0){
            saldoConta += valor;
            System.out.println("Deposito realizado. Novo saldo: " + saldoConta);
        }else {
            System.out.println("Depósito inválido. Valor deve ser positivo.");
        }
    }
}
