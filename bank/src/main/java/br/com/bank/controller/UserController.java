package br.com.bank.controller;

import br.com.bank.facade.UsuarioFacade;
import br.com.bank.model.dto.UsuarioWSDTO;
import br.com.bank.model.form.UsuarioForm;
import br.com.bank.model.form.UsuarioUpdateForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
@Tag(name = "Cliente", description = "Operações relacionadas ao cliente")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger();

    private final UsuarioFacade usuarioFacade;

    public UserController (final UsuarioFacade usuarioFacade) {this.usuarioFacade = usuarioFacade;}

    @Operation(summary = "Buscar usuário por CPF", description = "Retorna um usuário pelo CPF fornecido")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
      @ApiResponse(responseCode = "400", description = "Existe algum erro no formulário")})
    @GetMapping("/{cpf}")
    public ResponseEntity<UsuarioWSDTO> buscarUsuario (@PathVariable String cpf) {

        return ResponseEntity.status(200).body(usuarioFacade.buscarClientePorCpf(cpf));
    }

    @Operation(summary = "Cadastro de usuário", description = "Cadastra um usuário com os dados do formulário")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Usuário cadastrado"),
      @ApiResponse(responseCode = "400", description = "Existe algum erro no formulário")})
    @PostMapping("/cadastro")
    public ResponseEntity cadastrarUsuario (@Valid @RequestBody UsuarioForm usuarioForm) {
        usuarioFacade.criarUsuario(usuarioForm);
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Atualiza nome do usuário por CPF", description = "Atualiza o nome do usuario buscando pelo cpf")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "nome do usuário alterado"),
      @ApiResponse(responseCode = "400", description = "erro nos parametros")})
    @PatchMapping()
    public ResponseEntity atualizarNome (@Valid @RequestBody UsuarioUpdateForm usuarioUpdateForm) {
        usuarioFacade.atualizarNomeUsuario(usuarioUpdateForm);
        return ResponseEntity.status(200).build();
    }

    @Operation(summary = "Remove usuário por CPF", description = "Faz a exclusão Lógica do usuário do sistema")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Usuário removido"),
      @ApiResponse(responseCode = "400", description = "Erro nos parametros")})
    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarUsuario (@PathVariable String cpf) {
        usuarioFacade.removerUsuario(cpf);
        return ResponseEntity.status(200).build();
    }

}
