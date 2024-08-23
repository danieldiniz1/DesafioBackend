package com.insurance.api.facade.impl;

import com.insurance.api.facade.SeguroFacade;
import com.insurance.api.model.dto.ResultClienteDTO;
import com.insurance.api.model.dto.ResultadoContratacaoWSDTO;
import com.insurance.api.model.dto.SeguroDisponivelWSDTO;
import com.insurance.api.model.enumeration.TiposSeguroEnum;
import com.insurance.api.service.SeguroService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;
import java.util.PrimitiveIterator;

@Component
public class DefaultSeguroFacade implements SeguroFacade {

    private final SeguroService seguroService;
    private WebClient webClient;

    protected DefaultSeguroFacade (final SeguroService seguroService, final WebClient webClient) {

        this.seguroService = seguroService;
        this.webClient = webClient;
    }

    @Override
    public SeguroDisponivelWSDTO buscarSegurosDisponiveis () {
        return populateListaSeguroDispnivel(seguroService.buscarSegurosDisponiveis());
    }

    @Override
    public ResultadoContratacaoWSDTO contratarSeguro (final String cpf, final TiposSeguroEnum tiposSeguroEnum) {
        String uri = new StringBuilder("/").append(cpf).toString();
        final ResultClienteDTO resultClienteDTO = webClient.get().uri(uri).retrieve()
          .bodyToMono(ResultClienteDTO.class).retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(2)))
          .onErrorResume(e -> fallBackClienteService(cpf, tiposSeguroEnum))
          .block();

        return seguroService.contratarSeguro(resultClienteDTO);
    }

    private Mono<? extends ResultClienteDTO> fallBackClienteService (final String cpf,
      final TiposSeguroEnum tiposSeguroEnum) {
//        TODO lógica aplicada em caso de falha
        return null;
    }

    private SeguroDisponivelWSDTO populateListaSeguroDispnivel (final List<TiposSeguroEnum> tiposSeguroEnums) {
        return new SeguroDisponivelWSDTO(tiposSeguroEnums);
    }

}
