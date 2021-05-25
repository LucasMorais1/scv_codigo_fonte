package com.scv.usuarioservice.service;

import com.scv.usuarioservice.domain.FipeResponse;
import com.scv.usuarioservice.domain.Veiculo;
import com.scv.usuarioservice.repository.VeiculoRepository;
import com.scv.usuarioservice.service.client.FipeClient;
import com.scv.usuarioservice.service.dto.VeiculoDTO;
import com.scv.usuarioservice.service.mapper.VeiculoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@Transactional
public class VeiculoService {
    
    private final VeiculoMapper mapper;

    private final VeiculoRepository repository;

    private final FipeClient fipeClient;

    public VeiculoService(VeiculoMapper veiculoMapper, VeiculoRepository repository, FipeClient fipeClient) {
        this.mapper = veiculoMapper;
        this.repository = repository;
        this. fipeClient = fipeClient;
    }

    public VeiculoDTO salvar(VeiculoDTO veiculoDTO) {

        Veiculo veiculo = mapper.toEntity(veiculoDTO);
        veiculo.setValor(getValorVeiculo(veiculoDTO));
        veiculo.setDiaRodizio(this.getDiaRodizio(veiculo.getAnoModelo()));
        Veiculo usarioSalvo = repository.save(veiculo);
        return mapper.toDto(usarioSalvo);
    }

    private String getValorVeiculo(VeiculoDTO veiculoDTO) {
        FipeResponse marca  = fipeClient.getMarcas().stream().filter(
                item -> item.getNome().equals(veiculoDTO.getMarca())).collect(Collectors.toList()).get(0);
        FipeResponse modelo  = fipeClient.getModelos(marca.getCodigo()).get("modelos").stream().filter(
                item -> item.getNome().equals(veiculoDTO.getModelo())).collect(Collectors.toList()).get(0);
        FipeResponse ano  = fipeClient.getAnos(marca.getCodigo(), modelo.getCodigo()).stream().filter(
                item -> item.getNome().split(" ")[0].equals(veiculoDTO.getAnoModelo())).collect(Collectors.toList()).get(0);
        return fipeClient.getVeiculo(marca.getCodigo(), modelo.getCodigo(), ano.getCodigo()).get("Valor");
    }
    
    private String getDiaRodizio(String anoModelo) {
        int ultimoNumeroAno = Integer.parseInt("" + anoModelo.charAt(anoModelo.length()-1));

        if (ultimoNumeroAno <= 1)
            return "segunda-feira";
        else if (ultimoNumeroAno <= 3)
            return "terça-feira";
        else if (ultimoNumeroAno <= 5)
            return "quarta-feira";
        else if (ultimoNumeroAno <= 7)
            return "quinta-feira";
        else
            return "sexta-feira";
    }
}
