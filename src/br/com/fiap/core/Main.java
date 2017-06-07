package br.com.fiap.core;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Clientes;
import br.com.fiap.entity.Pedidos;
import br.com.fiap.helper.Helper;

public class Main {

	public static void main(String[] args) {
		Pedidos pedido1 = new Pedidos();
		pedido1.setDescricao("pedido 1");
		pedido1.setData(new Date(5, 5, 17));
		pedido1.setValor(2187.80);
		
		Pedidos pedido2 = new Pedidos();
		pedido2.setDescricao("pedido 2");
		pedido2.setData(new Date(5, 6, 17));
		pedido2.setValor(9999.00);
		
		
		List<Pedidos> pedidos = new ArrayList<>();
		
		pedidos.add(pedido1);
		pedidos.add(pedido2);
		
		
		Clientes cliente = new Clientes();
		
		cliente.setNome("Everton");
		cliente.setEmail("everton@teste.com");
		cliente.setPedidos(pedidos);
		
		try{
			Helper helper = new Helper();
			helper.salvar(cliente);
			helper.listarClientes().forEach(System.out::println);
			
			System.out.println(helper.buscarCliente(cliente.getIdCliente()));
			helper.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}

}
