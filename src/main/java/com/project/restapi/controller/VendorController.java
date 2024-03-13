package com.project.restapi.controller;


import com.project.restapi.Service.IVendorService;
import com.project.restapi.model.Vendor;
import java.util.*;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController
@RequestMapping("/api/vendor/")
public class VendorController {
    
    @Autowired
    private IVendorService vendorService;
    
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Vendor vendor){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.save(vendor));
    }
    
    @GetMapping("/{vendorId}")
    public ResponseEntity<?> read(@PathVariable(value="vendorId") Long id){
        
        try{
            
            Optional<Vendor> oVendor = vendorService.findById(id);
        
            if(!oVendor.isPresent()){
                return ResponseEntity.notFound().build();
            }
            
            return ResponseEntity.ok(oVendor);
            
        }catch(Exception e){
            log.info("error");
            log.info(e.getMessage());
        }
        
        return ResponseEntity.notFound().build();
       
    }
    /*
    @GetMapping("{numberOfPages}")
    public void getAllEmails(@PathVariable(value = "numberOfPages") int pages){
        
        Optional<?> allVendorEmails = vendorService.selectAllEmails(Pageable.ofSize(pages));
        log.info(allVendorEmails.get().toString());
    }*/
    
    @GetMapping("/allEmails")
    public  ResponseEntity<?> getAllEmails(){
        
        try{
            Set<Object> allVendorEmails = vendorService.selectAllEmails();
            
            log.info("Data: " + allVendorEmails.toString());
            
            if(allVendorEmails.isEmpty())
                return ResponseEntity.notFound().build();
            
            return ResponseEntity.ok(allVendorEmails);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }

    }
    
    @GetMapping("/allRecords")
    public ResponseEntity<?> getAllVendors(){
        
        
        try{
            Set<Vendor> allVendors = vendorService.selectAllVendors();
            
            if(allVendors.isEmpty())
                return ResponseEntity.notFound().build();
            
            return ResponseEntity.ok(allVendors);
            
            
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
        
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateVendor(@RequestBody Vendor vendor, @PathVariable(value = "id") Long vendorId){
        
        try{
            
            if(!vendorService.findById(vendorId).isPresent()){
                return ResponseEntity.notFound().build();
            }
            
            //BeanUtils.copyProperties(vendor, currentVendor.get());
            vendor.setId(vendorId);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.save(vendor));
            
            
            
        }catch(Exception e){
            log.info("Internal error");
            log.info(e.getMessage());
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCloudVendor(@PathVariable(value = "id")Long vendorId){
        
        try{
            
            if(!vendorService.findById(vendorId).isPresent()){
                return ResponseEntity.notFound().build();
            }
            
            vendorService.deleteById(vendorId);
            
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch(Exception e){
            log.info("error");
            log.info(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
    
}
