package com.example.studentmanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    @Test
    void addStudentTest() {

        StudentController controller = new StudentController();

        Student student = new Student(1, "John", "Computer Science");

        Student result = controller.addStudent(student);

        assertEquals(1, result.getId());
        assertEquals("John", result.getName());
        assertEquals("Computer Science", result.getCourse());
    }

    @Test
    void getStudentsTest() {

        StudentController controller = new StudentController();

        controller.addStudent(
                new Student(1, "John", "Computer Science")
        );

        assertEquals(1, controller.getStudents().size());
    }
}