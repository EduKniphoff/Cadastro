package br.com.cadastro.bo;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.cadastro.model.Pessoas;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class PessoasBOTest {
	
	@Autowired
	private PessoasBO bo;
	
	@Test
	@Order(1)
	public void insere() {
		Pessoas pessoas = new Pessoas();
		pessoas.setNome("Eduardo Domenes");
		pessoas.setCpf("34584652018");
		pessoas.setDataDeNascimento(LocalDate.of(2000,1,22));
		
		
	}
	
	@Test
	@Order(2)
	public void pesquisaPeloId() {
		Pessoas pessoas =  bo.pesquisaPeloId(1L);
		System.out.println(pessoas);
	}
	
	@Test
	@Order(3)
	public void atualiza() {
		Pessoas pessoas = bo.pesquisaPeloId(1L);
		pessoas.setCpf("98765432111");
		bo.atualiza(pessoas);
	}
	
	

}
