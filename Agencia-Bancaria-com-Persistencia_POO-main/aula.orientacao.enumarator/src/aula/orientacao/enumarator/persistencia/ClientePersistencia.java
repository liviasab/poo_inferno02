package aula.orientacao.enumarator.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import aula.orientacao.enumarator.modelo.Cliente;
import aula.orientacao.enumarator.modelo.Conta;

public class ClientePersistencia {

    ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    ArrayList<Conta> contas = new ArrayList<>();

    public void ContasCadastradas() {
        contas = new ArrayList<>();
        carregarArquivo();
    }
    
    // Método para obter a lista de contas cadastradas
    public ArrayList<Conta> getContas() {
		return contas;
    }
    
    //Cadastras Cliente
    public void adicionarConta(Conta c) {
		if (!contas.contains(c))
            contas.add(c);
        else
            System.out.println("Conta cadastrada");
    }
    
    // Construtor da classe ClientePersistencia
    public ClientePersistencia() {
        clientesCadastrados = new ArrayList<>();
        carregarArquivo();
    }
    //Listar os clientes cadastrados
    public ArrayList<Cliente> getClientesCadastrados(){
    	return clientesCadastrados;
    }
    // Método para salvar um cliente
    public void salvarCliente(Cliente c) {
        if (!clientesCadastrados.contains(c)) {
            clientesCadastrados.add(c);
            salvarArquivo();
        } else
            System.out.println("Cliente já cadastrado");
    }

    // Método para remover um cliente
    public void removerCliente(Cliente c) {
        if (clientesCadastrados.contains(c))
            clientesCadastrados.remove(c);
        else
            System.out.println("Cliente não encontrado");
    }
    
    // Remover conta
    public void removerConta(Conta c) {
		if (contas.contains(c))
            contas.remove(c);
        else
            System.out.println("Cliente não encontrado");
    }
    
    public float balanco() {
    	float saldoTotal = 0f;
		for (Conta conta : contas) {
			saldoTotal += conta.getsaldo ();
		}
		return saldoTotal;
    	
    }
    
    /*public boolean removerClientePorCPF(String cpf) {
        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getClass().equals(cpf)) {
                clientesCadastrados.remove(cliente);
                salvarArquivo(); // Salva as alterações no arquivo
                return true; // Cliente removido com sucesso
            }
        }
        return false; // Cliente com o CPF não encontrado
    }*/


    // Método para localizar um cliente por CPF
    public Cliente localizarClientePorCPF(String cpf) {
        Cliente temp = new Cliente(cpf, null);
        if (clientesCadastrados.contains(temp)) {
            int index = clientesCadastrados.indexOf(temp);
            temp = clientesCadastrados.get(index);
            return temp;
        }
        return null;
    }

    // Método para atualizar as informações de um cliente
    public void atualizarCliente(Cliente c) {
        if (clientesCadastrados.contains(c)) {
            int index = clientesCadastrados.indexOf(c);
            clientesCadastrados.set(index, c);
            salvarArquivo();
        }
    }
    
    public void atualizarConta(Conta c2) {
        if (contas.contains(c2)) {
            int index = contas.indexOf(c2);
            contas.set(index, c2);
            salvarArquivo();
        }
    }

    // Método privado para carregar dados de um arquivo
    private void carregarArquivo() {
        try {
            FileInputStream fis = new FileInputStream("dados");
            ObjectInputStream ois = new ObjectInputStream(fis);
            clientesCadastrados = (ArrayList<Cliente>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método privado para salvar dados em um arquivo
    private void salvarArquivo() {
        try {
            FileOutputStream fos = new FileOutputStream("dados");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientesCadastrados);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
