package br.com.neurotech.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data  
@NoArgsConstructor 
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomecompleto;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String empresa;

    @Column(nullable = false)
    private String datanascimento;

    public List<Cursos> getCursos() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getCursos'");
    }


    
}

