package com.example.back.repository;

import com.example.back.model.Meuble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MeubleRepository extends JpaRepository<Meuble, Long> {

}
