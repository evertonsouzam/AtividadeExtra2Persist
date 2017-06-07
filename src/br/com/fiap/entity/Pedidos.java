package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOS", catalog = "Atividade2Persist")
@NamedQuery(name = "Pedidos.findAll", query = "select p from Pedidos p")
public class Pedidos implements Serializable{

	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "IdPedido", length = 11)
		private Integer idPedido;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "IdCliente")
		private Clientes idCliente;

		@Column(name = "Data")
		private Date data;

		@Column(name = "Descricao", length = 45)
		private String descricao;

		@Column(name = "Valor")
		private Double valor;

		public Integer getIdPedido() {
			return idPedido;
		}

		public void setIdPedido(Integer idPedido) {
			this.idPedido = idPedido;
		}

		public Clientes getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(Clientes idCliente) {
			this.idCliente = idCliente;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		@Override
		public String toString() {
			return "Pedidos [idPedido=" + idPedido + ", idCliente=" + idCliente + ", data=" + data + ", descricao="
					+ descricao + ", valor=" + valor + "]";
		}

	
	
}