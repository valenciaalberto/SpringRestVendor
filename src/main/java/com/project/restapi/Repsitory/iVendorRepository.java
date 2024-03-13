package com.project.restapi.Repsitory;

import com.project.restapi.model.Vendor;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//crudRepository crud simple
//jpa repository is better bc it use pagination
@Repository
public interface iVendorRepository extends JpaRepository<Vendor, Long>{
    
    
    @Query(value = "SELECT v.email from #{#entityName} v"
            ,nativeQuery = true)
    //public Optional<Vendor> selectAllEmails();
    public Set<Object> selectAllEmails();
    
    @Query(value = "SELECT * from #{#entityName} v", nativeQuery = true)
    public Set<Vendor> selectAllVendors();
}
