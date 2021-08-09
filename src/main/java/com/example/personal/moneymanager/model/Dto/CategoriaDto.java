package com.example.personal.moneymanager.model.Dto;

import com.example.personal.moneymanager.model.Categoria;

public class CategoriaDto {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaDto() {
    }

    public CategoriaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }
}
