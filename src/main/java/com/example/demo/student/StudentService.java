package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        if(studentRepository.findOneByEmail(student.getEmail()) != null){
            throw new StudentException("Student with email : ["+student.getEmail()+"] already exist");
        }
        studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        if(studentRepository.findById(id).isEmpty()){
            throw new StudentException("Student with id : ["+id+"] already deleted");
        }
        studentRepository.deleteById(id);
    }
}
