package com.cavanosa.virtual.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cavanosa.virtual.entity.StudentEntity;
import com.cavanosa.virtual.repository.StudentRepository;
import com.cavanosa.virtual.service.*;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<StudentEntity> findAll(){
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<StudentEntity> getOneById(Integer id){
        return studentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<StudentEntity> getOneByFirstName(String nombre){
        return studentRepository.findByFirstName(nombre);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<StudentEntity> getOneByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    @Override
    public boolean save(StudentEntity student){
        if(student.getFirstName().length() == 0 || student.getEmail().length() == 0 || student.getLastName().length() == 0) {
            //throw new ElementoVacio("Debe ingresar nombre, email y password");
        	//throw new Exception();
        	return false;
        }
        if(studentRepository.existsByFirstName(student.getFirstName()) || studentRepository.existsByEmail(student.getEmail())) {
            return false;
        }
        studentRepository.save(student);
        return true;
    }

    @Override
    public void delete(Integer id){
    	studentRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Integer id){
        return studentRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByNombre(String nombre){
        return studentRepository.existsByFirstName(nombre);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean exixtsByEmail(String email){
        return studentRepository.existsByEmail(email);
    }

    @Override
    public StudentEntity getFindById(Integer id) {
        Optional<StudentEntity> tioOpt = studentRepository.findById(id);
        if(tioOpt.isPresent()){
            return tioOpt.get();
        }
        return null;
    }
}