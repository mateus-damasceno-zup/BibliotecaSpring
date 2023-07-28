package com.catalisa.biblioteca.controller;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping(path = "/livros")
    public List<LivrosModel> buscaTodosLivros(){
        return livroService.buscaTodos();
    }

    @GetMapping(path = "/livros/{codigo}")
    public Optional<LivrosModel> buscaLivroPorId(@PathVariable long codigo){
        return livroService.buscaPorId(codigo);
    }

    @GetMapping(path = "/livrosBuscaAutor/{autor}")
    public List<LivrosModel> buscaLivroPorAutor(@PathVariable String autor){
        return livroService.buscaPorAutor(autor);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path ="/livros")
    public LivrosModel cadastraNovoLivro(@RequestBody LivrosModel livrosModel){
        return livroService.cadastraNovoLivro(livrosModel);
    }
    @PutMapping(path="/livros/{codigo}")
    public LivrosModel atualizaCadastro (@PathVariable Long codigo,
                                         @RequestBody LivrosModel livrosModel){
        return livroService.atualizaLivro(codigo, livrosModel);
    }

    @DeleteMapping(path ="/livros/{codigo}")
    public void deletaCadastro (@PathVariable Long codigo){
        livroService.deletaLivro(codigo);
    }
}
