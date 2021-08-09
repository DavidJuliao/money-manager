package com.example.personal.moneymanager.model;

import com.example.personal.moneymanager.model.form.CategoriaForm;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCat;

    @NotNull
    @Column
    private String nome;

    public long getIdCat() {
        return idCat;
    }

    public void setIdCat(long idCat) {
        this.idCat = idCat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria() {
    }

    public Categoria(CategoriaForm categoriaForm) {
        this.nome = categoriaForm.getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return idCat == categoria.idCat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCat);
    }
}
