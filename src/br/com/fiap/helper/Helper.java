package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Clientes;

public class Helper implements AutoCloseable {
	private EntityManager em;
    private EntityManagerFactory emf;
    
	public Helper() {
		this.emf = Persistence.createEntityManagerFactory("AtividadeExtra2Persist");
		this.em = emf.createEntityManager();
	}

	public void salvar(Clientes cliente) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			
		}
	}

	public List<Clientes> listarClientes() {
		TypedQuery<Clientes> query = em.createQuery("select c from Clientes c" , Clientes.class);
		return query.getResultList();
	}

	public Clientes buscarCliente(Integer idCliente){
		TypedQuery<Clientes> query = em.createQuery("select c from Clientes c where idcliente  =" + idCliente, Clientes.class);
		
		return query.getSingleResult();
		}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		em.close();
		emf.close();
	}

}
