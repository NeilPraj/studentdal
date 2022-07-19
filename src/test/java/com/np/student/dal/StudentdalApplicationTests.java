package com.np.student.dal;

import com.np.student.dal.entities.Student;
import com.np.student.dal.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentdalApplicationTests {

    @Autowired
    private StudentRepository repo;

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("Neil");
        student.setCourse("noSQL 102: the sequel");
        student.setFee(30d);
        repo.save(student);
    }

    @Test
    void findStudentById() {
        Student student = repo.findById(2L).get();
        System.out.println(student);
    }

    @Test
    void updateStudent() {
        Student student = repo.findById(2L).get();
        student.setFee(40d);
        repo.save(student);
    }

    @Test
    void testDeleteStudent() {
        Student student = repo.findById(2L).get();
        repo.delete(student);
    }
}
