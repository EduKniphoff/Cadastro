package br.com.cadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cadastro.bo.PessoasBO;
import br.com.cadastro.model.Pessoas;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/cadastro")
public class PessoasController {
	@Autowired
	private PessoasBO bo;
	
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("pessoas", new Pessoas());
		return new ModelAndView("/cadastro/formulario", model);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salva(@Valid @ModelAttribute Pessoas pessoas, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors())
			return "/cadastro/formulario";
		
		if(pessoas.getId()==null) {
			bo.insere(pessoas);
			attr.addFlashAttribute("feedback","Cadastrado com sucesso");
		}
		else {
			bo.atualiza(pessoas);
			attr.addFlashAttribute("feedback","Atualizado com sucesso");
		}
		
		return "redirect:/formulario";
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {
		model.addAttribute("pessoas", bo.lista());
		return new ModelAndView("/cadastro/lista", model);
	}
	@RequestMapping(value = "edita/{id}", method = RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id")Long id, ModelMap model) {
		try {
			model.addAttribute("pessoas", bo.pesquisaPeloId(id));
		}catch (Exception e) {
			e.printStackTrace();
		}
			return new ModelAndView("/cadastro/formulario", model);
		}
	
}
	
