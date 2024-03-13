package com.project.restapi.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity(name = "vendors")
@Table(name = "vendors")
public class Vendor implements Serializable{
    
    private static final long serialVersionUID = 4L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    @Column(name = "name", length = 50)
    private String name;
    
    @Column(name = "address", length = 70)
    private String address;
    
    @Column(name = "service", length = 70)
    private String service;
    
    @Column(name = "phone", length = 20, unique=true)
    private String phone;
    
    @Column(name = "email", length = 30, nullable = true, unique=true)
    private String email;
    
    
    public Vendor(){
        
    }
    
    public Vendor(String name, String address, String service, String phone, String email){
        this.name = name;
        this.address = address;
        this.service = service;
        this.phone = phone;
        this.email = email;
    }
    
    
    
    
}