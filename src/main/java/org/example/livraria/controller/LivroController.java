package org.example.livraria.controller;

import jakarta.validation.Valid;
import org.example.livraria.model.Livro;
import org.example.livraria.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livraria")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service){
        this.service = service;
    }

    @GetMapping
    public List<Livro> listar(){
        return service.listar();
    }

    @PostMapping
    public Livro salvar(@RequestBody @Valid Livro livro){
        return service.salvar(livro);
    }

    @DeleteMapping("/{id}")
    public void  deletar(@PathVariable Long id){
        service.deletar(id);
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo){
        return service.buscarPorTitulo(titulo);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody @Valid Livro livro){
        return service.atualizar(id, livro);
    }

}
