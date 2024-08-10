package com.TeamCA212.Property.Management.service;


import com.TeamCA212.Property.Management.Custom.ResourceNotFoundException;
import com.TeamCA212.Property.Management.model.Property;
import com.TeamCA212.Property.Management.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found"));
    }

    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property updateProperty(Long id, Property propertyDetails) {
        Property property = getPropertyById(id);
        property.setAddress(propertyDetails.getAddress());
        property.setOwnerName(propertyDetails.getOwnerName());
        property.setRentalPrice(propertyDetails.getRentalPrice());
        property.setStatus(propertyDetails.getStatus());
        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        Property property = getPropertyById(id);
        propertyRepository.delete(property);
    }
}
