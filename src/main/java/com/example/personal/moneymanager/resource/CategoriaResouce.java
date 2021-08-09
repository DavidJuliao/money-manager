package com.example.personal.moneymanager.resource;

import com.example.personal.moneymanager.model.Categoria;
import com.example.personal.moneymanager.model.Dto.CategoriaDto;
import com.example.personal.moneymanager.model.form.CategoriaForm;
import com.example.personal.moneymanager.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/categorias")
public class CategoriaResouce {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity listarCategorias(){
        return categoriaRepository.findAll().isEmpty()?
                ResponseEntity.ok().build():
                ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity criar(@Valid @RequestBody CategoriaForm categoriaForm, HttpServletResponse response){
        Categoria categoriaSalva = categoriaRepository.save(new Categoria(categoriaForm));
        URI uri = ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/{codigo}")
                                .buildAndExpand(categoriaSalva.getIdCat()).toUri();

        response.setHeader("Location",uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva);
    }

    @GetMapping("/{idCat}")
    public ResponseEntity buscarPorCodigo(@RequestParam Long idCat){
        CategoriaDto categoria = new CategoriaDto(
                Objects.requireNonNull(categoriaRepository.findById(idCat).orElse(null))
        );
        return categoria.getNome()!= null?
                ResponseEntity.ok(categoria):
                ResponseEntity.notFound().build();
    }
}
