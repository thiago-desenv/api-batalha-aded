package com.avanade.apibatalhaaded.repository;

import com.avanade.apibatalhaaded.model.log.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
