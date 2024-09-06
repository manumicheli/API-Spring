package br.com.neurotech.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String corFundo;

    @Column(nullable = false)
    private String corTexto;

    @Column(nullable = false)
    private String fonte;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
