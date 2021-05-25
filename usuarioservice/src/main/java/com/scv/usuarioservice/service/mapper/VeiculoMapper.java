package com.scv.usuarioservice.service.mapper;

import com.scv.usuarioservice.domain.Veiculo;
import com.scv.usuarioservice.service.dto.VeiculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    @Mapping(target = "usuarioId", source = "usuario.id")
    VeiculoDTO toDto(Veiculo veiculo);

    @Mapping(target = "usuario.id", source = "usuarioId")
    Veiculo toEntity(VeiculoDTO veiculoDTO);

    List<VeiculoDTO> toDto(List<Veiculo> veiculos);

    List<Veiculo> toEntity(List<VeiculoDTO> veiculos);
}


