package com.example.demo.repository;

import com.example.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(nativeQuery = true, value = "Select * from clients where name=?1 and last_name=?2 and street=?3 and city=?4 and email=?5")
    Optional<Client> findExact(String name, String secondName, String street, String city, String email);



}
