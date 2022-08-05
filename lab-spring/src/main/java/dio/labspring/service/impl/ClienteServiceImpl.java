package dio.labspring.service.impl;

import dio.labspring.model.Cliente;
import dio.labspring.model.ClienteRepository;
import dio.labspring.model.Endereço;
import dio.labspring.model.EndereçoRepository;
import dio.labspring.service.ClienteService;
import dio.labspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EndereçoRepository endereçoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }
    @Override
    public Optional<Cliente> buscarPorId(Long id){
        Optional<Cliente> cliente = clienteRepository.findAllById(id);
        return cliente.get();
    }
    @Override
    public void inserir(Cliente cliente){
        salvarClienteComCep(cliente);
    }



    @Override
    public void atualizar(Long id, Cliente cliente){
        Optional<Cliente> clienteBd = clienteRepository.findAllById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }



    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereço().getCep();
        Endereço endereço = endereçoRepository.findAllById(cep).orElseGet(()->{
            Endereço novoEndereço = viaCepService.consultarCep(cep);
            endereçoRepository.save(novoEndereço);
            return novoEndereço;
        });
        cliente.setEndereço(endereço);
        clienteRepository.save(cliente);
    }
}