package br.com.cadastro.bo;

//Classe de Serviço 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dao.CRUD;
import br.com.cadastro.dao.PessoasDAO;
import br.com.cadastro.model.Pessoas;

@Service
public class PessoasBO implements CRUD<Pessoas, Long> {
	@Autowired
	private PessoasDAO dao;

	@Override
	public Pessoas pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<Pessoas> lista() {
		return dao.lista();
	}

	@Override
	public void insere(Pessoas pessoas) {
		dao.insere(pessoas);
		
	}

	@Override
	public void atualiza(Pessoas pessoas) {
		dao.atualiza(pessoas);
		
	}

	@Override
	public void remove(Pessoas pessoas) {
		dao.remove(pessoas);
		
	}
	
	

}
