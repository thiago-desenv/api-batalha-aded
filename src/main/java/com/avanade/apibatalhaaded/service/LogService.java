package com.avanade.apibatalhaaded.service;

import com.avanade.apibatalhaaded.model.log.Log;
import com.avanade.apibatalhaaded.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository repository;

    public List<Log> findAll() {
        return this.repository.findAll();
    }
}
