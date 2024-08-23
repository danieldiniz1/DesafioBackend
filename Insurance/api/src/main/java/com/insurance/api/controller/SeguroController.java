package com.insurance.api.controller;

import com.insurance.api.facade.SeguroFacade;
import com.insurance.api.model.dto.ResultadoContratacaoWSDTO;
import com.insurance.api.model.dto.SeguroDisponivelWSDTO;
import com.insurance.api.model.enumeration.TiposSeguroEnum;
import com.insurance.api.model.form.ContratarSeguroForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/seguro")
@Tag(name = "Seguros" , description = " Controller gerenciadora de seguros")
public class SeguroController {

    private final SeguroFacade seguroFacade;

    public SeguroController (final SeguroFacade seguroFacade) {this.seguroFacade = seguroFacade;}

    @Operation(summary = "Buscar tipos de seguros", description = "Retorna tipos de seguros disponíveis")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista com seguros disponíveis"),
      @ApiResponse(responseCode = "400", description = "Erro na chamada")})
    @GetMapping("/disponivel")
    public ResponseEntity<SeguroDisponivelWSDTO> disponivel() {

        return ResponseEntity.ok(seguroFacade.buscarSegurosDisponiveis());
    }

    @Operation(summary = "Realiza contratação do seguro", description = "Realiza contratação do seguro com base no cpf e tipo escolhido")
    @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista com seguros disponíveis"),
      @ApiResponse(responseCode = "400", description = "Erro na chamada com descrição no body")})
    @PostMapping("/contratar")
    public ResponseEntity<ResultadoContratacaoWSDTO> disponivel(@RequestBody ContratarSeguroForm form) {

        return ResponseEntity.ok(seguroFacade.contratarSeguro(form.cpf(), TiposSeguroEnum.valueOf(form.tipo())));
    }


}
