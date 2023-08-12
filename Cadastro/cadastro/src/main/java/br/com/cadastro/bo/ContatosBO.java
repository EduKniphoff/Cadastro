package br.com.cadastro.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dao.CRUD;
import br.com.cadastro.dao.ContatosDAO;
import br.com.cadastro.model.Contatos;

@Service
public class ContatosBO implements CRUD<Contatos, Long> {
	@Autowired
	private ContatosDAO dao;

	@Override
	public Contatos pesquisaPeloId(Long id) {
		return dao.pesquisaPeloId(id);
	}

	@Override
	public List<Contatos> lista() {
		return dao.lista();
	}

	@Override
	public void insere(Contatos contatos) {
		dao.insere(contatos);

	}

	@Override
	public void atualiza(Contatos contatos) {
		dao.atualiza(contatos);
		
	}

	@Override
	public void remove(Contatos contatos) {
		dao.remove(contatos);
		
	}
	
	

}

