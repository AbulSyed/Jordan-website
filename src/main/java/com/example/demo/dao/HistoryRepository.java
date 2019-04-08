package com.example.demo.dao;

import com.example.demo.domain.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class to access the database table backing the LoginHistory entity.
 */
@Repository
public interface HistoryRepository extends JpaRepository<LoginHistory, String> {
}
