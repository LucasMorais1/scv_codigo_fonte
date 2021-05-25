package com.scv.usuarioservice.service.client;

import com.scv.usuarioservice.domain.FipeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@FeignClient(name = "fipeClient", url = "https://parallelum.com.br/fipe/api/v1/carros/")
public interface FipeClient {

    @GetMapping("marcas")
    List<FipeResponse> getMarcas();

    @GetMapping("marcas/{idMarca}/modelos")
    HashMap<String, List<FipeResponse>> getModelos(@PathVariable("idMarca") String idMarca);

    @GetMapping("marcas/{idMarca}/modelos/{idModelo}/anos")
    List<FipeResponse> getAnos(@PathVariable("idMarca") String idMarca,
                            @PathVariable("idModelo") String idModelo);

    @RequestMapping("/marcas/{idMarca}/modelos/{idModelo}/anos/{ano}")
    HashMap<String,String> getVeiculo(@PathVariable("idMarca") String idMarca,
                       @PathVariable("idModelo") String idModelo,
                       @PathVariable("ano") String ano);
}


