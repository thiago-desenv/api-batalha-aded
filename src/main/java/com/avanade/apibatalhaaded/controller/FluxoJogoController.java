package com.avanade.apibatalhaaded.controller;

import com.avanade.apibatalhaaded.model.DadosFluxo;
import com.avanade.apibatalhaaded.model.Personagem;
import com.avanade.apibatalhaaded.service.FluxoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping( value = "/apibatalhaaded" )
@Api( value = "Batalha ADED API REST - FLUXO" )
@CrossOrigin( origins = "*" )
public class FluxoJogoController {

    @Autowired
    private FluxoService service;

    @GetMapping( "/fluxos" )
    @ApiOperation( "Gerar um número aleatório para determinar quem começa o jogo" )
    public int  gerarNumeroAleatorioInicioJogo() {
        return this.service.gerarNumeroAleatorioInicioJogo();
    }

    @GetMapping( "/fluxos/{facesDado}" )
    @ApiOperation( "Gerar um número aleatório pela faces do dado" )
    public int gerarNumeroAleatorioFacesDado(@PathVariable(value = "facesDado") int facesDado) {
        return this.service.gerarNumeroAleatorioFacesDado(facesDado);
    }

    @GetMapping("/facesDado/{facesDado}/forcas/{forca}/agilidades/{agilidade}")
    @ApiOperation( "Gerar ataque somando a face dado com a força e agilidade" )
    public Long gerarValorAtaque(@PathVariable(value = "facesDado") int facesDado,
                            @PathVariable(value = "forca") Long forca,
                            @PathVariable(value = "agilidade") Long agilidade) {
        return this.service.gerarValorAtaque(facesDado, forca, agilidade);
    }

    @GetMapping("/facesDado/{facesDado}/defesas/{defesa}/agilidades/{agilidade}")
    @ApiOperation( "Gerar defesa somando a face dado com a defesa e agilidade" )
    public Long gerarValorDefesa(@PathVariable(value = "facesDado") int facesDado,
                            @PathVariable(value = "defesa") Long defesa,
                            @PathVariable(value = "agilidade") Long agilidade) {
        return this.service.gerarValorDefesa(facesDado, defesa, agilidade);
    }

    @GetMapping("/fluxos/{vida}/ataque/{ataque}")
    @ApiOperation("Subtrair os pontos de vida")
    public Long realizarDanoDeVida(@PathVariable(value = "vida") Long vida, @PathVariable(value = "ataque") Long ataque) {
        return this.service.realizarDanoDeVida(vida, ataque);
    }

    @PostMapping("/ataques/{valorAtaque}/defesas/{valorDefesa}/qtdDados/{qtdDados}")
    @ApiOperation("Realiza o cálculo do dano")
    public int realizarCalculoDano(@PathVariable(value = "valorAtaque") Long valorAtaque,
                                  @PathVariable(value = "valorDefesa") Long valorDefesa, @RequestBody List<DadosFluxo> dados) {
        return this.service.realizarCalculoDano(valorAtaque, valorDefesa, dados);
    }
}
