package com.avanade.apibatalhaaded.controller;

import com.avanade.apibatalhaaded.model.Personagem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping( value = "/apibatalhaaded" )
@Api( value = "Batalha ADED API REST" )
@CrossOrigin( origins = "*" )
public class FluxoJogoController {

    @GetMapping( "/fluxos" )
    @ApiOperation( "Gera um número aleatório" )
    public int gerarNumeroAleatorioInicioJogo() {
        int facesDados = 20;
        Random valor = new Random();
        int valorSorteado = valor.nextInt(1,facesDados);
        return valorSorteado;
    }

    @GetMapping( "/fluxos" )
    @ApiOperation( "Gera um número aleatório pela faces do dado" )
    public int gerarNumeroAleatorioFacesDado(int facesDado) {
        return 0;
    }
}
