package br.com.ifsul.iftur.services;

import br.com.ifsul.iftur.domains.Destination;
import br.com.ifsul.iftur.repository.IDestinationRepository;

// import br.com.ifsul.iftur.repository.IDestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService implements IDestinationService {

    private final IDestinationRepository destinationRepository;

    public DestinationService(IDestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

  

    // Cadastrar
    public Destination cadastrar(Destination destino) {
        destinationRepository.save(destino);
        return destino;
    }

    // Listar
    @Override
    public List<Destination> getAll() {
        return destinationRepository.getAll();
    }

    // Busca ID
    public Destination buscarPorId(int id) {
        return destinationRepository.findById(id);
    }
    
    // BUsca por nome
    @Override
    public List<Destination> buscarPorNome(String nome) {
        return destinationRepository.findByName(nome);
    }

    // Deletar
    public void deletar(int id) {
        destinationRepository.deleteById(id);
    }
}
