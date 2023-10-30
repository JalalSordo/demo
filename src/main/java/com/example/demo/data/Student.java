package com.example.demo.data;

import com.example.demo.data.Address;
import com.example.demo.data.Mark;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements {@link some class}<br>
 * Some class description <br>
 *
 * @author Jalal Sordo
 * @since 23-Oct-23
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Mark> marks;


    @OneToOne(cascade= CascadeType.ALL)
    private Address address;

    @CachePut(value="addresses", condition="#customer.name=='Tom'")
    public Address getAddress() {
        return address;
    }

    public Student(String name) {
        this.name = name;
        marks = new ArrayList<>();
    }
}
