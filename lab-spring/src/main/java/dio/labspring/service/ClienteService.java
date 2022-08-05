package dio.labspring.service;

import dio.labspring.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Optional<Cliente> buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
