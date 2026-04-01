package org.example.livraria.service;

import org.example.livraria.model.Livro;
import org.example.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository){
        this.repository = repository;
    }

    public List<Livro> listar(){
        return repository.findAll();
    }

    public Livro salvar(Livro livro){
        return repository.save(livro);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Livro buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public List<Livro> buscarPorTitulo(String titulo){
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public Livro atualizar(Long id, Livro livro){
        buscarPorId(id);
        livro.setId(id);
        return repository.save(livro);
    }
}
