package com.travelbug.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_id")
        private Long id;

        @Column(name = "customer_first_name")
        private String firstName;

        @Column(name = "customer_last_name")
        private String lastName;

        @Column(name = "address")
        private String address;

        @Column(name = "postal_code")
        private String postal_code;

        @Column(name = "phone")
        private String phone;

        @CreationTimestamp
        @Column(name = "create_date")
        private Date create_date;

        @UpdateTimestamp
        @Column(name = "last_update")
        private Date last_update;

        @ManyToOne
        @JoinColumn(name = "division_id")
        private Division division;

       @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        private Set<Cart> carts;

        public void add(Cart cart) {

                if (carts == null) {
                        carts = new HashSet<>();
                }
                carts.add(cart);
            cart.setCustomer(this);
        }

       public Customer(){}

}
