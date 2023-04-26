package com.avanade.apibatalhaaded.repository;

import com.avanade.apibatalhaaded.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long > {
}
