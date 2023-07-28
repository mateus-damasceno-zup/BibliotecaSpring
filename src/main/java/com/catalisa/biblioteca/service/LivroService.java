package com.catalisa.biblioteca.service;

import com.catalisa.biblioteca.model.LivrosModel;
import com.catalisa.biblioteca.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivrosRepository livrosRepository;

    public List<LivrosModel> buscaTodos(){
        return livrosRepository.findAll();
    }

    public Optional<LivrosModel> buscaPorId(Long codigo){
        return livrosRepository.findById(codigo);
    }

    public List<LivrosModel> buscaPorAutor(String autor){
        return livrosRepository.findByAutor(autor);
    }


    public LivrosModel cadastraNovoLivro(LivrosModel livrosModel){
        livrosModel.getCodigo();
        livrosModel.getNome();
        livrosModel.getAutor();
        livrosModel.getDataLancamento();
        return livrosRepository.save(livrosModel);
    }

    public LivrosModel atualizaLivro(Long codigo, LivrosModel livrosModel){

        LivrosModel livroAtualizado = buscaPorId(codigo).get();

        if(livrosModel.getNome()!=null){
            livroAtualizado.setNome(livrosModel.getNome());
        }
        if(livrosModel.getAutor()!= null){
            livroAtualizado.setAutor(livrosModel.getAutor());
        }
        if(livrosModel.getDataLancamento()!=null){
            livroAtualizado.setDataLancamento(livrosModel.getDataLancamento());
        }
        return livrosRepository.save(livroAtualizado);
    }

    public void deletaLivro(Long codigo){
        livrosRepository.deleteById(codigo);
    }

}
