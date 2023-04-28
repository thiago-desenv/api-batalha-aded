package com.avanade.apibatalhaaded.controller;

import com.avanade.apibatalhaaded.model.DadosFluxo;
import com.avanade.apibatalhaaded.model.Personagem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping( "/fluxos" )
    @ApiOperation( "Gerar um número aleatório" )
    public int gerarNumeroAleatorioInicioJogo() {
        int facesDados = 20;
        Random random = new Random();
        int valorSorteado = random.nextInt(facesDados) + 1;
        return valorSorteado;
    }

    @GetMapping( "/fluxos/{facesDado}" )
    @ApiOperation( "Gerar um número aleatório pela faces do dado" )
    public int gerarNumeroAleatorioFacesDado(@PathVariable(value = "facesDado") int facesDado) {
        Random random = new Random();
        int valorSorteado = random.nextInt(facesDado) + 1;
        return valorSorteado;
    }

    @GetMapping("/facesDado/{facesDado}/forcas/{forca}/agilidades/{agilidade}")
    @ApiOperation( "Gerar ataque somando a face dado com a força e agilidade" )
    public Long gerarValorAtaque(@PathVariable(value = "facesDado") int facesDado,
                            @PathVariable(value = "forca") Long forca,
                            @PathVariable(value = "agilidade") Long agilidade) {
        Long valorAtaque = facesDado + forca + agilidade;
        return valorAtaque;
    }

    @GetMapping("/facesDado/{facesDado}/defesas/{defesa}/agilidades/{agilidade}")
    @ApiOperation( "Gerar defesa somando a face dado com a defesa e agilidade" )
    public Long gerarValorDefesa(@PathVariable(value = "facesDado") int facesDado,
                            @PathVariable(value = "defesa") Long defesa,
                            @PathVariable(value = "agilidade") Long agilidade) {
        Long valorAtaque = facesDado + defesa + agilidade;
        return valorAtaque;
    }

    @GetMapping("/fluxos/{vida}/ataque/{ataque}")
    @ApiOperation("Subtrair os pontos de vida")
    public Long realizarDanoDeVida(@PathVariable(value = "vida") Long vida, @PathVariable(value = "ataque") Long ataque) {
        Long retornoPV = (vida - ataque);
        return retornoPV;
    }

    @PostMapping("/ataques/{valorAtaque}/defesas/{valorDefesa}/qtdDados/{qtdDados}")
    @ApiOperation("Realiza o cálculo do dano")
    public int realizarCalculoDano(@PathVariable(value = "valorAtaque") Long valorAtaque,
                                  @PathVariable(value = "valorDefesa") Long valorDefesa, @RequestBody List<DadosFluxo> dados) {
        if(valorDefesa >= valorAtaque) {
            return 0;
        }

        int somaDosDados = 0;
        for(DadosFluxo dado : dados) {
            somaDosDados += dado.getValorSorteado();
        }

        return somaDosDados;
    }


}
