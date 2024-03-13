package com.project.restapi.Service;

import com.project.restapi.model.Vendor;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVendorService {
    
    public Iterable<Vendor> findAll();
    
    public Page<Vendor> findAll(Pageable pageable);
    
    public Optional<Vendor> findById(Long id);
    
    public Vendor save(Vendor vendor);
    
    public void deleteById(Long vendorId);
    
    //public Optional<Vendor> selectAllEmails();
    public Set<Object> selectAllEmails();
    
    public Set<Vendor> selectAllVendors();
    
}
