package com.cavanosa.virtual.repository;

import com.cavanosa.virtual.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    Optional<StudentEntity> findByFirstName(String firstName);
    Optional<StudentEntity> findByEmail(String email);
    boolean existsByFirstName(String nombre);
    boolean existsByEmail(String email);
}
