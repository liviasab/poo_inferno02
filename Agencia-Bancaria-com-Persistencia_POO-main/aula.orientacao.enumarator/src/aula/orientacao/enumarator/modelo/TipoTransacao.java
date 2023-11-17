package aula.orientacao.enumarator.modelo;

import java.io.Serializable;

public enum TipoTransacao implements Serializable {

    // Definição dos valores da enumeração com um inteiro associado a cada valor
    TRANSFERENCIA_CREDITO(3),
    DEBITO(1),
    CREDITO(2),
    TRANSFERENCIA_DEBITO(4);

    // Campo para armazenar o valor associado a cada valor da enumeração
    private int valor;

    // Construtor privado que associa um valor a cada valor da enumeração
    private TipoTransacao(int valor) {
        this.valor = valor;
    }

    // Método para obter o valor associado a um valor da enumeração
    public int getValor() {
        return valor;
    }

    // Método estático para obter um valor da enumeração com base no valor associado
    public static TipoTransacao getEnumFromValue(int valor) {
        for (TipoTransacao t : values()) {
            if (valor == t.getValor())
                return t;
        }
        return null;
    }
}