package com.avanade.apibatalhaaded.service;

import com.avanade.apibatalhaaded.model.DadosFluxo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FluxoService {

    public int gerarNumeroAleatorioInicioJogo() {
        int facesDados = 20;
        Random random = new Random();
        int valorSorteado = random.nextInt(facesDados) + 1;
        return valorSorteado;
    }

    public int gerarNumeroAleatorioFacesDado(int facesDado) {
        Random random = new Random();
        int valorSorteado = random.nextInt(facesDado) + 1;
        return valorSorteado;
    }

    public Long gerarValorAtaque(int facesDado, Long forca, Long agilidade) {
        Long valorAtaque = facesDado + forca + agilidade;
        return valorAtaque;
    }

    public Long gerarValorDefesa(int facesDado, Long defesa, Long agilidade) {
        Long valorAtaque = facesDado + defesa + agilidade;
        return valorAtaque;
    }

    public Long realizarDanoDeVida( Long vida, Long ataque) {
        Long retornoPV = (vida - ataque);
        return retornoPV;
    }

    public int realizarCalculoDano(Long valorAtaque, Long valorDefesa, List<DadosFluxo> dados) {
        if (valorDefesa >= valorAtaque) {
            return 0;
        }

        int somaDosDados = 0;
        for (DadosFluxo dado : dados) {
            somaDosDados += dado.getValorSorteado();
        }

        return somaDosDados;
    }
}
