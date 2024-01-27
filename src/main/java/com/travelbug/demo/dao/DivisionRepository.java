package com.travelbug.demo.dao;

import com.travelbug.demo.entities.CartItem;
import com.travelbug.demo.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface DivisionRepository extends JpaRepository<Division,Long> {
}
