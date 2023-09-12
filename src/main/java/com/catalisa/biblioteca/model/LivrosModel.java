package com.catalisa.biblioteca.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_livros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column (length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String autor;
    @Column(length = 255, nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String dataLancamento;
}
