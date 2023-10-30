package com.example.demo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Implements {@link some class}<br>
 * Some class description <br>
 *
 * @author Jalal Sordo
 * @since 30-Oct-23
 */
@Component
public class DummyScheduledJob {

    private StudentRepository studentRepository;

    @Autowired
    public DummyScheduledJob(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Scheduled spring boot Job that runs every 10 seconds prints the count of all students in the db
     */
     @Scheduled(fixedRate = 10000)
        public void run() {
            System.out.println("Student count: " + studentRepository.count());
        }

}
