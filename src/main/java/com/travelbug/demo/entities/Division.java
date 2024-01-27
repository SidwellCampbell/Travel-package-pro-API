package com.travelbug.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id",nullable = false, updatable = false, insertable = false)
    private Country country;

    @Column(name = "country_id")
    private long country_id;

    @OneToMany(mappedBy = "division")
    private Set<Customer> customers;

    public Division(){};

    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }
}
