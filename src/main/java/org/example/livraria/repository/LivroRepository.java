package org.example.livraria.repository;

import org.example.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository <Livro, Long>{
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
}
