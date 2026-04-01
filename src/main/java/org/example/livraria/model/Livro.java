package org.example.livraria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Autor é obrigatório")
    private String autor;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "O preço deve ser positivo")
    private Double preco;

    @Min(0)
    private Integer estoque;

    @NotBlank(message = "ISBN é obrigatório")
    @Column(unique = true)
    private String isbn;

    public Livro(){}
}
