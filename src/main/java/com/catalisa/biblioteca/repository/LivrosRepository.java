package com.catalisa.biblioteca.repository;

import com.catalisa.biblioteca.model.LivrosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LivrosRepository extends JpaRepository<LivrosModel, Long> {

    @Query(value ="SELECT * FROM tb_livros l where l.autor=?1", nativeQuery = true)
    List<LivrosModel> findByAutor(String autor);
}
