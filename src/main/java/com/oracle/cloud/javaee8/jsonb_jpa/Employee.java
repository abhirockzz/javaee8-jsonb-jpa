/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.cloud.javaee8.jsonb_jpa;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.config.PropertyOrderStrategy;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author agupgupt
 */
@Entity
@Table(name = "Employees")
@JsonbPropertyOrder(PropertyOrderStrategy.REVERSE)
public class Employee {
    
    @JsonbProperty("emp_email")
    @Id
    private String email;
    private String name;
    
    //@JsonbTransient
    private int salary;
    
    public Employee() {
    }

    public Employee(String email, String name, int salary) {
        this.email = email;
        this.name = name;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    
    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "email=" + email + ", name=" + name + ", salary=" + salary + '}';
    }
    
    
}
