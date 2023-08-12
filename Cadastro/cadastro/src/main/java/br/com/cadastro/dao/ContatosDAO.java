package br.com.cadastro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Contatos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ContatosDAO implements CRUD<Contatos, Long>{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public Contatos pesquisaPeloId(Long id) {
		return entityManager.find(Contatos.class, id);
	}

	@Override
	public List<Contatos> lista() {
		Query query = entityManager.createQuery("Select c from Contatos c");
		return (List<Contatos>) query.getResultList();
	}

	@Override
	public void insere(Contatos contatos) {
		entityManager.persist(contatos);
		
	}

	@Override
	public void atualiza(Contatos contatos) {
		entityManager.merge(contatos);
		
	}

	@Override
	public void remove(Contatos contatos) {
		entityManager.remove(contatos);
		
	}

}
