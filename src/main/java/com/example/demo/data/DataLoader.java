package com.example.demo.data;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implements {@link some class}<br>
 * Some class description <br>
 *
 * @author Jalal Sordo
 * @since 30-Oct-23
 */
@Slf4j
@Component
public class DataLoader implements ApplicationRunner {

    private StudentRepository studentRepository;

    @Autowired
    public DataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void run(ApplicationArguments args) {
        Instant start = Instant.now();

        for (int i = 0; i < 50000; i++) {
           // Faker faker = new Faker();

            Student student = new Student("some name "+i);
            student.setEmail("email@email.com");
            student.setPhone("01245"+i);
            List<Mark> marks = new ArrayList<>();
            marks.add(new Mark("Math", 8));
            student.setMarks(marks);

            student.setAddress(new Address("test", "test", "test"));
            log.info("Saving student: " + student.getName());
            studentRepository.save(student);
        }
        Instant end = Instant.now();
        log.info("took "+Duration.between(start, end) + " to create all users"); // prints PT1M3.553S

    }
}
