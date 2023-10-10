package br.com.jrggroberto.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
public class MinhaPrimeiraController {

  /**
   * 
   * Métodos de acesso do HTTP
   * GET - Buscar uma informação
   * POST - Add uma informação / dado
   * PUT - Alterar um dado/info
   * DELETE - Remover dado
   * PATCH - alterar somente uma parde dado / info
   * 
   */
  @GetMapping("/")
  public String primeiraMensagem() {
    return "Funcionou";
  }

}
