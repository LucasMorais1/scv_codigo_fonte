package com.scv.usuarioservice.web.rest;

import com.scv.usuarioservice.service.VeiculoService;
import com.scv.usuarioservice.service.dto.VeiculoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoResource {

    private final VeiculoService service;

    public VeiculoResource(VeiculoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> salvar(@RequestBody @Valid VeiculoDTO veiculoDTO) throws URISyntaxException {
        return ResponseEntity.created(new URI("/api/veiculos")).body(service.salvar(veiculoDTO));
    }
}
