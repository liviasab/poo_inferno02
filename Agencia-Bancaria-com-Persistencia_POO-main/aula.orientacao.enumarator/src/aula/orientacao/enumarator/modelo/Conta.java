package aula.orientacao.enumarator.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;

public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
    String numero;
    float saldo;
    LocalDateTime dataAbertura;
    boolean status;

    // ArrayList para armazenar as transações associadas a esta conta
    private ArrayList<Transacao> transacoes = new ArrayList<>();

    // Construtor da classe Conta que recebe o número da conta como parâmetro
    public Conta(String numero) {
        super();
        this.numero = numero;
        this.saldo = 0f;
        this.dataAbertura = LocalDateTime.now();
        this.status = true;
    }

    // Método toString para retornar uma representação em forma de string do objeto
    @Override
    public String toString() {
        return "Conta [numero=" + numero + ", saldo=" + saldo + ", dataAbertura=" + dataAbertura + ", status=" + status
                + "]";
    }

    // Método hashCode para gerar um código hash com base no número da conta
    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    // Método equals para comparar se duas contas são iguais com base no número da conta
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conta other = (Conta) obj;
        return Objects.equals(numero, other.numero);
    }

    // Método para depositar uma quantia na conta
    public void depositar(float quantia) {
        if (status && quantia > 0) {
            saldo += quantia;
            transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.CREDITO));
        } else
            System.out.println("Depósito não realizado");
    }

    // Método para sacar uma quantia da conta
    public void sacar(float quantia) {
        if (status && quantia > 0 && quantia <= saldo) {
            saldo -= quantia;
            transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.DEBITO));
        } else
            System.out.println("Operação não pode ser realizada");
    }

    // Método para exibir o extrato das transações da conta em um ano e mês específicos
    public void extrato(int year, Month month) {
        for (Transacao t : transacoes) {
            if (t.dataTransacao.getYear() == year && t.dataTransacao.getMonth() == month) {
                System.out.println(t);
            }
        }
    }

    // Método para transferir uma quantia para outra conta
    public void transferir(float quantia, Conta contaDestino) {
        if (this.status && contaDestino.status && quantia > 0 && quantia <= this.saldo) {
            this.saldo -= quantia;
            contaDestino.saldo += quantia;
            this.transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.TRANSFERENCIA_DEBITO, contaDestino));
            contaDestino.transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.TRANSFERENCIA_CREDITO, this));
        }
    }

    // Método estático para transferir uma quantia de uma conta de origem para uma conta de destino
    public static void transferir(float quantia, Conta origem, Conta destino) {
        if (origem.status && destino.status && quantia > 0 && quantia <= origem.saldo) {
            origem.saldo -= quantia;
            destino.saldo += quantia;
            origem.transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.TRANSFERENCIA_DEBITO, destino));
            destino.transacoes.add(new Transacao(quantia, LocalDateTime.now(), TipoTransacao.TRANSFERENCIA_CREDITO, origem));
        }
    }
 // Consultar o saldo
    public float getsaldo() {
    	return saldo;
    }



}
