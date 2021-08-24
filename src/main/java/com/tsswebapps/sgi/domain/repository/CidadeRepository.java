package com.tsswebapps.sgi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsswebapps.sgi.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
