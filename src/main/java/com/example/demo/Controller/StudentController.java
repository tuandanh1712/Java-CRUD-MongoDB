package com.example.demo.Controller;

import com.example.demo.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.Student;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentServices studentServices;

    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Student students) {
        studentServices.saveorUpdate(students);
        return students.toString();
    }

    @GetMapping(value = "/getall")
    public List<Student> getStudents() {
        return studentServices.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable(name = "id") String _id) {
        student.set_id(_id);
        studentServices.saveorUpdate(student);
        return student;
    }

    @DeleteMapping("/delete/{id}")
    private String deleteStudent(@PathVariable("id") String _id) {
        studentServices.deleteStudent(_id);
        return "Delete success";
    }

    @GetMapping("/search/{id}")
    private Student getStudents(@PathVariable(name = "id") String studentid) {
        return studentServices.getStudentByID(studentid);
    }

}
