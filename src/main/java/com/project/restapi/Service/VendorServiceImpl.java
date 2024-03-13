package com.project.restapi.Service;

import com.project.restapi.Repsitory.iVendorRepository;
import com.project.restapi.model.Vendor;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VendorServiceImpl implements IVendorService {

    @Autowired
    private iVendorRepository vendorRepository;

    @Override
    @Transactional(readOnly=true)
    public Iterable<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Vendor> findAll(Pageable pageable) {
        return vendorRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Vendor> findById(Long id) {
        return vendorRepository.findById(id);
    }

    @Override
    @Transactional
    public Vendor save(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    @Transactional
    public void deleteById(Long vendorId) {
        vendorRepository.deleteById(vendorId);
    }
    /*
    @Override
    public Optional<Vendor> selectAllEmails(Pageable pageable ) {
        return vendorRepository.selectAllEmails(pageable);
    }*/
    
    @Override
    public Set<Object> selectAllEmails() {
        return vendorRepository.selectAllEmails();
    }

    @Override
    public Set<Vendor> selectAllVendors() {
        return vendorRepository.selectAllVendors();
    }
    
    
    

}
