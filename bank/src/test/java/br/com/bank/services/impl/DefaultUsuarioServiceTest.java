package br.com.bank.services.impl;

import br.com.bank.exception.ModelNotFoundException;
import br.com.bank.model.domain.UsuarioModel;
import br.com.bank.repository.UsuarioRepository;
import br.com.bank.service.impl.DefaultUsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DefaultUsuarioServiceTest {

    @InjectMocks
    private DefaultUsuarioService service;

    @Mock
    private UsuarioRepository repository;
    private UsuarioModel usuario;

    @BeforeEach
    public void setup(){
        usuario = UsuarioModel.valueOf();
        populateUsuarioBasico(usuario);
    }


    @Test
    public void shouldCreateNewUserWhenUserModelIsOk(){

        when(repository.save(usuario)).thenReturn(usuario);
        service.criarUsuario(usuario);

        verify(repository, times(1)).save(usuario);
    }

    @Test
    public void shouldThrowExceptionWhenUserCpfAlredyExists (){
        when(repository.save(usuario)).thenThrow(ModelNotFoundException.class);

        Assertions.assertThrows(ModelNotFoundException.class, () -> service.criarUsuario(usuario));
    }

    private void populateUsuarioBasico (final UsuarioModel usuario) {
        usuario.setCpf("12345678900");
        usuario.setEmail("email@email.com");
        usuario.setNome("Nome de teste");
    }

}
