package com.scv.usuarioservice.service.mapper;

import com.scv.usuarioservice.domain.Usuario;
import com.scv.usuarioservice.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = {VeiculoMapper.class})
public interface UsuarioMapper {

    UsuarioDTO toDto(Usuario usuario);

    Usuario toEntity(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> toDto(List<Usuario> usuarios);

    List<Usuario> toEntity(List<UsuarioDTO> usuarios);
}
