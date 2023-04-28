package com.avanade.apibatalhaaded.model.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.GenericArrayType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "LOG" )
@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ID_JOGO")
    private Long idJogo;

    @Column(name = "PERSONAGEM_ESCOLHIDO")
    private String personagemEscolhido;

    @Column(name = "ADVERSARIO")
    private String adversario;

    @Column(name = "DANO_ATAQUE_CALCULADO")
    private Long danoAtaqueCalculado;

    @Column(name = "DEFESA_CALCULADA")
    private Long defesaCalculada;

    @Column(name = "PV_JODAGA")
    private Long pontosVidaJogada;
}
