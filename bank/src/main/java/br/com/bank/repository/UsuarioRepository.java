package br.com.bank.repository;

import br.com.bank.model.domain.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,String> {

    Optional<UsuarioModel> findByCpf(String cpf);

}
