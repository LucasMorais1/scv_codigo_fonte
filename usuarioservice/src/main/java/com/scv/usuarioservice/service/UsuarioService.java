package com.scv.usuarioservice.service;

import com.scv.usuarioservice.domain.Usuario;
import com.scv.usuarioservice.repository.UsuarioRepository;
import com.scv.usuarioservice.service.dto.UsuarioDTO;
import com.scv.usuarioservice.service.excecao.RegraNegocioException;
import com.scv.usuarioservice.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioMapper mapper;

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioMapper mapper, UsuarioRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public UsuarioDTO obterPorId(Long id){
        Usuario usuario = repository.findById(id).orElseThrow(() -> new RegraNegocioException("Usuario não encontrado"));
        return mapper.toDto(usuario);
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.toEntity(usuarioDTO);
        Usuario usarioSalvo = repository.save(usuario);
        return mapper.toDto(usarioSalvo);
    }
}

