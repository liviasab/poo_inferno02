package aula.orientacao.enumarator.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    String cpf;
    String nome;
    private ArrayList<Conta> contas = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
	
   

    // Construtor da classe Cliente que recebe o CPF e nome como parâmetros
    public Cliente(String cpf, String nome) {
        super();
        this.cpf = cpf;
        this.nome = nome;
    }

    // Método para adicionar uma conta ao cliente
    public void adicionarConta(Conta c) {
        if (!contas.contains(c))
            contas.add(c);
        else
            System.out.println("Conta cadastrada");
    }

    // Método para remover uma conta do cliente
    public void removerConta(Conta c) {
        if (contas.contains(c))
            contas.remove(c);
        else
            System.out.println("Conta inexistente");
    }

    // Método para localizar uma conta do cliente por número
    public Conta localizarContaPorNumero(String numero) {
        Conta temp = new Conta(numero);
        if (contas.contains(temp)) {
            int index = contas.indexOf(temp);
            temp = contas.get(index);
            return temp;
        } else
            return null;
    }

    // Método para atualizar uma conta do cliente
    public void atualizarConta(Conta c) {
        if (contas.contains(c)) {
            int index = contas.indexOf(c);
            contas.set(index, c);
        } else
            System.out.println("Conta não localizada");
    }

    // Método toString para retornar uma representação em forma de string do objeto
    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", contas=" + contas + "]";
    }

    // Método hashCode para gerar um código hash com base no CPF do cliente
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    // Método equals para comparar se dois objetos Cliente são iguais com base no CPF
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(cpf, other.cpf);
    }
    
    public float balancoo() {
    	float saldoTotal = 0f;
		for (Conta conta : contas) {
			saldoTotal += conta.getsaldo ();
		}
		return saldoTotal;
    	
    }

    public ArrayList<Conta> getContas() {
		return contas;
    }

	
    
}
