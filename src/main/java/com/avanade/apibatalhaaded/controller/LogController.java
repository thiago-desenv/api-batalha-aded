package com.avanade.apibatalhaaded.controller;

import com.avanade.apibatalhaaded.model.log.Log;
import com.avanade.apibatalhaaded.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/apibatalhaaded")
@Api(value = "Batalha ADED API REST - LOG")
public class LogController {

    @Autowired
    private LogService service;

    @GetMapping("/logs")
    @ApiOperation("Buscar log do jogo")
    public ResponseEntity<List<Log>>  consultarHistoricoJogo() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
