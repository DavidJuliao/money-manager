package com.example.personal.moneymanager.repository;

import com.example.personal.moneymanager.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
