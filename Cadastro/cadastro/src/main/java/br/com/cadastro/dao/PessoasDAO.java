package br.com.cadastro.dao;

//Metodos do banco de dados

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Pessoas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PessoasDAO implements CRUD<Pessoas, Long>{

	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public Pessoas pesquisaPeloId(Long id) {
		return entityManager.find(Pessoas.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoas> lista() {
		Query query = entityManager.createQuery("Select c from pessoas c");
		return (List<Pessoas>) query.getResultList();
	}

	@Override
	public void insere(Pessoas pessoas) {
		entityManager.persist(pessoas);
		
	}

	@Override
	public void atualiza(Pessoas pessoas) {
		entityManager.merge(pessoas);
		
	}

	@Override
	public void remove(Pessoas pessoas) {
		entityManager.remove(pessoas);
		
	}

}
