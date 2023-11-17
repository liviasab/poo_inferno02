package aula.orientacao.enumarator.modelo;

import java.time.Month;
import java.util.ArrayList;

import aula.orientacao.enumarator.persistencia.ClientePersistencia;

public class Aplicacao {

    public static void main(String[] args) {
        
    	//instância válida
    	ClientePersistencia cp1 = new ClientePersistencia();
    	
    	/*Cliente c1 = new Cliente("001", "Livia");
    	cp1.salvarCliente(c1);
    	
    	
    	System.out.println(cp1.localizarClientePorCPF("001"));
 
    	cp1.removerCliente(c1);
    	
    	cp1.getClientesCadastrados();
    	System.out.println(cp1.getClientesCadastrados());*/
    	
    	Cliente c2 = new Cliente("002", "Gustavo");
    	cp1.salvarCliente(c2);
    	
    	Cliente c3 = new Cliente("003", "Isacc");
    	cp1.salvarCliente(c3);
    	
    	Conta conta1 = new Conta("111");
    	c2.adicionarConta(conta1);
    	cp1.atualizarCliente(c2);
    	
    	Conta conta2 = new Conta("222");
    	c3.adicionarConta(conta2);
    	cp1.atualizarCliente(c3);
    	
    	Conta conta3 = new Conta("333");
    	c3.adicionarConta(conta3);
    	cp1.atualizarCliente(c3);
    	
    	/*cp1.getClientesCadastrados();
    	System.out.println(cp1.getClientesCadastrados());*/
    	conta1.depositar(100f);
    	conta1.sacar(10f);
    	
    	conta3.depositar(100f);
    	conta3.sacar(10f);
    	
    	conta1.transferir(20f,conta2);
 
    	System.out.println(c3.getContas());    	
    	
    	conta2.extrato(2023, Month.NOVEMBER);
    	
    	System.out.println(conta2.getsaldo());
    	
    	System.out.println(c3.balancoo());
    	
    
    	
    	/*//Novo cliente
    	Cliente c1 = new Cliente("111", "Fernando");
    	Cliente c2 = new Cliente("222", "Rita");
    	
    	//Para associar uma conta ou cliente
    	Conta conta1 = new Conta("001");
    	c1.adicionarConta(conta1);
    	Conta conta2 = new Conta("002");
    	c2.adicionarConta(conta2);
    	Conta conta3 = new Conta("003");
    	c2.adicionarConta(conta3);
    	
    	//Depositando
    	conta1.depositar(100f);
    	
    	//sacando
    	conta1.sacar(10f);
    	
    	//Déposito
    	conta1.depositar(100f);
    	
    	//saque
    	conta1.sacar(50f);
    	
    	//Transferencia entre contas
    	conta1.transferir(20f,conta2);
    	
    	//Extrato com base no mês
    	conta1.extrato(2023, Month.NOVEMBER);
    	
    	//Consultar saldo
    	conta1.getsaldo();
    	
    	//Listar clientes cadastrados
    	clientePersistencia.getClientesCadastrados();
    	
    	//Remover conta do cliente
    	clientePersistencia.removerConta(conta1);
    	
    	//Remover cliente
    	clientePersistencia.removerCliente(c1);
    	
    	//Salvando na persistencia
    	
    	clientePersistencia.salvarCliente(c1);
    	clientePersistencia.salvarCliente(c2);
    	
    	//Atualizando a Persistencia
    	
    	clientePersistencia.atualizarCliente(c1);
    	clientePersistencia.atualizarCliente(c2);
    	
    	System.out.println(clientePersistencia.getClientesCadastrados());
    	
    	clientePersistencia.removerCliente(c1);
    	
    	System.out.println(clientePersistencia.getClientesCadastrados());
    	
    	//Consultar o balanço de cada conta
    	
    	System.out.println(c2.balancoo());
    	
    	//Listar contas de um cliente
    	
    	System.out.println(c1.getContas());    	
    	
    	//Listar clientes por cpf
    	System.out.println(clientePersistencia.localizarClientePorCPF("222"));*/
    	
    	
    	
    	

    	



    }
}

