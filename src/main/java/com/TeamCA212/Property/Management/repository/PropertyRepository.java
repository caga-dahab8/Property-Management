package com.TeamCA212.Property.Management.repository;


import com.TeamCA212.Property.Management.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
