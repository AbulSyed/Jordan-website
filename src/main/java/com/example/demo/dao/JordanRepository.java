package com.example.demo.dao;


import com.example.demo.domain.JordanUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class to access the database table backing the JordanUser entity.
 */
@Repository
public interface JordanRepository extends JpaRepository<JordanUser, String> {


}
