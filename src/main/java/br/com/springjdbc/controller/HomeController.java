package br.com.springjdbc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.springjdbc.dao.ProdutoDAO;
import br.com.springjdbc.model.Produto;

@Controller
@RequestMapping("/")
public class HomeController implements Serializable{
	
	private static final long serialVersionUID = 1816092978275003030L;
	
	ProdutoDAO produtoDao = new ProdutoDAO();
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		
		List<Produto> produtos = new ArrayList<>();
		
		produtos = produtoDao.listarTodos();
		
		
		modelAndView.addObject("produtos", produtos);
		modelAndView.addObject("produto", new Produto());
		
		
		
		for(Produto produto : produtos) {
			System.out.println(produto.getId() + " - " + produto.getNome() + " - " + produto.getDescricao());
		}
		
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView salvar(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("home");
		
		List<Produto> produtos = new ArrayList<>();
		
		if(produto.getId() == null) {
			produtoDao.salvar(produto);
		}else {
			produtoDao.atualizar(produto);
		}

		
		produtos = produtoDao.listarTodos();
		
		modelAndView.addObject("produtos", produtos);
		modelAndView.addObject("produto", new Produto());
		

		
		return modelAndView;
	}
	
	@RequestMapping(value="editar/{id}", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");

		
		Produto produto = produtoDao.buscaPorId(id);
		List<Produto> produtos = produtoDao.listarTodos();
		
		
		modelAndView.addObject("produto", produto);
		modelAndView.addObject("produtos", produtos);
		
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="remover/{id}", method=RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id) {

		Produto produto = produtoDao.buscaPorId(id);
		
		produtoDao.remove(produto);

		
		
		return "redirect:/";
	}

	
}
