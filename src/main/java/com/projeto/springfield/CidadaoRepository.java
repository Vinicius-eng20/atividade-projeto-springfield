package com.projeto.springfield;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadaoRepository extends JpaRepository<Cidadao, Integer> {
}
