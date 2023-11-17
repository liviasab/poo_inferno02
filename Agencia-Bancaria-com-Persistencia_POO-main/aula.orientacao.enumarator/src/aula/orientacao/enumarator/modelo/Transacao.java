package aula.orientacao.enumarator.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;
    Long id;
    float valor;
    LocalDateTime dataTransacao;
    TipoTransacao tipo;
    Conta contaTransacao;

    // Construtor da classe Transacao para transações sem conta associada
    public Transacao(float valor, LocalDateTime dataTransacao, TipoTransacao tipo) {
        super();
        this.id = (long) (Math.random() * 10000000000L); // Gera um ID aleatório
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipo = tipo;
    }

    // Construtor da classe Transacao para transações com conta associada
    public Transacao(float valor, LocalDateTime dataTransacao, TipoTransacao tipo, Conta contaTransacao) {
        super();
        this.id = (long) (Math.random() * 10000000000L); // Gera um ID aleatório
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipo = tipo;
        this.contaTransacao = contaTransacao;
    }

    // Método toString para retornar uma representação em forma de string do objeto
    @Override
    public String toString() {
        return "Transacao [id=" + id + ", valor=" + valor + ", dataTransacao=" + dataTransacao + ", tipo=" + tipo
                + ", contaTransacao=" + contaTransacao + "]";
    }

    // Método hashCode para gerar um código hash com base no ID da transação
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Método equals para comparar se duas transações são iguais com base no ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transacao other = (Transacao) obj;
        return Objects.equals(id, other.id);
    }
}
