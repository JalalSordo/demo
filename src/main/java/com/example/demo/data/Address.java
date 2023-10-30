package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Implements {@link some class}<br>
 * Some class description <br>
 *
 * @author Jalal Sordo
 * @since 30-Oct-23
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String city;

    private String state;



    public Address(String address, String city, String country) {
        this.address = address;
        this.city = city;
        this.state = country;
    }
}
