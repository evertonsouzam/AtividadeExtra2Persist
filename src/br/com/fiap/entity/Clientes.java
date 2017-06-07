package br.com.fiap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES", catalog = "Atividade2Persist")
@NamedQuery(name = "Clientes.findAll", query = "select c from Clientes c")
public class Clientes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCliente", length = 11)
	private Integer idCliente;
	
	@Column(name = "Nome", length = 45)
	private String nome;
	
	@Column(name = "Email", length = 45)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idCliente")
	private List<Pedidos> pedidos;
	
	
	public Clientes(){
		
	}
	public Clientes(String nome, String email, List<Pedidos> pedidos) {
		super();
		this.nome = nome;
		this.email = email;
		this.pedidos = pedidos;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Pedidos> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	@Override
	public String toString() {
		return "Clientes [idCliente=" + idCliente + ", nome=" + nome + ", email=" + email + ", pedidos=" + pedidos
				+ "]";
	}
	
	

}