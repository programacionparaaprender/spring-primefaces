package com.cavanosa.virtual.service;

import com.cavanosa.virtual.entity.StudentEntity;
import java.util.List;
import java.util.Optional;


public interface StudentService {

    public List<StudentEntity> findAll();
    public Optional<StudentEntity> getOneById(Integer id);
    public StudentEntity getFindById(Integer id);
    public Optional<StudentEntity> getOneByFirstName(String nombre);
    public Optional<StudentEntity> getOneByEmail(String email);
    public boolean save(StudentEntity tio);
    public void delete(Integer id);
    public boolean existsById(Integer id);
    public boolean existsByNombre(String nombre);
    public boolean exixtsByEmail(String email);
}
