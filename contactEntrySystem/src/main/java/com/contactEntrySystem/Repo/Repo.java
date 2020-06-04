package com.contactEntrySystem.Repo;
import com.contactEntrySystem.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

@Repository
public interface Repo extends JpaRepository<Client, Long>{

}