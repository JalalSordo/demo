package com.example.demo.data;

import com.example.demo.data.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Implements {@link some class}<br>
 * Some class description <br>
 *
 * @author Jalal Sordo
 * @since 23-Oct-23
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
