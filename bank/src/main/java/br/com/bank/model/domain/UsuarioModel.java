package br.com.bank.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data(staticConstructor = "valueOf")
@Entity(name = "tb_usuarios")
@EqualsAndHashCode(of = "cpf")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, name = "p_estaAtivo")
    private Boolean ativo;

    private String nome, email;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "p_telefone_id")
    private TelefoneModel telefone;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "p_enderecos")
    private List<EnderecoModel> enderecoList = new ArrayList<>();

}
